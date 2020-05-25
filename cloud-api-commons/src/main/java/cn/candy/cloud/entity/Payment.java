package cn.candy.cloud.entity;

import java.io.Serializable;

/**
 * 支付-订单-流水号 实体类
 *
 * @author : Administrator
 * @date : 2020-05-17 16:10
 **/
@SuppressWarnings("unused")
public class Payment implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 订单流水号
     */
    private String serial;
    
    public Payment() {
    }
    
    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getSerial() {
        return serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
