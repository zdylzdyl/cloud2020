package cn.candy.cloud.dao;

import cn.candy.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 支付-流水号 的数据库接口
 * 推荐使用它@mapper而不是@Responbility
 *
 * @author : Administrator
 * @date : 2020-05-17 16:23
 **/
@Mapper
public interface PaymentDao {
    /**
     * 插入一条数据
     *
     * @param payment 数据实体对象
     * @return 插入个数1
     */
    public int insert(Payment payment);
    
    /**
     * 根据id查询数据
     *
     * @param id 订单编号id
     * @return 订单流水实体对象
     */
    public Payment getPaymentById(@Param("id") Long id);
}