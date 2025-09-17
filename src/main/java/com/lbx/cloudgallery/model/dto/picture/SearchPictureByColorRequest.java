package com.lbx.cloudgallery.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 按照颜色搜同青丘
 */
@Data
public class SearchPictureByColorRequest implements Serializable {

    /**
     * 图片主色调
     */
    private String picColor;

    /**
     * 空间 id
     */
    private Long spaceId;

    private static final long serialVersionUID = 2122879632339157139L;
}
