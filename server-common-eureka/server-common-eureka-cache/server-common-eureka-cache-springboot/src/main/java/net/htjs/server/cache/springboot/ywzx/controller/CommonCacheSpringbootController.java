package net.htjs.server.cache.springboot.ywzx.controller;

import lombok.extern.slf4j.Slf4j;
import net.htjs.server.cache.springboot.ywzx.service.ICommonCacheSpringbootService;
import net.htjs.server.cache.springboot.ywzx.service.cache.ICacheSpringbootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:19
 * @Description： 多数据源服务入口
 * @Modified By:
 */
@RestController
@RequestMapping("/commonDataSources")
@Slf4j
public class CommonCacheSpringbootController {

    @Autowired
    ICommonCacheSpringbootService commonDataSourcesService;

    @Autowired
    ICacheSpringbootService cacheSpringbootService;

    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "commonDataSources") String name){
        return cacheSpringbootService.from(name);
    }

    @GetMapping("/getDataByDbDefault/{id}")
    public Map<String, Object> getDataByDbDefault(@PathVariable String id){
        return cacheSpringbootService.getDataByDbDefault(id);
    }

    @GetMapping("/getDataByDb1/{id}")
    public Map<String, Object> getDataByDb1(@PathVariable String id){
        Map<String, Object> dataByDb1 = cacheSpringbootService.getDataByDb1(id);
        return dataByDb1;
    }

    @GetMapping("/getDataByDb2/{id}")
    public Map<String, Object> getDataByDb2(@PathVariable String id){
        return cacheSpringbootService.getDataByDb2(id);
    }

    @GetMapping("/updateDataByDb2/{id}")
    public Map<String, Object> updateDataByDb2(@PathVariable String id){
        return cacheSpringbootService.updateDataByDb2(id);
    }

    @GetMapping("/delDataByDb2/{id}")
    public Map<String, Object> delDataByDb2(@PathVariable String id){
        return cacheSpringbootService.delDataByDb2(id);
    }

}
