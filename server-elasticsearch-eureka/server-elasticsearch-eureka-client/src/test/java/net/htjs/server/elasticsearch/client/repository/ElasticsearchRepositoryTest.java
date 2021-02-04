package net.htjs.server.elasticsearch.client.repository;

import net.htjs.server.elasticsearch.client.ywzx.dao.ElasticsearchClientMapper;
import net.htjs.server.elasticsearch.client.ywzx.entity.EsDemo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * DemoRepository 测试类.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchRepositoryTest {

	@Autowired
	private ElasticsearchClientMapper elasticsearchClientMapper;

	// 在测试方法执行之前初始化数据
	@Before
	public void initElasticsearchData() {
		// 清空所有
		elasticsearchClientMapper.deleteAll();

		elasticsearchClientMapper.save(new EsDemo("11", "河南航天金穗科技有限公司", "省内税务公司"));
		elasticsearchClientMapper.save(new EsDemo("22", "河南慧远智能有限公司", "省内智能开发公司"));
		elasticsearchClientMapper.save(new EsDemo("33", "郑州市人才交流中心", "省内智能开发公司"));
	}

	@Test
	public void testFindByTitleLikeOrContentLike() {
		Pageable pageable = PageRequest.of(0, 20);
		Page<EsDemo> page = elasticsearchClientMapper.findByTitleLikeOrContentLike("河南", "税务", pageable);
		for (EsDemo esDemo : page) {
			System.out.println("111111:" + esDemo);
		}
		assertThat(page.getTotalElements()).isEqualTo(2);
	}
}
