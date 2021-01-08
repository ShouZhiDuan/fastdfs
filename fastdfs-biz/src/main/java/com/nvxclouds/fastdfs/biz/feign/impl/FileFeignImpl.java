package com.nvxclouds.fastdfs.biz.feign.impl;

import com.nvxclouds.common.base.pojo.BaseResult;
import com.nvxclouds.fastdfs.api.feign.FileFeign;
import com.nvxclouds.fastdfs.api.domian.File;
import com.nvxclouds.fastdfs.biz.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/5/28 19:03
 * @Description:
 */
@RestController
public class FileFeignImpl implements FileFeign {

    @Autowired
    private FileService fileService;

    @Override
    @GetMapping("/file/{id}")
    public BaseResult<File> getFileById(@PathVariable(value = "id") Long id) {
        return BaseResult.ok(fileService.selectFileByIdAndValidate(id));
    }
}
