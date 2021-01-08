package com.nvxclouds.fastdfs.biz.mapper;

import com.nvxclouds.common.core.mapper.Mapper;
import com.nvxclouds.fastdfs.api.domian.File;

public interface FileMapper extends Mapper<File> {

    Long selectFileIDByMD5(String fileMD5);
}