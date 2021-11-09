package com.ianqian.springcloud.controller;

import com.ianqian.springcloud.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author IanQian
 * @date 2021/11/9 20:38
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/payment/zk")
    public String paymentInfo() {
        return HttpUtil.doGet(INVOKE_URL + "/payment/zk", String.class);
    }
}
