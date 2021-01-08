package com.nvxclouds.fastdfs.biz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: Albert
 * @Contact: 1092144169@qq.com
 * @Date: 2019-06-05 14:48
 * @Description: 文件上传相关参数配置
 */
@Data
@ConfigurationProperties(prefix = "com.komlin")
@Component
public class UploadConfig {
    /**
     * fdfs服务器地址
     */
    private String fdfs;

    /**
     * 允许请求的文件类型
     */
    private FileType fileType;



}
