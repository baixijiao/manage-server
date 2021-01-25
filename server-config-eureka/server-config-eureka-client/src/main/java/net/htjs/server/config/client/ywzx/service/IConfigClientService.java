package net.htjs.server.config.client.ywzx.service;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 16:19
 * @Description： 配置客户端服务接口
 * @Modified By:
 */
public interface IConfigClientService {

    /**
     * 服务接口来源
     * @param name
     * @return
     */
    String from(String name);

    /**
     * 从config服务端获取本服务的相关配置
     * @param serverConfig
     * @return
     */
    String getDemoServerConfig(String serverConfig);
}
