package com.ianqian.springcloud.controller;

import com.ianqian.springcloud.entities.CommonResult;
import com.ianqian.springcloud.entities.Payment;
import com.ianqian.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IanQian
 * @date 2021/11/14 9:45
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class PaymentHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    @GetMapping("/payment/get/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return orderHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return orderHystrixService.paymentInfo_TimeOut(id);
    }

}
