package net.bai.server.rediscache.springboot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author baixj
 * @Description: redis操作工具类
 * @date 2021/10/27 14:30
 */
@Component
@Slf4j
public class CacheRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    public Long delValuesPre(String preKey) {
        if (!StringUtils.isEmpty(preKey)) {
            return redisTemplate.delete(redisTemplate.keys(preKey + "*"));
        } else {
            log.debug("未传递key的前缀，暂不处理redis中缓存数据。");
            return 0L;
        }
    }

}
