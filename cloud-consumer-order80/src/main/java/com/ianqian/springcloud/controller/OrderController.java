package com.ianqian.springcloud.controller;

import com.ianqian.springcloud.entities.CommonResult;
import com.ianqian.springcloud.entities.Payment;
import com.ianqian.springcloud.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IanQian
 * @date 2021/11/7 14:49
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/payment/insert")
    public CommonResult<Payment> insert(Payment payment) {
        return HttpUtil.doPostByJson(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return HttpUtil.doGet(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = HttpUtil.getRestTemplate().getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return entity.getStatusCode().is2xxSuccessful() ? entity.getBody() : CommonResult.fail(444, "操作失败");
    }
}
