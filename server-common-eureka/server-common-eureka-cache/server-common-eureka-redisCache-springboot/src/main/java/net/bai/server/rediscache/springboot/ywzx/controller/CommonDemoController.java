package net.bai.server.rediscache.springboot.ywzx.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.bai.server.rediscache.springboot.ywzx.service.ICommonDemoService;
import net.bai.server.rediscache.springboot.ywzx.service.cache.IRedisCacheSpringbootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:19
 * @Description： redisCache项目服务入口
 * @Modified By:
 */
@Api(value = "/redisCache", tags = "redisCache项目服务入口")
@RestController
@RequestMapping("/redisCache")
@Slf4j
public class CommonDemoController {

    @Autowired
    ICommonDemoService commonDemoService;
    @Autowired
    IRedisCacheSpringbootService redisCacheSpringbootService;

    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "commonDemo") String name){
        return commonDemoService.from(name);
    }

    @ApiOperation(value = "根据id获取信息", notes = "根据id获取信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @GetMapping("/getData/{id}")
    public Map<String, Object> getData(@PathVariable String id){
        return commonDemoService.getData(id);
    }


    @GetMapping("/getRedisCacheData/{id}")
    public Map<String, Object> getRedisCacheData(@PathVariable String id){
        return redisCacheSpringbootService.getRedisCacheData(id);
    }

    @GetMapping("/updateRedisCacheData/{id}")
    public Map<String, Object> updateRedisCacheData(@PathVariable String id){
        return redisCacheSpringbootService.updateRedisCacheData(id);
    }




}
