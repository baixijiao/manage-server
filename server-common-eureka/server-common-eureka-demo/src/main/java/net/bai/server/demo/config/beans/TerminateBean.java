package net.bai.server.demo.config.beans;

import com.netflix.discovery.DiscoveryManager;

import javax.annotation.PreDestroy;

/**
 * @Auther: baixijiao
 * @Date：2021-01-23 09:05
 * @Description： 服务停止的bean
 * @Modified By:
 */
public class TerminateBean {

    // 服务停止之前的操作
    @PreDestroy
    public void preDestroy() {
        System.out.println("TerminalBean is destroyed");
        // 客户端可以通过如下代码主动通知注册中心下线
        DiscoveryManager.getInstance().shutdownComponent();
    }

}
