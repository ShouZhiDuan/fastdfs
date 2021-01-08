package com.nvxclouds.fastdfs.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/18 13:12
 * @Description:
 */
@AllArgsConstructor
@Getter
public enum FastDFSExceptionEnum {
    FILE_IS_NULL(6001, "请上传文件"), FILE_TYPE_ERROR(6002, "文件类型错误"),
    UPLOAD_TO_FAST_DFS_ERROR(6002, "上传到FastDFS失败"),
    FILE_NAME_ERROR(6003, "文件名错误"), FILE_UPLOAD_FAILED(6003, "文件上传失败"), FILE_NOT_EXIST(6004, "文件不存在");
    public int code;
    public String msg;
}
