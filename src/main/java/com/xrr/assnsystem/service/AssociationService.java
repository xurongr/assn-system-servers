package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.AssociationDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.po.Association;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.AssociationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AssociationService {
    @Autowired
    private AssociationMapper associationMapper;

    /**
     * 获取社团列表
     * @return
     */
    public PageDto<AssociationDto> selectAssociationAll(Long userId, Integer recruitState, Integer pageNo , Integer pageSize){
        List<AssociationDto> associationDtoList = associationMapper.selectAll(userId,recruitState,pageNo,pageSize);
        Long count = associationMapper.selectCount(userId,recruitState);
        PageDto<AssociationDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(associationDtoList);
        return pageDto;
    }

    /**
     * 添加社团
     * @param association
     * @return
     */
    public Integer insertAssociation(Association association){
        Assert.notNull(association.getAssociationName(), "社团名称不能为空");
        if(null == association.getCreateTime())
        association.setCreateTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        int result = associationMapper.insert(association);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改社团信息
     * @param association
     * @return
     */
    public Integer updateAssociation(Association association){
        int result = associationMapper.updateByPrimaryKey(association);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询社团
     * @param associationId
     * @return
     */
    public AssociationDto selectAssociationById(Long associationId){
        return associationMapper.selectByPrimaryKey(associationId);
    }
}
