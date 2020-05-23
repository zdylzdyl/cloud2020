package cn.candy.cloud.service.impl;

import cn.candy.cloud.dao.PaymentDao;
import cn.candy.cloud.entity.Payment;
import cn.candy.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单-流水 服务 接口 实现
 *
 * @author : Administrator
 * @date : 2020-05-17 17:10
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 自动注入 操作的接口实现
     */
    @Resource
    private PaymentDao paymentDao;
    
    /**
     * 插入一条数据
     *
     * @param payment 数据实体对象
     * @return 插入个数1
     */
    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }
    
    /**
     * 根据id查询数据
     *
     * @param id 订单编号id
     * @return 订单流水实体对象
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
