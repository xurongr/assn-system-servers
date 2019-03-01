package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.po.AssociationActivity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AssociationActivity record);

    AssociationActivity selectByPrimaryKey(Long id);

    List<AssociationActivity> selectAll();

    int updateByPrimaryKey(AssociationActivity record);
}