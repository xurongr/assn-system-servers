package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.DepartmentDto;
import com.xrr.assnsystem.dto.po.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    DepartmentDto selectByPrimaryKey(Long id);

    List<DepartmentDto> selectAll(@Param("associationId") Long associationId,
                                  @Param("ministerUserId") Long ministerUserId,
                                  @Param("pageNo") Integer pageNo ,
                                  @Param("pageSize")Integer pageSize);

    int updateByPrimaryKey(Department record);


    /**
     * 查询总数
     * @param associationId
     * @param ministerUserId
     * @return
     */
    Long selectCount(@Param("associationId") Long associationId, @Param("ministerUserId") Long ministerUserId);
}