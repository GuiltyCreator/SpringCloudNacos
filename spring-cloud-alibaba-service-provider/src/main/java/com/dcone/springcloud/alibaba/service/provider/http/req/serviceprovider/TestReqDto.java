package com.dcone.springcloud.alibaba.service.provider.http.req.serviceprovider;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * test接口入参
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestReqDto {

    private String message;
}
