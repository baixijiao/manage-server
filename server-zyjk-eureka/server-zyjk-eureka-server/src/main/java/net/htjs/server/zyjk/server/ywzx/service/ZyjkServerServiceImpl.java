package net.htjs.server.zyjk.server.ywzx.service;

import lombok.extern.slf4j.Slf4j;
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

    @Override
    public String from(String name) {
        return "from zyjkServer server--->>>,"+name+",ok,success!";
    }
}
