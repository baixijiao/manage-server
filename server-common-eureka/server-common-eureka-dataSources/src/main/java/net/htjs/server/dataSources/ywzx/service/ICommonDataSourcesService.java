package net.htjs.server.dataSources.ywzx.service;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:21
 * @Description： 多数据源服务接口
 * @Modified By:
 */
public interface ICommonDataSourcesService {

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
}
