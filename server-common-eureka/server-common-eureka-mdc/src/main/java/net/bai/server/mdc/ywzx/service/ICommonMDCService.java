package net.bai.server.mdc.ywzx.service;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:21
 * @Description： mdc项目服务接口
 * @Modified By:
 */
public interface ICommonMDCService {

    /**
     * 服务接口来源
     * @param name
     * @return
     */
    String from(String name);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    Map<String, Object> getData(String id);

}
