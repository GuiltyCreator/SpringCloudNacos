package com.dcone.springcloud.alibaba.service.consumer;

import com.netflix.loadbalancer.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class SpringCloudAlibabaServiceConsumerApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(SpringCloudAlibabaServiceConsumerApplication.class, args);

        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        String serviceName = env.getProperty("spring.application.name");
        log.info("\n----------------------------------------------------------\n\t" +
                "Service:" + serviceName + " is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "swagger-ui: http://" + ip + ":" + port + path + "/swagger-ui.html\n" +
                "----------------------------------------------------------");
    }

    /**
     * 负载均衡策略
     * @return
     */
    @Bean
    public IRule myRule(){
        // return new RoundRobinRule();//轮询
        // return new RetryRule();//重试
        // return new BestAvailableRule();//选择并发量小的服务
        // return new WeightedResponseTimeRule();// 权重
        // return new ZoneAvoidanceRule()//判断
        //return new AvailabilityFilteringRule()//过滤多次down的服务，对剩下的服务轮询
        return new RandomRule();//随机
    }

}
