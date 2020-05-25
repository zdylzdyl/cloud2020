package cn.candy.cloud.controller;

import cn.candy.cloud.entity.CommonResult;
import cn.candy.cloud.entity.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 订单消费者 表现层
 *
 * @author : Administrator
 * @date : 2020-05-18 21:05
 **/
//@RestController
//@RequestMapping("/consumer")
public class OrderController {
    /**
     * 注入RestTemplate
     */
    @Resource
    private RestTemplate restTemplate;
    /**
     * 目前先写死url，稍后修改
     * public static final String PAYMENT_URL = "http://localhost:8001";
     * 改为服务名称
     * 调用服务名注意：
     * 1.使用eureka做服务发现，服务名不区分大小写
     * 2.使用zookeeper做服务发现，服务名区分大小写
     * 3.使用consul做服务发现，服务名不区分大小写
     */
    public static final String PAYMENT_URL = "http://cloud-payment-service".toUpperCase();

    /**
     * 服务调用 插入一条数据
     *
     * @param payment 订单流水号 对象
     * @return 插入结果json格式
     */
    @PostMapping("/payment")
    public CommonResult insert(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/paymant", payment, CommonResult.class);
    }

    /**
     * 根据id查询
     *
     * @param id 订单流水号的id
     * @return 查询结果json格式
     */
    @GetMapping("/payment")
    public CommonResult getPayment(Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment?id=" + id, CommonResult.class);
    }

    /**
     * 根据id查询 返回entity
     *
     * @param id 订单流水号的id
     * @return 查询结果entity格式
     */
    @GetMapping("/payment/entity")
    public CommonResult getPaymentEntity(Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment?id=" + id, CommonResult.class);
        return (entity.getStatusCode().is2xxSuccessful()) ? entity.getBody() : CommonResult.error(
                entity.getBody() != null && entity.getBody().getMessage() != null ? entity.getBody().getMessage() : "error with null message.");

    }

}
