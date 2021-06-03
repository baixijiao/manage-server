package net.htjs.server.cache.springboot.ywzx.dao;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:26
 * @Description： 多数据源服务Mapper接口
 * @Modified By:
 */
public interface CommonCacheSpringbootMapper {

    /**
     * 根据id获取数据源2的数据
     * @param id
     * @return
     */
    Map<String, Object> getDataByDb2(String id);
}
