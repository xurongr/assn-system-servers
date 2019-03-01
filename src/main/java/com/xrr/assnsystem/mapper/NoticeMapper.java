package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.po.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Notice record);

    Notice selectByPrimaryKey(Long id);

    List<Notice> selectAll();

    int updateByPrimaryKey(Notice record);
}