package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.ApplyDto;
import com.xrr.assnsystem.dto.po.Apply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Apply record);

    ApplyDto selectByPrimaryKey(Long id);

    List<ApplyDto> selectAll(@Param("userId")Long userId,
                             @Param("associationId")Long associationId,
                             @Param("departmentId")Long departmentId,
                             @Param("type")Long type,
                             @Param("state")Long state,
                             @Param("pageNo") Integer pageNo ,
                             @Param("pageSize")Integer pageSize);

    int updateByPrimaryKey(Apply record);

    /**
     * 查询总数
     * @param apply
     * @return
     */
    Long selectCount(@Param("userId")Long userId,
                     @Param("associationId")Long associationId,
                     @Param("departmentId")Long departmentId,
                     @Param("type")Long type,
                     @Param("state")Long state);

    /**
     * 修改状态
     * @param state
     * @param id
     * @return
     */
    int updateState(@Param("id")Long id,@Param("state")Integer state);

}