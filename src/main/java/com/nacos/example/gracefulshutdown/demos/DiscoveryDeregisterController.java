package com.nacos.example.gracefulshutdown.demos;

import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: xushengbin
 * Date: 2024/10/3
 * Time: 17:37
 */
@RestController
public class DiscoveryDeregisterController {
    private static final Logger log = LoggerFactory.getLogger(DiscoveryDeregisterController.class);
    @Autowired
    private NacosAutoServiceRegistration nacosAutoServiceRegistration;

    @RequestMapping("/deregister")
    public String deregister() {
        log.info("deregister from nacos start");
        nacosAutoServiceRegistration.destroy();
        log.info("deregister from nacos success");
        return "ok";
    }
}
