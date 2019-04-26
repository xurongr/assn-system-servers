package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.AssociationDto;
import com.xrr.assnsystem.dto.po.Association;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Association record);

    AssociationDto selectByPrimaryKey(Long id);

    List<AssociationDto> selectAll(@Param("userId") Long userId,
                                   @Param("associationName") String associationName,
                                   @Param("recruitState") Integer recruitState,
                                   @Param("pageNo") Integer pageNo,
                                   @Param("pageSize")Integer pageSize);

    int updateByPrimaryKey(Association record);

    /**
     * 查询总数
     * @param userId
     * @param recruitState
     * @return
     */
    Long selectCount(@Param("userId") Long userId,
                     @Param("associationName") String associationName,
                     @Param("recruitState") Integer recruitState);


    int deleteDepartment(Long associationId);
    int deleteAssociationActivity(Long associationId);
    int deleteNotice(Long associationId);
    int deleteApply(Long associationId);

}