package com.ianqian.springcloud.controller;

import com.ianqian.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
// @DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    @GetMapping("/payment/get/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return orderHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    // @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    // })
    // @HystrixCommand//用全局的fallback方法
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return orderHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler," +
                "id:" + "\t" + "::>_<::";
    }

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

}
