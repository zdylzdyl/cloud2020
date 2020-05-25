package cn.candy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 消费者 主启动类
 * 注意
 * 使用eureka做服务注册中心的时候需要使用@EnableEurekaClient 做客户端调用
 * 使用zookeeper做服务注册中心时需要使用@EnableDiscoveryClient 做客户端调用
 * 使用consul做服务注册中心时需要使用@EnableDiscoveryClient 做客户端调用
 *
 * 使用eureka做服务注册中心的时候需要使用@EnableFeignClients 做客户端调用
 *
 *
 * @author : Administrator
 * @date : 2020-05-18 21:02
 **/
@SpringBootApplication
/*@EnableEurekaClient*/
@EnableFeignClients
/*@EnableDiscoveryClient*/
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }
}
