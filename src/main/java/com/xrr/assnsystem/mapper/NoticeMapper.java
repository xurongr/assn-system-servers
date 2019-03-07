package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.NoticeDto;
import com.xrr.assnsystem.dto.po.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Notice record);

    NoticeDto selectByPrimaryKey(Long id);

    List<NoticeDto> selectAll(@Param("userId") Long userId,@Param("type") Integer type,@Param("pageNo") Integer pageNo , @Param("pageSize")Integer pageSize);

    int updateByPrimaryKey(Notice record);

    /**
     * 查询总数
     * @param userId
     * @param type
     * @return
     */
    Long selectCount(@Param("userId") Long userId,@Param("type") Integer type);
}