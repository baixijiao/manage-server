package net.htjs.server.elasticsearch.client.ywzx.service;

import net.htjs.server.elasticsearch.client.ywzx.entity.EsDemo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 16:19
 * @Description： 搜索客户端服务接口
 * @Modified By:
 */
public interface IElasticsearchClientService {

    /**
     * 服务接口来源
     * @param name
     * @return
     */
    String from(String name);

    /**
     * 根据标题和内容分页查询用户列表
     * @param title 标题
     * @param content 内容
     * @param pageable
     * @return
     */
    Page<EsDemo> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);

    /**
     * 保存用户信息
     * @param esDemo 用户信息
     * @return
     */
    EsDemo insert(EsDemo esDemo);
}
