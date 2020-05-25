package cn.candy.cloud.controller;

import cn.candy.cloud.entity.CommonResult;
import cn.candy.cloud.entity.Payment;
import cn.candy.cloud.service.PaymentFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 订单消费者 表现层 使用openfeign调用服务
 *
 * @author : Administrator
 * @date : 2020-05-18 21:05
 **/
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {
    /**
     * 日志
     */
    private static final Logger log= LoggerFactory.getLogger(OrderFeignController.class);
    /**
     * 注入PaymentFeignService
     */
    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * 服务调用 插入一条数据
     *
     * @param payment 订单流水号 对象
     * @return 插入结果json格式
     */
    @PostMapping("/payment")
    public CommonResult insert(Payment payment) {
        log.debug("payment info : {}", payment);
        return paymentFeignService.addPayment(payment);
    }

    /**
     * 根据id查询
     *
     * @param id 订单流水号的id
     * @return 查询结果json格式
     */
    @GetMapping("/payment")
    public CommonResult getPayment(Long id) {
        log.debug("payment id : {}", id);
        return paymentFeignService.queryPaymentById(id);
    }
}
