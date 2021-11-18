package net.bai.server.databr.ywzx.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.bai.server.databr.config.BackupRestoreDatasourceProperties;
import net.bai.server.databr.constant.DataBackupRestoreConstants;
import net.bai.server.databr.util.FileUtils;
import net.bai.server.databr.ywzx.service.IDataBackupRestoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author baixj
 * @Description: dataBR项目备份还原数据库服务入口
 * @date 2021/11/16 14:40
 */
@Api(value = "/commonBackupRestore", tags = "dataBR项目备份还原数据库服务入口")
@RestController
@RequestMapping("/commonBackupRestore")
@Slf4j
public class DataBackupRestoreController {

    @Autowired
    private IDataBackupRestoreService dataBackupRestoreService;

    @Autowired
    private BackupRestoreDatasourceProperties dataProperties;

    @ApiOperation(value = "根据指定信息备份数据库", notes = "根据指定信息备份数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "backupFolderPath", value = "备份的脚本路径"),
            @ApiImplicitParam(name = "fileName", value = "备份的文件名")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @PostMapping("/backup")
    public String backup(@RequestParam(required = false) String backupFolderPath, @RequestParam(required = false) String fileName,
                         @RequestParam(required = false) String database, @RequestParam(required = false,defaultValue = "3306")String port) {
        String backupFodlerName = DataBackupRestoreConstants.DEFAULT_BACKUP_NAME + "_" + (new SimpleDateFormat(DataBackupRestoreConstants.DATE_FORMAT)).format(new Date());

        backupFolderPath = DataBackupRestoreConstants.BACKUP_FOLDER + backupFodlerName + File.separator;
        fileName = DataBackupRestoreConstants.BACKUP_FILE_NAME;
        boolean backup = false;
        try {
            backup = dataBackupRestoreService.backup(dataProperties.getHost(), port, dataProperties.getUsername(),
                    dataProperties.getPassword(), backupFolderPath, fileName, dataProperties.getDatabase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (backup) {
            log.error("数据备份失败");
        }

        return "";
    }

    @ApiOperation(value = "根据指定信息还原数据库", notes = "根据指定信息还原数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "restoreFilePath", value = "数据库备份的脚本路径")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @PostMapping("/restore")
    public String restore(@RequestParam(required = false) String restoreFilePath) {
        restoreFilePath = DataBackupRestoreConstants.RESTORE_FOLDER + restoreFilePath;

        boolean restore = false;
        try {
            restore = dataBackupRestoreService.restore(restoreFilePath, dataProperties.getHost(), dataProperties.getUsername(),
                    dataProperties.getPassword(), dataProperties.getDatabase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (restore) {
            log.error("还原备份失败");
        }
        return "";

    }

    @ApiOperation(value = "查询所有备份记录", notes = "查询所有备份记录")
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @GetMapping("/findRecords")
    public List<Map<String, String>> findBackupRecords() {
        if(!new File(DataBackupRestoreConstants.DEFAULT_RESTORE_FILE).exists()) {
            // 初始默认备份文件
            backup(null, null, null, null);
        }
        List<Map<String, String>> backupRecords = new ArrayList<>();
        File restoreFolderFile = new File(DataBackupRestoreConstants.RESTORE_FOLDER);
        if(restoreFolderFile.exists()) {
            for(File file:restoreFolderFile.listFiles()) {
                Map<String, String> backup = new HashMap<>();
                backup.put("name", file.getName());
                backup.put("title", file.getName());
                if(DataBackupRestoreConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(file.getName())) {
                    backup.put("title", "系统默认备份");
                }
                backupRecords.add(backup);
            }
        }
        // 排序，默认备份最前，然后按时间戳排序，新备份在前面
        backupRecords.sort((o1, o2) -> DataBackupRestoreConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o1.get("name")) ? -1
                : DataBackupRestoreConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o2.get("name")) ? 1 : o2.get("name").compareTo(o1.get("name")));
        return backupRecords;
    }

    @ApiOperation(value = "删除指定的备份记录", notes = "删除指定的备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "restoreFileName", value = "数据库备份的文件名称")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @GetMapping("/delete")
    public String deleteBackupRecord(@RequestParam String restoreFileName) {
        if(DataBackupRestoreConstants.DEFAULT_BACKUP_NAME.equals(restoreFileName)) {
            return "系统默认备份无法删除!";
        }
        String restoreFilePath = DataBackupRestoreConstants.BACKUP_FOLDER + restoreFileName;
        try {
            FileUtils.deleteFile(new File(restoreFilePath));
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }


}
