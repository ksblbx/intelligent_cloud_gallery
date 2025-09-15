package com.lbx.cloudgallery.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lbx.cloudgallery.model.dto.space.SpaceAddRequest;
import com.lbx.cloudgallery.model.dto.space.SpaceQueryRequest;
import com.lbx.cloudgallery.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lbx.cloudgallery.model.entity.User;
import com.lbx.cloudgallery.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 罗倍欣
 * @description 针对表【space(空间)】的数据库操作Service
 * @createDate 2025-09-05 23:43:01
 */
public interface SpaceService extends IService<Space> {


    /**
     * 创建空间
     *
     * @param spaceAddRequest 添加空间参数
     * @param loginUser       登录用户
     * @return 添加的空间ID
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 校验空间
     *
     * @param space 空间
     * @param add   true 添加 false 修改
     */
    void validSpace(Space space, boolean add);

    /**
     * 获取查询条件
     *
     * @param spaceQueryRequest 查询参数
     * @return 查询条件
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 获取空间包装类（单条）
     *
     * @param space   空间
     * @param request 请求
     * @return 空间信息
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 获取空间包装类（分页）
     *
     * @param spacePage 空间分页
     * @param request   请求
     * @return 空间信息
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 根据空间级别填充空间对象
     *
     * @param space 空间
     */
    void fillSpaceBySpaceLevel(Space space);


    /**
     * 校验空间权限
     *
     * @param space
     * @param loginUser
     */
    void checkSpaceAuth(Space space, User loginUser);
}
