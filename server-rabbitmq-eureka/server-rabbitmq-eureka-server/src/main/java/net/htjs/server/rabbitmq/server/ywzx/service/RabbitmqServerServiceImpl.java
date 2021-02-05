package net.htjs.server.rabbitmq.server.ywzx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:23
 * @Description： 消息服务端服务实现类
 * @Modified By:
 */
@Service
@Slf4j
public class RabbitmqServerServiceImpl implements IRabbitmqServerService {

    @Value("${server.port}")
    private String port;

    @Override
    public String from(String name) {
        return "from rabbitmqServer server:" + port + "--->>>," + name + ",ok,success!";
    }
}
