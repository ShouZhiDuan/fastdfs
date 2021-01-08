package com.nvxclouds.fastdfs.biz;

import com.github.tobato.fastdfs.FdfsClientConfig;
import com.nvxclouds.common.core.annotation.NVXCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/18 12:12
 * @Description:
 */
@Import(FdfsClientConfig.class)
@EnableFeignClients
@NVXCloudApplication
public class FastDFSApplication {
    public static void main(String[] args) {
        SpringApplication.run(FastDFSApplication.class, args);
    }
}
