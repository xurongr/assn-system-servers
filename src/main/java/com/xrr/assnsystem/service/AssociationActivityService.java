package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.AssociationActivityDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.po.AssociationActivity;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.AssociationActivityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AssociationActivityService {
    @Autowired
    private AssociationActivityMapper associationActivityMapper;

    /**
     * 获取社团活动列表
     * @return
     */
    public PageDto<AssociationActivityDto> selectAssnAAll(Long associationId, Long userId, Integer pageNo , Integer pageSize){
        pageNo = pageSize * (pageNo - 1);
        List<AssociationActivityDto> associationActivityDtoList = associationActivityMapper.selectAll(associationId,userId,pageNo,pageSize);
        Long count = associationActivityMapper.selectCount(associationId,userId);
        PageDto<AssociationActivityDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(associationActivityDtoList);
        return pageDto;
    }

    /**
     * 添加社团活动
     * @param associationActivity
     * @return
     */
    public Integer insertAssnA(AssociationActivity associationActivity){
        Assert.notNull(associationActivity.getAssociationId(), "所属社团ID不能为空");
        Assert.notNull(associationActivity.getActivityName(), "活动名称不能为空");
        if(null == associationActivity.getStartTime())
        associationActivity.setStartTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        int result = associationActivityMapper.insert(associationActivity);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改社团活动
     * @param associationActivity
     * @return
     */
    public Integer updateAssnA(AssociationActivity associationActivity){
        Assert.notNull(associationActivity.getAssociationId(), "所属社团ID不能为空");
        Assert.notNull(associationActivity.getActivityName(), "活动名称不能为空");
        int result = associationActivityMapper.updateByPrimaryKey(associationActivity);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询社团活动
     * @param associationActivityId
     * @return
     */
    public AssociationActivityDto selectAssnAById(Long associationActivityId){
        return associationActivityMapper.selectByPrimaryKey(associationActivityId);
    }
}
