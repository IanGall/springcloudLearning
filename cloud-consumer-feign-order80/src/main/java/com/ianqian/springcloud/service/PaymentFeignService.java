package com.ianqian.springcloud.service;

import com.ianqian.springcloud.entities.CommonResult;
import com.ianqian.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author IanQian
 * @date 2021/11/13 13:29
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentFeignService {
    @GetMapping("/get/{id}")
    CommonResult<Payment> selectByPrimaryKey(@PathVariable("id") String id);

    @GetMapping("/feign/timeout")
    String paymentFeignTimeout();

}
