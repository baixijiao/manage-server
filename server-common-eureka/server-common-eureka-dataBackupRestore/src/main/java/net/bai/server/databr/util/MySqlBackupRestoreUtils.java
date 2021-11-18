package net.bai.server.databr.util;

import java.io.File;
import java.io.IOException;

/**
 * @Author baixj
 * @Description: 数据库备份还原的工具类
 * @date 2021/11/16 15:37
 */
public class MySqlBackupRestoreUtils {

    /**
     * 备份数据库
     *
     * @param host             IP地址
     * @param port             端口
     * @param userName         用户名
     * @param password         密码
     * @param backupFolderPath 备份的脚本路径
     * @param fileName         备份的文件名
     * @param database         数据库名称
     * @return
     * @throws Exception
     */
    public static boolean backup(String host, String port, String userName, String password,
                                 String backupFolderPath, String fileName, String database) throws Exception {
        File backupFolderFile = new File(backupFolderPath);
        if (!backupFolderFile.exists()) {
            // 如果目录不存在则创建
            backupFolderFile.mkdirs();
        }
        if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
            backupFolderPath = backupFolderPath + File.separator;
        }
        // 拼接命令行的命令
        String backupFilePath = backupFolderPath + fileName;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump --opt").append(" --column-statistics=0").append(" --add-drop-database").append(" --add-drop-table ");
        stringBuilder.append(" -h").append(host).append(" -P").append(port).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" --default-character-set=utf8").append(" --max-allowed-packet=100MB").append(" --databases ").append(database);
        stringBuilder.append(" --result-file=").append(backupFilePath);
        // 调用外部执行 exe 文件的 Java API
        Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
        if (process.waitFor() == 0) {
            // 0 表示线程正常终止
            System.out.println("数据已经备份到 " + backupFilePath + " 文件中");
            return true;
        }
        return false;
    }

    /**
     * 还原数据库
     *
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host            IP地址
     * @param userName        用户名
     * @param password        密码
     * @param database        数据库名称
     * @return
     * @throws Exception
     */
    public static boolean restore(String restoreFilePath, String host, String userName,
                                  String password, String database) throws Exception {
        File restoreFile = new File(restoreFilePath);
        if (restoreFile.isDirectory()) {
            for (File file : restoreFile.listFiles()) {
                if (file.exists() && file.getPath().endsWith(".sql")) {
                    restoreFilePath = file.getAbsolutePath();
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysql -h").append(host).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);
        try {
            Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
            if (process.waitFor() == 0) {
                System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 执行命令
     *
     * @param command
     * @return
     */
    private static String[] getCommand(String command) {
        String os = System.getProperty("os.name");
        String shell = "/bin/bash";
        String c = "-c";
        if (os.toLowerCase().startsWith("win")) {
            shell = "cmd ";
            c = " /c ";
        }
        String[] cmd = {shell, c, command};
        return cmd;
    }


    public static void main(String[] args) throws Exception {
        String host = "81.68.135.30";
        String port = "3306";
        String userName = "test";
        String password = "test";
        String database = "zyjkfw";

        System.out.println("开始备份");
        String backupFolderPath = "c:/dev/";
        String fileName = "zyjkfw.sql";
        if (backup(host, port, userName, password, backupFolderPath, fileName, database)) {
            System.out.println("备份成功");
        } else {
            System.out.println("备份失败");
        }

//        System.out.println("开始还原");
//        String restoreFilePath = "c:/dev/zyjkfw.sql";
//        restore(restoreFilePath, host, userName, password, database);
//        System.out.println("还原成功");

    }
}
