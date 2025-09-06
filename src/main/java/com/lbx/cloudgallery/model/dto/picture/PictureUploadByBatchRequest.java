package com.lbx.cloudgallery.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片上传请求
 */
@Data
public class PictureUploadByBatchRequest implements Serializable {

    /**
     * 图片 id（用于修改）
     */
    private String searchText;
    /**
     * 抓取数量
     */
    private Integer count = 10;
    /**
     * 图片名称前缀
     */
    private String namePrefix;

    private static final long serialVersionUID = -915525962906069426L;
}
