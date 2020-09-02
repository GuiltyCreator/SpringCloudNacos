package com.dcone.springcloud.alibaba.service.provider.controller;

import com.dcone.springcloud.alibaba.service.provider.http.req.serviceprovider.TestReqDto;
import com.dcone.springcloud.alibaba.service.provider.http.resp.serviceprovider.TestRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * 服务生产者控制器
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-25
 */

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/serviceProvider")
public class ServiceProviderController {

    @Value("${message}")
    private String changeMessage;

    @GetMapping("/test")
    public TestRespDto test(@ModelAttribute TestReqDto req){

       return TestRespDto.builder()
                .code(200)
                .data("serviceProvider: " + req.getMessage())
                .changeMessage(changeMessage)
                .build();
    }

}
