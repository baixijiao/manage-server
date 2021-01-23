package net.htjs.server.zyjk.server.ywzx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:23
 * @Description： 致远服务端服务实现类
 * @Modified By:
 */
@Service
@Slf4j
public class ZyjkServerServiceImpl implements IZyjkServerService {

    @Value("${server.port}")
    private String port;

    @Override
    public String from(String name) {
        return "from zyjkServer server:" + port + "--->>>," + name + ",ok,success!";
    }
}
