package cn.candy.cloud.controller;

import cn.candy.cloud.entity.CommonResult;
import cn.candy.cloud.entity.Payment;
import cn.candy.cloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单-流水 表现层
 *
 * @author : Administrator
 * @date : 2020-05-17 17:16
 **/
@RestController
@RequestMapping("/payment")
public class PaymentController {
    /**
     * 自动注入payment服务实现
     */
    @Resource
    private PaymentService paymentService;
    
    /**
     * 自动注入实例对象 服务属性对象 从serverProperties对象总获取服务器端口
     */
    @Resource
    private ServerProperties serverProperties;
    
    @Resource
    private DiscoveryClient discoveryClient;
    
    /**
     * 给返回的信息添加端口信息
     *
     * @return 给返回的信息添加端口信息
     */
    private String getServerPortInfo() {
        return String.format(" from server port:[%s].中文测试", serverProperties.getPort());
    }
    
    /**
     * 新增数据
     *
     * @param payment 支付数据实体
     * @return 插入数据数量 0为错误
     */
    @PostMapping
    public CommonResult addPayment(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        return result > 0 ? CommonResult.success(result).data(getServerPortInfo()) :
                CommonResult.error("插入数据量" + result + getServerPortInfo());
    }
    
    /**
     * 根据id查询订单流水
     *
     * @param id 订单id
     * @return json数据 payment实体json格式
     */
    @GetMapping
    public CommonResult queryById(@Param("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return payment == null ? CommonResult.error("no data" + getServerPortInfo()) :
                CommonResult.success(payment).data(getServerPortInfo());
    }
}
