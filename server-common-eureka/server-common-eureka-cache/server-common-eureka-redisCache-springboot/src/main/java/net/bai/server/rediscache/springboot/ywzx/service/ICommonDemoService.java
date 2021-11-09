package net.bai.server.rediscache.springboot.ywzx.service;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:21
 * @Description： redisCache项目服务接口
 * @Modified By:
 */
public interface ICommonDemoService {

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
    Map<String, Object> getData(String id);

}
