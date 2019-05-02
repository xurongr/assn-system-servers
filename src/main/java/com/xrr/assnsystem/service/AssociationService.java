package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.AssociationDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.po.Association;
import com.xrr.assnsystem.dto.po.UserActivity;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AssociationService {
    @Autowired
    private AssociationMapper associationMapper;

    @Autowired
    private UserActivityMapper userActivityMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private AssociationActivityMapper associationActivityMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 获取社团列表
     * @return
     */
    public PageDto<AssociationDto> selectAssociationAll(Long userId,String associationName, Integer recruitState, Integer pageNo , Integer pageSize){
        pageNo = pageSize * (pageNo - 1);
        List<AssociationDto> associationDtoList = associationMapper.selectAll(userId,associationName,recruitState,pageNo,pageSize);
        Long count = associationMapper.selectCount(userId,associationName,recruitState);
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

        if((null != association.getUserId())||(0 != association.getUserId())) {
            userActivityMapper.insert(UserActivity.builder()
                    .userId(association.getUserId())
                    .associationId(association.getId())
                    .departmentId(0L)
                    .activityId(0L).build());
        }
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

    /**
     * 获取社团信息数量(删除部门前用于确认)
     * @param associationId
     * @return
     */
    public Map<String,Long> getAssociationInfoCount(Long associationId){
        Map<String, Long> map = new HashMap<>();
        Long userCount = userActivityMapper.selectUserCount(null,null,null,associationId, 0L, 0L);
        Long departmentCount = departmentMapper.selectCount(associationId, null,null);
        Long associationActivityCount = associationActivityMapper.selectCount(associationId,null,null);
        Long noticeCount = noticeMapper.selectCount(null,associationId,null);
        map.put("userCount", userCount);
        map.put("departmentCount", departmentCount);
        map.put("associationActivityCount", associationActivityCount);
        map.put("noticeCount", noticeCount);
        return map;
    }

    /**
     * 确认删除社团(执行删除操作)
     * @param associationId
     * @return
     */
    @Transactional
    public Integer deleteAssociation(Long associationId){
        associationMapper.deleteDepartment(associationId);
        associationMapper.deleteAssociationActivity(associationId);
        associationMapper.deleteNotice(associationId);
//        associationMapper.deleteApply(associationId);
        userActivityMapper.deleteBy(null, associationId, null, null);
        int result = associationMapper.deleteByPrimaryKey(associationId);
        if(0 == result) throw new ServiceException(501, "删除失败");
        return result;
    }
}
