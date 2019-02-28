package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.po.UserActivity;

import java.util.List;

public interface UserActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserActivity record);

    UserActivity selectByPrimaryKey(Long id);

    List<UserActivity> selectAll();

    int updateByPrimaryKey(UserActivity record);
}