package net.bai.server.mdc.ywzx.dao;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:26
 * @Description： mdc服务Mapper接口
 * @Modified By:
 */
public interface CommonMDCMapper {

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    Map<String, Object> getData(String id);
}
