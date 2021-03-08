package net.htjs.server.dataSources.ywzx.dao;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:26
 * @Description： 多数据源服务Mapper接口
 * @Modified By:
 */
public interface CommonDataSourcesMapper {

    /**
     * 根据id获取默认数据源的数据
     * @param id
     * @return
     */
    @Select("SELECT id, ct_group, ct_group_desc\n" +
            "        FROM onl_code_text\n" +
            "        WHERE id = #{id}")
    Map<String, Object> getDataByDbDefault(String id);

    /**
     * 根据id获取数据源1的数据
     * @param id
     * @return
     */
    @Select("SELECT id, ct_group, ct_group_desc\n" +
            "        FROM onl_code_text\n" +
            "        WHERE id = #{id}")
    Map<String, Object> getDataByDb1(String id);

    /**
     * 根据id获取数据源2的数据
     * @param id
     * @return
     */
    @Select("SELECT HY_ID, HY_MC\n" +
            "        FROM common_hy\n" +
            "        WHERE HY_ID = #{id}")
    Map<String, Object> getDataByDb2(String id);
}
