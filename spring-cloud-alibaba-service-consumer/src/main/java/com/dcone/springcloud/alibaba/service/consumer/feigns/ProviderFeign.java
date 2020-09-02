package com.dcone.springcloud.alibaba.service.consumer.feigns;

import com.dcone.springcloud.alibaba.service.consumer.fallbacks.ProviderFallback;
import com.dcone.springcloud.alibaba.service.provider.http.req.serviceprovider.TestReqDto;
import com.dcone.springcloud.alibaba.service.provider.http.resp.serviceprovider.TestRespDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 服务提供者feign
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-26
 */
@Component
@FeignClient(value = "service-provider",path = "/provider/serviceProvider",fallback = ProviderFallback.class)
public interface ProviderFeign {
    @GetMapping("/test")
    TestRespDto test(@SpringQueryMap TestReqDto req);
}
