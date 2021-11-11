package net.bai.server.rediscache.springboot.ywzx.service.cache;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-11-108 16:21
 * @Description： spring boot整合redisCache
 * @Modified By:
 */
public interface IRedisCacheSpringbootService {

    /**
     * 查询数据并缓存
     * @param paramMap
     * @return
     */
    Map<String,Object> getRedisCacheData(String paramMap);

    /**
     * 更新数据并删除缓存
     * @param paramMap
     * @return
     */
    Map<String,Object> updateRedisCacheData(String paramMap);
}
