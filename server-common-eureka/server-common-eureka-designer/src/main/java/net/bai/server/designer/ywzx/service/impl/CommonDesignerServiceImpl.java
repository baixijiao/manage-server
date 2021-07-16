package net.bai.server.designer.ywzx.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.bai.server.designer.ywzx.dao.CommonDesignerMapper;
import net.bai.server.designer.ywzx.service.ICommonDesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:23
 * @Description： designer项目服务实现类
 * @Modified By:
 */
@Service
@Transactional
@Slf4j
public class CommonDesignerServiceImpl implements ICommonDesignerService {

    @Value("${server.port}")
    private String port;

    @Autowired
    private CommonDesignerMapper commonDesignerMapper;


    @Override
    public String from(String name) {
        return "from designerServer server:" + port + "--->>>," + name + ",ok,success!";
    }

    @Override
    public Map<String, Object> getData(String id) {
        return commonDesignerMapper.getData(id);
    }
}
