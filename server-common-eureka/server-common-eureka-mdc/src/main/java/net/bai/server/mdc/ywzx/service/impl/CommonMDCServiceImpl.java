package net.bai.server.mdc.ywzx.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.bai.server.mdc.ywzx.dao.CommonMDCMapper;
import net.bai.server.mdc.ywzx.service.ICommonMDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:23
 * @Description： mdc项目服务实现类
 * @Modified By:
 */
@Service
@Transactional
@Slf4j
public class CommonMDCServiceImpl implements ICommonMDCService {

    @Value("${server.port}")
    private String port;

    @Autowired
    private CommonMDCMapper commonMDCMapper;


    @Override
    public String from(String name) {
        return "from mdcServer server:" + port + "--->>>," + name + ",ok,success!";
    }

    @Override
    public Map<String, Object> getData(String id) {
        log.info("Service获取到的参数为：{}", id);
        Map<String, Object> data = commonMDCMapper.getData(id);
        log.info("Service返回的数据为：{}", data);
        return data;
    }
}
