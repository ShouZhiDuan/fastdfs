package com.nvxclouds.fastdfs.api.domian;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "file")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;
    @Column(name = "md5")
    private String md5;
    @Column(name = "path")
    private String path;
    @Column(name = "full_path")
    private String fullPath;
    @Column(name = "size")
    private Long size;
    @Column(name = "extension")
    private String extension;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "status")
    private Integer status;
    @Column(name = "comments")
    private String comments;

}
