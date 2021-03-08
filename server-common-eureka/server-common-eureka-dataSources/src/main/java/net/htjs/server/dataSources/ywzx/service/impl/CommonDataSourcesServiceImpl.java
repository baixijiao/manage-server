package net.htjs.server.dataSources.ywzx.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.htjs.server.dataSources.config.datasource.DS;
import net.htjs.server.dataSources.config.datasource.DataSourceEnum;
import net.htjs.server.dataSources.ywzx.dao.CommonDataSourcesMapper;
import net.htjs.server.dataSources.ywzx.service.ICommonDataSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:23
 * @Description： 多数据源服务实现类
 * @Modified By:
 */
@Service
@Transactional
@Slf4j
public class CommonDataSourcesServiceImpl implements ICommonDataSourcesService {

    @Value("${server.port}")
    private String port;

    @Autowired
    private CommonDataSourcesMapper commonDataSourcesMapper;

    @Override
    public String from(String name) {
        return "from rabbitmqServer server:" + port + "--->>>," + name + ",ok,success!";
    }

    @Override
    public Map<String, Object> getDataByDbDefault(String id) {
        return commonDataSourcesMapper.getDataByDbDefault(id);
    }

    @Override
    @DS(DataSourceEnum.DB1)
    public Map<String, Object> getDataByDb1(String id) {
        return commonDataSourcesMapper.getDataByDb1(id);
    }

    @Override
    @DS(DataSourceEnum.DB2)
    public Map<String, Object> getDataByDb2(String id) {
        return commonDataSourcesMapper.getDataByDb2(id);
    }
}
