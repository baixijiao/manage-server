package net.bai.server.mdc.ywzx.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.bai.server.mdc.ywzx.service.ICommonMDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:19
 * @Description： mdc项目服务入口
 * @Modified By:
 */
@Api(value = "/commonMDC", tags = "mdc项目服务入口")
@RestController
@RequestMapping("/commonMDC")
@Slf4j
public class CommonMDCController {

    @Autowired
    ICommonMDCService commonMDCService;

    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "commonMDC") String name){
        return commonMDCService.from(name);
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
        log.info("Action获取到的参数为：{}", id);
        return commonMDCService.getData(id);
    }

}
