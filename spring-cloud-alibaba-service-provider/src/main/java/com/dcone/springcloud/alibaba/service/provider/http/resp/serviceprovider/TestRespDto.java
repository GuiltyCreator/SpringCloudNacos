package com.dcone.springcloud.alibaba.service.provider.http.resp.serviceprovider;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * test接口返参
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestRespDto {

    private Integer code;

    private String data;

    private String changeMessage;
}
