package com.ianqian.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author IanQian
 * @date 2021/11/14 13:08
 */
@Component
public class OrderFallbackService implements FallbackFactory<OrderHystrixService> {

    @Override
    public OrderHystrixService create(Throwable throwable) {
        return new OrderHystrixService() {
            @Override
            public String paymentInfo_OK(Integer id) {
                return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
            }

            @Override
            public String paymentInfo_TimeOut(Integer id) {
                return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
            }
        };
    }
}
