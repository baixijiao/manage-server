package net.htjs.server.rabbitmq.server.ywzx;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: baixijiao
 * @Date：2021-02-05 17:01
 * @Description： 消息服务端服务发送消息入口(主题交换机)
 * @Modified By:
 */
@Api(value = "/rabbitmqSender", tags = "消息服务端发送消息入口")
@RestController
@RequestMapping("/rabbitmqSender")
@Slf4j
public class RabbitTopicSender {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @ApiOperation(value = "发送消息(主题交换机)", notes = "对外发送消息的方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageData", value = "具体的消息内容")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @GetMapping("/sendTopicMessage1")
    public String sendTopicMessage1(@RequestParam(value = "messageData") String messageData) {
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "message: M A N ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        return "ok";
    }

    @ApiOperation(value = "发送消息(主题交换机)", notes = "对外发送消息的方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageData", value = "具体的消息内容")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @GetMapping("/sendTopicMessage2")
    public String sendTopicMessage2(@RequestParam(value = "messageData") String messageData) {
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "message: woman is all ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", messageData);
        womanMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", womanMap);
        return "ok";
    }

}
