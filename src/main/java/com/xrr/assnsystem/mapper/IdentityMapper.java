package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.po.Identity;

import java.util.List;

public interface IdentityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Identity record);

    Identity selectByPrimaryKey(Long id);

    List<Identity> selectAll();

    int updateByPrimaryKey(Identity record);
}