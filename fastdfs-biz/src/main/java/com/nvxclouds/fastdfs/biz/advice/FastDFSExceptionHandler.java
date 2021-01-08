package com.nvxclouds.fastdfs.biz.advice;

import com.nvxclouds.common.base.pojo.BaseResult;
import com.nvxclouds.common.core.advice.GlobalExceptionHandler;
import com.nvxclouds.fastdfs.biz.enums.FastDFSExceptionEnum;
import com.nvxclouds.fastdfs.biz.exception.FastDFSException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/5/28 11:07
 * @Description:
 */
@Slf4j
@RestControllerAdvice
public class FastDFSExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler({FastDFSException.class})
    public BaseResult<Object> handleFeignException(FastDFSException exception) {
        exception.printStackTrace();
        FastDFSExceptionEnum exceptionEnum = exception.getExceptionEnum();
        return BaseResult.builder()
                .code(exceptionEnum.code)
                .msg(exceptionEnum.msg)
                .build();
    }

}
