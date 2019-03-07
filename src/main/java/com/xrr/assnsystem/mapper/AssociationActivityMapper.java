package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.AssociationActivityDto;
import com.xrr.assnsystem.dto.po.AssociationActivity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AssociationActivity record);

    AssociationActivityDto selectByPrimaryKey(Long id);

    List<AssociationActivityDto> selectAll(@Param("associationId") Long associationId,
                                           @Param("userId") Long userId,
                                           @Param("pageNo") Integer pageNo ,
                                           @Param("pageSize")Integer pageSize);

    int updateByPrimaryKey(AssociationActivity record);

    /**
     * 查询总数
     * @param associationId
     * @param userId
     * @return
     */
    Long selectCount(@Param("associationId") Long associationId, @Param("userId") Long userId);
}