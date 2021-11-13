package com.ianqian.springcloud.controller;

import com.ianqian.springcloud.entities.CommonResult;
import com.ianqian.springcloud.entities.Payment;
import com.ianqian.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IanQian
 * @date 2021/11/13 14:14
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentId(@PathVariable("id") String id) {
        return paymentFeignService.selectByPrimaryKey(id);
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }
}
