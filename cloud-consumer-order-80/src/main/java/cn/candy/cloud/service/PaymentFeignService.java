package cn.candy.cloud.service;

import cn.candy.cloud.entity.CommonResult;
import cn.candy.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * 订单消费者 服务层 使用openfeign做服务调用 封装Rest template
 * 1.测试 服务名是否区分大小写 "cloud-payment-service" "CLOUD-PAYMENT-SERVICE" 不区分大小写
 *
 * 使用openfeign和restful风格传递参数，发现交互全是POST的JSON GET请求不存在 是因为请求参数没有加@RequestParam("xx")
 * Resolved [org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'POST' not supported]
 *
 * 本类的注解使用 @Service @Comment 都可以
 * TODO feign的超时设置 未设置成功
 * TODO feign的服务名称使用配置文件中 未设置成功
 * TODO feign的服务 配置日志 未配置成功
 *
 *
 * @author : Administrator
 * @date : 2020-05-24 17:40
 **/
@Service
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentFeignService {
    /**
     * 根据id查询订单流水
     * 注意GET请求需要添加@RequestParam注明此属性是GET中参数，否则会放入请求体内发送POST请求
     * 或者@RequestParam/@PathVariable/@RequestHeader等来构造http请求
     * @param id 订单id
     * @return json数据 payment实体json格式
     */
    @GetMapping()
    CommonResult queryPaymentById(@RequestParam("id") Long id);

    /**
     * 新增数据
     *
     * @param payment 支付数据实体
     * @return 插入数据数量 0为错误
     */
    @PostMapping()
    CommonResult addPayment(@RequestBody Payment payment);
}
