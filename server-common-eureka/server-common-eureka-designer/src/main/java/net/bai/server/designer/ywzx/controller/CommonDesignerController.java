package net.bai.server.designer.ywzx.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.bai.server.designer.ywzx.service.ICommonDesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:19
 * @Description： designer项目服务入口
 * @Modified By:
 */
@Api(value = "/commonDesigner", tags = "designer项目服务入口")
@RestController
@RequestMapping("/commonDesigner")
@Slf4j
public class CommonDesignerController {

    @Autowired
    ICommonDesignerService commonDesignerService;

    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "commonDesigner") String name){
        return commonDesignerService.from(name);
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
        return commonDesignerService.getData(id);
    }

}
