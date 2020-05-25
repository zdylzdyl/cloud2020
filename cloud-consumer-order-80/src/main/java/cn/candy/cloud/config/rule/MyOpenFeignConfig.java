package cn.candy.cloud.config.rule;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * open feign的配置 配置日志
 *
 * @author : macbook
 * @date : 2020-05-25 13:19
 **/
//@Configuration
public class MyOpenFeignConfig {
    /**
     * 配置openfeign的日志级别
     *
     * @return 日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}