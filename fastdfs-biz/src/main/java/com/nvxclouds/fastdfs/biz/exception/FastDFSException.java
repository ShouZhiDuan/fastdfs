package com.nvxclouds.fastdfs.biz.exception;

import com.nvxclouds.fastdfs.biz.enums.FastDFSExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/18 13:10
 * @Description:
 */
@Getter
@AllArgsConstructor
public class FastDFSException extends RuntimeException{
    private FastDFSExceptionEnum exceptionEnum;
}
