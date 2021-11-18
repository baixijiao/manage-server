package net.bai.server.databr.ywzx.service;

/**
 * @Auther: baixijiao
 * @Date：2021-11-16 14:56
 * @Description： dataBR项目备份还原数据库服务接口
 * @Modified By:
 */
public interface IDataBackupRestoreService {


    /**
     * 备份数据库
     * @param host IP地址
     * @param port 端口
     * @param userName 用户名
     * @param password 密码
     * @param backupFolderPath 备份的脚本路径
     * @param fileName 备份的文件名
     * @param database 数据库名称
     * @return
     * @throws Exception
     */
    boolean backup(String host,String port,String userName,String password,String backupFolderPath,String fileName,String database) throws Exception;

    /**
     * 还原数据库
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host IP地址
     * @param userName 用户名
     * @param password 密码
     * @param database 数据库名称
     * @return
     * @throws Exception
     */
    boolean restore (String restoreFilePath,String host,String userName,String password,String database) throws Exception;
}
