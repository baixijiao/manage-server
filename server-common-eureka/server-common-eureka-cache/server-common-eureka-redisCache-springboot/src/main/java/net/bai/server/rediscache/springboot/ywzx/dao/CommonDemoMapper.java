package net.bai.server.rediscache.springboot.ywzx.dao;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:26
 * @Description： 服务Mapper接口
 * @Modified By:
 */
public interface CommonDemoMapper {

    /**
     * 根据id获取数据源1的数据
     * @param id
     * @return
     */
    Map<String, Object> getData(String id);

    /**
     * 查询数据并缓存
     * @param id
     * @return
     */
    Map<String, Object> getRedisCacheData(String id);

    /**
     * 更新数据并删除缓存
     * @param id
     * @return
     */
    Integer updateRedisCacheData(String id);
}
