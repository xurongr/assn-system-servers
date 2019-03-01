package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.po.Association;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Association record);

    Association selectByPrimaryKey(Long id);

    List<Association> selectAll();

    int updateByPrimaryKey(Association record);
}