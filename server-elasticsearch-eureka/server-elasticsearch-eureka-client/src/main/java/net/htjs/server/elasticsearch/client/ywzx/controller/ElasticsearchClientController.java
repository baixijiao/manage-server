package net.htjs.server.elasticsearch.client.ywzx.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.htjs.server.elasticsearch.client.ywzx.entity.EsDemo;
import net.htjs.server.elasticsearch.client.ywzx.service.IElasticsearchClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 16:16
 * @Description： 搜索客户端服务入口
 * @Modified By:
 */
@Api(value = "/elasticsearch", tags = "搜索客户端服务入口")
@RestController
@RequestMapping("/elasticsearch")
@Slf4j
public class ElasticsearchClientController {

    @Autowired
    IElasticsearchClientService elasticsearchClientService;

    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "elasticsearchClient") String name){
        return elasticsearchClientService.from(name);
    }

    @ApiOperation(value = "获取用户列表", notes = "根据标题和内容分页查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题"),
            @ApiImplicitParam(name = "content", value = "内容"),
            @ApiImplicitParam(name = "pageIndex", value = "页码"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @GetMapping("/list")
    public List<EsDemo> list(@RequestParam(value="title",required=false,defaultValue="") String title,
                             @RequestParam(value="content",required=false,defaultValue="") String content,
                             @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                             @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize) {

        // 数据在 Test 里面先初始化了，这里只管取数据
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<EsDemo> page = elasticsearchClientService.findByTitleLikeOrContentLike(title, content, pageable);

        return page.getContent();
    }

}
