package cn.candy.cloud.entity;

import java.io.Serializable;

/**
 * Json 格式实体类 前端交互
 *
 * @author : Administrator
 * @date : 2020-05-17 16:17
 **/
@SuppressWarnings("unused")
public class CommonResult implements Serializable {
    /**
     * 消息编码
     */
    private Integer code;
    /**
     * 返回应答消息
     */
    private String message;
    /**
     * 返回的请求数据
     */
    private Object data;
    
    public CommonResult() {
    }
    
    public CommonResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
    /**
     * 成功
     *
     * @param data 传输的数据
     * @return json格式化
     */
    public static CommonResult success(Object data) {
        return new CommonResult(200, "success", data);
    }
    
    /**
     * 失败
     *
     * @param message 报错信息
     * @return json格式化
     */
    public static CommonResult error(String message) {
        return new CommonResult(500, message, null);
    }
    
    public CommonResult data(Object data) {
        this.data = data;
        return this;
    }
    
    public CommonResult message(String message) {
        this.message = message;
        return this;
    }
    
    public CommonResult code(Integer code) {
        this.code = code;
        return this;
    }

    public CommonResult addMessage(String message) {
        this.message = this.message+message;
        return this;
    }
}
