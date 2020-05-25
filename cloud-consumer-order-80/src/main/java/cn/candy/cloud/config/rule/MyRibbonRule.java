package cn.candy.cloud.config.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon 负载均衡的自定义实现类
 * 此处注意服务的大小写名称
 * <p>
 * 1、没有像周阳视频中讲的一样，将此类放置于springboot扫描包的外面，也没有写exclude排除
 * 2、没有将@RibbonClient放置于springbootapplicaition下面，而是单独至于本配置类上 -- 目前生效
 * 3、尝试服务名大小测试 "cloud-payment-service" "CLOUD-PAYMENT-SERVICE" 未区分大小写
 *
 * @author : Administrator
 * @date : 2020-05-24 09:40
 **/
//@Configuration
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRibbonRule.class)
public class MyRibbonRule {
    /**
     * 重新定义ribbon的负载均衡策略，此处是随机
     *
     * @return 随机负载均衡策略
     */
    @Bean
    public IRule getMyRule() {
        return new RandomRule();
    }
}
