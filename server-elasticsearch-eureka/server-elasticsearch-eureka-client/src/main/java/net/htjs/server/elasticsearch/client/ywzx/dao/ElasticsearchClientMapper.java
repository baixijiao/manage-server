package net.htjs.server.elasticsearch.client.ywzx.dao;

import net.htjs.server.elasticsearch.client.ywzx.entity.EsDemo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: baixijiao
 * @Date：2021-02-04 10:02
 * @Description： 搜索客户端服务Mapper接口
 * @Modified By:
 */
@Repository
public interface ElasticsearchClientMapper extends ElasticsearchRepository<EsDemo, String> {

    /**
     * 根据标题和内容分页查询用户列表
     * @param title 标题
     * @param content 内容
     * @param pageable
     * @return
     */
    Page<EsDemo> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
}
