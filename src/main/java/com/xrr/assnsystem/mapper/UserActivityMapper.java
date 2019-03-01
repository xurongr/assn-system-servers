package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.po.UserActivity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserActivity record);

    UserActivity selectByPrimaryKey(Long id);

    List<UserActivity> selectAll();

    int updateByPrimaryKey(UserActivity record);
}