package com.nvxclouds.fastdfs.api.feign;

import com.nvxclouds.common.base.pojo.BaseResult;
import com.nvxclouds.fastdfs.api.domian.File;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/5/28 18:50
 * @Description:
 */
public interface FileFeign {

    @GetMapping("/file/{id}")
    BaseResult<File> getFileById(@PathVariable("id") Long id);
}
