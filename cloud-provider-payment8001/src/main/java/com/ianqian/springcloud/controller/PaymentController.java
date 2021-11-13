package com.ianqian.springcloud.controller;

import com.ianqian.springcloud.entities.CommonResult;
import com.ianqian.springcloud.entities.Payment;
import com.ianqian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author IanQian
 * @date 2021/11/7 13:13
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/insert")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("插入结果：" + result);
        return result > 0 ? CommonResult.success(serverPort) : CommonResult.fail(400, "插入数据库失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.selectByPrimaryKey(id);
        log.info("查询结果：" + result);
        return CommonResult.success(serverPort, result);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        for (String service : discoveryClient.getServices()) {
            log.info("****service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
