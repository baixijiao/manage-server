package net.htjs.server.netty.server.ywzx.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.htjs.server.netty.server.ywzx.service.INettyServerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 16:20
 * @Description： 致远服务端服务实现类
 * @Modified By:
 */
@Service
@Slf4j
public class NettyServerServicImpl implements INettyServerService {

    @Value("${server.port}")
    private String port;

    @Override
    public String from(String name) {
        return "from nettyServer server:" + port + "--->>>," + name + ",ok,success!";
    }
}
