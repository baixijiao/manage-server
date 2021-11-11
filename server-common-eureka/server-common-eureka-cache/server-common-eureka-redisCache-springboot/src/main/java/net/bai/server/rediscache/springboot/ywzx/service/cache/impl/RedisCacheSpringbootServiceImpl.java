package net.bai.server.rediscache.springboot.ywzx.service.cache.impl;

import lombok.extern.slf4j.Slf4j;
import net.bai.server.rediscache.springboot.util.CacheRedisTemplate;
import net.bai.server.rediscache.springboot.ywzx.dao.CommonDemoMapper;
import net.bai.server.rediscache.springboot.ywzx.service.cache.IRedisCacheSpringbootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-11-108 16:21
 * @Description： spring boot整合redisCache实现类
 * @Modified By:
 */
@Service("redisCacheSpringbootService")
@Transactional
@Slf4j
public class RedisCacheSpringbootServiceImpl implements IRedisCacheSpringbootService {

    @Autowired
    private CommonDemoMapper commonDemoMapper;

    @Autowired
    private CacheRedisTemplate cacheRedisTemplate;

    @Override
    @Cacheable(value = "redisCacheDate", key = "#p0")
    public Map<String, Object> getRedisCacheData(String id) {
        Map<String, Object> data = commonDemoMapper.getRedisCacheData(id);
        return data;
    }

    @Override
    public Map<String, Object> updateRedisCacheData(String id) {
        Integer integer = commonDemoMapper.updateRedisCacheData(id);
        if (integer > 0) {
            Long delNum = cacheRedisTemplate.delValuesPre("redisCacheDate");
            log.info("redis中此次清除缓存数量为：{}", delNum);
        }
        return new HashMap<>();
    }
}
