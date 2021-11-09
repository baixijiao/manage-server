package net.htjs.server.cache.springboot.ywzx.service.cache;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-06-08 09:21
 * @Description： spring boot整合cache
 * @Modified By:
 */
public interface ICacheSpringbootService {

    /**
     * 服务接口来源
     * @param name
     * @return
     */
    String from(String name);

    /**
     * 根据id获取默认数据源的数据
     * @param id
     * @return
     */
    Map<String, Object> getDataByDbDefault(String id);

    /**
     * 根据id获取数据源1的数据
     * @param id
     * @return
     */
    Map<String, Object> getDataByDb1(String id);

    /**
     * 根据id获取数据源2的数据
     * @param id
     * @return
     */
    Map<String, Object> getDataByDb2(String id);

    /**
     * 根据id更新数据源2的数据
     * 并且清空原来的缓存
     * @param id
     * @return
     */
    Map<String, Object> updateDataByDb2(String id);

    /**
     * 根据id删除数据源2的数据
     * 并且清空原来的缓存
     * @param id
     * @return
     */
    Map<String, Object> delDataByDb2(String id);
}
