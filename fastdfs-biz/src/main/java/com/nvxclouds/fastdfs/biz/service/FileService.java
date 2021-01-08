package com.nvxclouds.fastdfs.biz.service;

import com.nvxclouds.common.core.service.Service;
import com.nvxclouds.fastdfs.api.domian.File;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/18 12:31
 * @Description:
 */
public interface FileService extends Service<File> {

    /**
     * 上传文件
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);

    File selectFileByIdAndValidate(Long id);
}
