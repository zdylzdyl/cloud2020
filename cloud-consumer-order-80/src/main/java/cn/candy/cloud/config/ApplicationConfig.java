package cn.candy.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * 一些spring boot的配置
 *
 * @author : Administrator
 * @date : 2020-05-18 21:09
 **/
@Configuration
public class ApplicationConfig {
    /**
     * getMessageConverters 获取全局的默认的字符串转化集 因为spring默认单例
     */
    //@Resource
    //private StringHttpMessageConverter stringHttpMessageConverter;
    
    /**
     * 构建RestTemplate Bean对象
     * LoadBalanced 默认使用轮询 负载均衡机制 eureka和zookeeper都一样
     *
     * @return RestTemplate对象
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        //设置全局默认的转发字符串编码为UTF-8
        //stringHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
        return new RestTemplate();
    }
}
