package com.nvxclouds.fastdfs.biz.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/24 10:57
 * @Description:
 */
@FeignClient(value = "apigate")
public interface ApigateClient {

    @GetMapping("/data")
    String test();
}
