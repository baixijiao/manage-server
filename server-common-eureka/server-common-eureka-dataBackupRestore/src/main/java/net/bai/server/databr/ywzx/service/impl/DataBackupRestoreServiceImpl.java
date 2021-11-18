package net.bai.server.databr.ywzx.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.bai.server.databr.util.MySqlBackupRestoreUtils;
import net.bai.server.databr.ywzx.service.IDataBackupRestoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author baixj
 * @Description: dataBR项目备份还原数据库服务接口实现类
 * @date 2021/11/16 15:05
 */
@Service
@Transactional
@Slf4j
public class DataBackupRestoreServiceImpl implements IDataBackupRestoreService {
    @Override
    public boolean backup(String host, String port, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception {
        return MySqlBackupRestoreUtils.backup(host, port, userName, password, backupFolderPath, fileName, database);
    }

    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database) throws Exception {
        return MySqlBackupRestoreUtils.restore(restoreFilePath, host, userName, password, database);
    }
}
