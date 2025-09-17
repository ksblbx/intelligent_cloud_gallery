package com.lbx.cloudgallery.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lbx.cloudgallery.model.dto.spaceuser.SpaceUserAddRequest;
import com.lbx.cloudgallery.model.dto.spaceuser.SpaceUserQueryRequest;
import com.lbx.cloudgallery.model.entity.SpaceUser;
import com.lbx.cloudgallery.model.vo.SpaceUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface SpaceUserService extends IService<SpaceUser> {
    /**
     * 创建空间成员
     *
     * @param spaceUserAddRequest 添加空间参数
     * @param loginUser           登录用户
     * @return 添加的空间ID
     */
    long addSpaceUser(SpaceUserAddRequest spaceUserAddRequest);

    /**
     * 校验空间成员
     *
     * @param spaceUser 空间
     * @param add       true 添加 false 修改
     */
    void validSpaceUser(SpaceUser spaceUser, boolean add);


    /**
     * 获取空间成员包装类（单条）
     *
     * @param spaceUser 空间
     * @param request   请求
     * @return 空间信息
     */
    SpaceUserVO getSpaceUserVO(SpaceUser spaceUser, HttpServletRequest request);

    /**
     * 获取空间成员包装类（列表）
     *
     * @param spaceUserList 空间分页
     * @return 空间信息
     */
    List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);

    /**
     * 获取查询条件
     *
     * @param spaceUserQueryRequest 查询参数
     * @return 查询条件
     */
    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);


}
