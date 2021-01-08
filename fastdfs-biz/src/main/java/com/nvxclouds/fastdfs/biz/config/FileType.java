package com.nvxclouds.fastdfs.biz.config;

import lombok.Data;

import java.util.List;

/**
 * @Auther: Albert
 * @Date: 2019/12/26 10:22
 * @Contact: 1092144169@qq.com
 * @Description:
 */
@Data
public class FileType {

    private List<String> image;

    private List<String> video;

    private List<String> others;
}
