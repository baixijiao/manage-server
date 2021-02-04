package net.htjs.server.elasticsearch.client.ywzx.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import net.htjs.server.elasticsearch.client.ywzx.dao.ElasticsearchClientMapper;
import net.htjs.server.elasticsearch.client.ywzx.entity.EsDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 16:20
 * @Description： 搜索客户端服务实现类
 * @Modified By:
 */
@Service
@Transactional
@Slf4j
public class ElasticsearchClientServicImpl implements IElasticsearchClientService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String port;

    @Autowired
    private ElasticsearchClientMapper elasticsearchClientMapper;

    @HystrixCommand(fallbackMethod = "fromError")
    @Override
    public String from(String name) {
        String url = applicationName + ":from:" + port;
        String forObject = restTemplate.getForObject(url + "from?name=aaa", String.class);
        return forObject;
    }

    public String fromError(String name) {
        return applicationName + " configClient server--->>>,"+name+",sorry,error!";
    }

    @Override
    public Page<EsDemo> findByTitleLikeOrContentLike(String title, String content, Pageable pageable) {
        return elasticsearchClientMapper.findByTitleLikeOrContentLike(title, content, pageable);
    }

    @Override
    public EsDemo insert(EsDemo esDemo) {
        return elasticsearchClientMapper.save(esDemo);
    }
}
