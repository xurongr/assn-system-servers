package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.po.Identity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Identity record);

    Identity selectByPrimaryKey(Long id);

    List<Identity> selectAll();

    int updateByPrimaryKey(Identity record);
}