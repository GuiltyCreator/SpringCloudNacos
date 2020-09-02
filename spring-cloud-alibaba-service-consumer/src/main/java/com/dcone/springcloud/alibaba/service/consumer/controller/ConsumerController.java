package com.dcone.springcloud.alibaba.service.consumer.controller;

import com.dcone.springcloud.alibaba.service.consumer.feigns.ProviderFeign;
import com.dcone.springcloud.alibaba.service.provider.http.req.serviceprovider.TestReqDto;
import com.dcone.springcloud.alibaba.service.provider.http.resp.serviceprovider.TestRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 服务消费者控制器
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-26
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Resource
    private ProviderFeign feign;


    @GetMapping(value = "/test")
    public TestRespDto test(){
        return feign.test(new TestReqDto("hello consumer"));
    }
}
