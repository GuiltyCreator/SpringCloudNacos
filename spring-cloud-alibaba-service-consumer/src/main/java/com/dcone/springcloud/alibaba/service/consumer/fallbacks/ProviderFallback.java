package com.dcone.springcloud.alibaba.service.consumer.fallbacks;

import com.dcone.springcloud.alibaba.service.consumer.feigns.ProviderFeign;
import com.dcone.springcloud.alibaba.service.provider.http.req.serviceprovider.TestReqDto;
import com.dcone.springcloud.alibaba.service.provider.http.resp.serviceprovider.TestRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 服务消费者熔断器类
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-26
 */
@Slf4j
@Component
public class ProviderFallback implements ProviderFeign {

    @Override
    public TestRespDto test(TestReqDto req) {
        return TestRespDto.builder()
                .code(500)
                .data("熔断函数触发，降级机制")
                .build();
    }
}
