package net.htjs.server.cache.springboot.ywzx.service.cache.impl;

import lombok.extern.slf4j.Slf4j;
import net.htjs.server.cache.springboot.config.datasource.DS;
import net.htjs.server.cache.springboot.config.datasource.DataSourceEnum;
import net.htjs.server.cache.springboot.ywzx.dao.CommonCacheSpringbootDefaultMapper;
import net.htjs.server.cache.springboot.ywzx.dao.CommonCacheSpringbootMapper;
import net.htjs.server.cache.springboot.ywzx.service.cache.ICacheSpringbootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
@CacheConfig(cacheNames = "firstCache")
public class CacheSpringbootServiceImpl implements ICacheSpringbootService {

    @Value("${server.port}")
    private String port;

    @Autowired
    private CommonCacheSpringbootDefaultMapper commonCacheSpringbootDefaultMapper;

    @Autowired
    private CommonCacheSpringbootMapper commonCacheSpringbootMapper;

    @Override
    public String from(String name) {
        return "from cacheServer server:" + port + "--->>>," + name + ",ok,success!";
    }

    @Override
    public Map<String, Object> getDataByDbDefault(String id) {
        return commonCacheSpringbootDefaultMapper.getDataByDbDefault(id);
    }

    @Override
    @DS(DataSourceEnum.DB1)
    /**
     * 获取文章  以传入的id为键，当state为0的时候不进行缓存
     * @param id 文章id
     * @return
     */
//    @Cacheable(key = "#id",unless = "#result.state==0")
    @Cacheable(key = "#id")
    public Map<String, Object> getDataByDb1(String id) {
        Map<String, Object> dataByDb1 = commonCacheSpringbootDefaultMapper.getDataByDb1(id);
        System.out.println("测试service缓存开始*******");
        Map<String, Object> dataByDb2 = this.getDataByDbDefault(id);
        System.out.println("返回数据-->-->" + dataByDb2);
        System.out.println("测试service缓存结束*******");
        return dataByDb1;
    }

    @Override
    @DS(DataSourceEnum.DB2)
    @Cacheable(value="generalCache",key="'treeNode'+#id")
    public Map<String, Object> getDataByDb2(String id) {
        return commonCacheSpringbootMapper.getDataByDb2(id);
    }

    @Override
    @DS(DataSourceEnum.DB2)
    @CachePut(value="generalCache",key="'treeNode'+#id")
    public Map<String, Object> updateDataByDb2(String id) {
        commonCacheSpringbootMapper.updateDataByDb2(id);
        return new HashMap<>();
    }

    @Override
    @DS(DataSourceEnum.DB2)
    @CacheEvict(value="generalCache",key="'treeNode'+#id")
    public Map<String, Object> delDataByDb2(String id) {
        commonCacheSpringbootMapper.delDataByDb2(id);
        return new HashMap<>();
    }
}
