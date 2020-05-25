package cn.candy.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 一些spring boot的配置
 *
 * @author : Administrator
 * @date : 2020-05-18 21:09
 **/
//@Configuration
public class ApplicationConfig {
    /**
     * getMessageConverters 获取全局的默认的字符串转化集 因为spring默认单例
     * 0@Resource
     * private StringHttpMessageConverter stringHttpMessageConverter;
     * 构建RestTemplate Bean对象
     * LoadBalanced 默认使用轮询 负载均衡机制 eureka和zookeeper都一样
     *
     * Ribbon和nginx负载均衡不一样是，ribbon是客户端进程内负载均衡，nginx是服务端集中式负载均衡
     * 设置全局默认的转发字符串编码为UTF-8
     * stringHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
     *
     * @return RestTemplate对象
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }
}
