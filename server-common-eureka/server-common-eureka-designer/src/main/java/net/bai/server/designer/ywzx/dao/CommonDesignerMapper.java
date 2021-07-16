package net.bai.server.designer.ywzx.dao;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:26
 * @Description： designer项目服务Mapper接口
 * @Modified By:
 */
public interface CommonDesignerMapper {

    /**
     * 根据id获取数据源1的数据
     * @param id
     * @return
     */
    Map<String, Object> getData(String id);
}
