package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.po.Apply;

import java.util.List;

public interface ApplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Apply record);

    Apply selectByPrimaryKey(Long id);

    List<Apply> selectAll();

    int updateByPrimaryKey(Apply record);
}