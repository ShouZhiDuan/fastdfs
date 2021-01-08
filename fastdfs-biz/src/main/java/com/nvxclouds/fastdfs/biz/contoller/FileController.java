package com.nvxclouds.fastdfs.biz.contoller;


import com.nvxclouds.fastdfs.biz.service.FileService;
import com.nvxclouds.common.base.pojo.BaseResult;
import com.nvxclouds.common.core.enums.ExceptionEnum;
import com.nvxclouds.common.core.exception.GlobalException;
import com.nvxclouds.fastdfs.biz.vo.UploadFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/18 12:31
 * @Description:
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/util/uploadFile")
    public BaseResult<UploadFileVO> uploadFile(@RequestPart(value = "fileName", required = false) MultipartFile[] fileName) {
        return upload(fileName);
    }


    @PostMapping("/upload")
    public BaseResult<UploadFileVO> upload(@RequestPart(value = "file", required = false) MultipartFile[] file) {
        if (file.length == 0) {
            throw new GlobalException(ExceptionEnum.FILE_IS_NULL);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < file.length; i++) {
            String fileId = fileService.uploadFile(file[i]);
            stringBuilder.append(fileId);
            if (i != file.length - 1) {
                stringBuilder.append(",");
            }
        }
        return BaseResult.ok(UploadFileVO.builder()
                .fileID(stringBuilder.toString())
                .build());
    }
}
