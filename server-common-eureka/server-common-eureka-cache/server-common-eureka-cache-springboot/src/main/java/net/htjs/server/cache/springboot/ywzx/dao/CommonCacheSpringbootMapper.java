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

    /**
     * 根据id更新数据源2的数据
     * 并且更新原来的缓存
     * @param id
     * @return
     */
    Integer updateDataByDb2(String id);

    /**
     * 根据id删除数据源2的数据
     * 并且清空原来的缓存
     * @param id
     * @return
     */
    Integer delDataByDb2(String id);
}
