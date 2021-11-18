package net.bai.server.databr.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author baixj
 * @Description: 备份还原数据库配置
 * @date 2021/11/16 14:43
 */
@Component
@ConfigurationProperties(prefix = "databr.datasoures")
@Data
public class BackupRestoreDatasourceProperties {

    private String host;

    private String username;

    private String password;

    private String database;

}
