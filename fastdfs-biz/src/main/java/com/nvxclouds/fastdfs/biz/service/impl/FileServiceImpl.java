package com.nvxclouds.fastdfs.biz.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import com.nvxclouds.common.core.service.AbstractService;
import com.nvxclouds.fastdfs.biz.config.UploadConfig;
import com.nvxclouds.fastdfs.api.domian.File;
import com.nvxclouds.fastdfs.biz.enums.FastDFSExceptionEnum;
import com.nvxclouds.fastdfs.biz.exception.FastDFSException;
import com.nvxclouds.fastdfs.biz.mapper.FileMapper;
import com.nvxclouds.fastdfs.biz.service.FileService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/18 12:54
 * @Description:
 */
@Service
public class FileServiceImpl extends AbstractService<File> implements FileService {


    @Autowired
    private DefaultFastFileStorageClient fastFileStorageClient;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private UploadConfig uploadConfig;

    private List<String> imageType;

    private List<String> videoType;

    private List<String> othersType;


    @Override
    public String uploadFile(MultipartFile file) {
        String fileMD5 = getFileMD5(file);
        if (StringUtils.isNotBlank(fileMD5)) {
            Long fileIdByMD5 = getFileIdByMD5(fileMD5);
            if (fileIdByMD5 != null) {
                return String.valueOf(fileIdByMD5);
            }
        }
        String originalFilename = file.getOriginalFilename();
        Optional.ofNullable(originalFilename).orElseThrow(()-> new FastDFSException(FastDFSExceptionEnum.FILE_NAME_ERROR));
        String filename = originalFilename.substring(0,originalFilename.lastIndexOf("."));
        String fileType = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        checkFileType(fileType);
        StorePath storePath = uploadFileToFastDfs(file, fileType);
        String fullPath = uploadConfig.getFdfs().concat(storePath.getFullPath());
        File record = new File();
        record.setCreateTime(new Date());
        record.setFullPath(fullPath);
        record.setPath(storePath.getFullPath());
        record.setMd5(fileMD5);
        record.setContentType(file.getContentType());
        record.setExtension(fileType);
        record.setSize(file.getSize());
        record.setStatus(0);
        record.setFileName(filename);
        operate(insertSelective(record),()->new FastDFSException(FastDFSExceptionEnum.FILE_UPLOAD_FAILED));
        return String.valueOf(record.getId());
    }

    @Override
    public File selectFileByIdAndValidate(Long id) {
        File file = selectByPK(id);
        validateNull(file,()->new FastDFSException(FastDFSExceptionEnum.FILE_NOT_EXIST));
        return file;
    }

    private Long getFileIdByMD5(String fileMD5) {
        return fileMapper.selectFileIDByMD5(fileMD5);
    }

    private String getFileMD5(MultipartFile file) {
        try {
            return DigestUtils.md5Hex(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    private StorePath uploadFileToFastDfs(MultipartFile file, String fileType) {
        try {
            return fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), fileType, null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FastDFSException(FastDFSExceptionEnum.UPLOAD_TO_FAST_DFS_ERROR);
        }
    }

    private void checkFileType(String fileType) {
        initFileType();
        List<String> fileTypes = new ArrayList<>();
        fileTypes.addAll(imageType);
        fileTypes.addAll(videoType);
        fileTypes.addAll(othersType);
        if (!fileTypes.contains(fileType.toLowerCase())) {
            throw new FastDFSException(FastDFSExceptionEnum.FILE_TYPE_ERROR);
        }
    }

    void initFileType() {
        this.imageType = uploadConfig.getFileType().getImage();
        this.videoType = uploadConfig.getFileType().getVideo();
        this.othersType = uploadConfig.getFileType().getOthers();
    }
}
