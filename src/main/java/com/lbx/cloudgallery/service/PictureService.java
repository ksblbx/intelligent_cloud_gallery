package com.lbx.cloudgallery.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lbx.cloudgallery.model.dto.picture.*;
import com.lbx.cloudgallery.model.entity.Picture;
import com.lbx.cloudgallery.model.entity.User;
import com.lbx.cloudgallery.model.vo.PictureVO;

import javax.servlet.http.HttpServletRequest;


public interface PictureService extends IService<Picture> {
    /**
     * 校验图片
     *
     * @param picture 图片
     */
    void validPicture(Picture picture);

    /**
     * 上传图片
     *
     * @param inputSource          文件输入源
     * @param pictureUploadRequest 图片上传参数
     * @param loginUser            登录用户
     * @return 图片信息
     */
    PictureVO uploadPicture(Object inputSource, PictureUploadRequest pictureUploadRequest, User loginUser);


    /**
     * 获取查询条件
     *
     * @param pictureQueryRequest 查询参数
     * @return 查询条件
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    /**
     * 获取图片包装类（单条）
     *
     * @param picture 图片
     * @param request 请求
     * @return 图片信息
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 获取图片包装类（分页）
     *
     * @param picturePage 图片分页
     * @param request     请求
     * @return 图片信息
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);


    /**
     * 图片审核
     *
     * @param pictureReviewRequest 图片审核参数
     * @param loginUser            登录用户
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    /**
     * 填充图片审核参数
     *
     * @param picture   图片
     * @param loginUser 登录用户
     */
    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest 图片批量上传参数
     * @param loginUser                   登录用户
     */
    Integer uploadPictureByBatch(PictureUploadByBatchRequest pictureUploadByBatchRequest, User loginUser);


    /**
     * 清理图片文件
     *
     * @param oldPicture
     */
    void clearPictureFiles(Picture oldPicture);

    /**
     * 删除图片
     *
     * @param pictureId 图片ID
     * @param loginUser 登录用户
     */
    void deletePicture(Long pictureId, User loginUser);

    /**
     * 编辑图片
     *
     * @param pictureEditRequest 图片编辑参数
     * @param loginUser          登录用户
     */
    void editPicture(PictureEditRequest pictureEditRequest, User loginUser);

    /**
     * 检查空间图片的权限
     *
     * @param picture
     * @param loginUser
     */
    void checkPictureAuth(Picture picture, User loginUser);
}
