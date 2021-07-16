package net.bai.server.demo.ywzx.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.bai.server.demo.ywzx.dao.CommonDemoMapper;
import net.bai.server.demo.ywzx.service.ICommonDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:23
 * @Description： demo项目服务实现类
 * @Modified By:
 */
@Service
@Transactional
@Slf4j
public class CommonDemoServiceImpl implements ICommonDemoService {

    @Value("${server.port}")
    private String port;

    @Autowired
    private CommonDemoMapper commonDemoMapper;


    @Override
    public String from(String name) {
        return "from demoServer server:" + port + "--->>>," + name + ",ok,success!";
    }

    @Override
    public Map<String, Object> getData(String id) {
        return commonDemoMapper.getData(id);
    }
}
