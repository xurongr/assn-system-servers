package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.UserActivityDto;
import com.xrr.assnsystem.dto.po.UserActivity;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.UserActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserActivityService {
    @Autowired
    private UserActivityMapper userActivityMapper;



    /**
     * 添加用户进社团
     * @param userId
     * @param associationId
     * @return
     */
    public Integer insertUserToAssociation(Long userId,Long associationId){
        Assert.notNull(userId, "用户不能为空");
        Assert.notNull(associationId, "社团不能为空");
        UserActivityDto userActivityDto = userActivityMapper.selectByPrimaryKey(associationId);
        if((null != userActivityDto.getUserId()) && userId.equals(userActivityDto.getUserId()))
            throw new ServiceException(501, "该用户已在该社团中，可将该用户添加到部门中。");
        Integer result = userActivityMapper.insert(UserActivity.builder()
                .userId(userId)
                .associationId(associationId)
                .departmentId(0L).build());
        if(0 == result)
            throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 添加用户进社团里的某部门
     * @param userId
     * @param associationId
     * @param departmentId
     * @return
     */
    public Integer insertUserToDepartment(Long userId,Long associationId,Long departmentId){
        Assert.notNull(userId, "用户不能为空");
        Assert.notNull(associationId, "社团不能为空");
        Assert.notNull(departmentId, "部门不能为空");
        UserActivityDto userActivityDto = userActivityMapper.selectByPrimaryKey(associationId);
        if((null != userActivityDto.getUserId())
                &&(null != userActivityDto.getDepartmentId())
                &&(userId.equals(userActivityDto.getUserId()))
                &&(departmentId.equals(userActivityDto.getDepartmentId()))){
            throw new ServiceException(501, "该用户已在该部门中，可将该用户添加到其它部门中。");
        }
        Integer result = userActivityMapper.insert(UserActivity.builder()
                .userId(userId)
                .associationId(associationId)
                .departmentId(departmentId).build());
        if(0 == result)
            throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 从某社团中删除一个用户（退出该社团）
     * @param userId
     * @param associationId
     * @return
     */
    public Integer deleteUserInAssociation(Long userId,Long associationId){
        Assert.notNull(userId, "用户不能为空");
        Assert.notNull(associationId, "社团不能为空");
        Integer result = userActivityMapper.deleteBy(userId, associationId, null);
        if(0 == result)
            throw new ServiceException(501, "删除失败");
        return result;
    }

    /**
     * 在某部门中删除该用户，保留该用户在社团中的信息、以及其它部门的信息
     * @param userId
     * @param associationId
     * @param departmentId
     * @return
     */
    public Integer deleteUserInDepartment(Long userId,Long associationId,Long departmentId){
        Assert.notNull(userId, "用户不能为空");
        Assert.notNull(associationId, "社团不能为空");
        Assert.notNull(departmentId, "部门不能为空");
        Integer result = userActivityMapper.deleteBy(userId, associationId, departmentId);
        if(0 == result)
            throw new ServiceException(501, "删除失败");
        return result;
    }

    /**
     * 查询某用户参与的所有社团列表
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<UserActivityDto> selectAssociationAllByUserId(Long userId, Integer pageNo , Integer pageSize){
        Assert.notNull(userId, "用户不能为空");
        List<UserActivityDto> userActivityDtos = userActivityMapper.selectAssociationAllByUserId(userId, pageNo, pageSize);
        Long count = userActivityMapper.selectCountAssociationAllByUserId(userId);
        PageDto<UserActivityDto> pageDto = new PageDto<>();
        pageDto.setData(userActivityDtos);
        pageDto.setTotal(count);
        return pageDto;
    }

    /**
     * 查询某用户参与的所有部门列表
     * @param userId
     * @param associationId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<UserActivityDto> selectDepartmentAllByUserId(Long userId,Long associationId, Integer pageNo , Integer pageSize){
        Assert.notNull(userId, "用户不能为空");
        List<UserActivityDto> activityDtos = userActivityMapper.selectDepartmentAllByUserId(userId,associationId, pageNo, pageSize);
        Long count = userActivityMapper.selectCountDepartmentAllByUserId(userId,associationId);
        PageDto<UserActivityDto> pageDto = new PageDto<>();
        pageDto.setData(activityDtos);
        pageDto.setTotal(count);
        return pageDto;
    }


    /**
     * 查询社团成员列表
     * @param associationId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<UserActivityDto> selectAssociationUserAll(Long associationId, Integer pageNo, Integer pageSize) {
        Assert.notNull(associationId, "社团不能为空");
        List<UserActivityDto> userActivityDtos = userActivityMapper.selectUserAll(associationId, 0L, pageNo, pageSize);
        Long count = userActivityMapper.selectUserCount(associationId, 0L);
        PageDto<UserActivityDto> pageDto = new PageDto<>();
        pageDto.setData(userActivityDtos);
        pageDto.setTotal(count);
        return pageDto;
    }

    /**
     * 查询部门成员列表
     * @param associationId
     * @param departmentId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<UserActivityDto> selectDepartmentUserAll(Long associationId,Long departmentId, Integer pageNo, Integer pageSize) {
        Assert.notNull(associationId, "社团不能为空");
        Assert.notNull(departmentId, "部门不能为空");
        List<UserActivityDto> userActivityDtos = userActivityMapper.selectUserAll(associationId, departmentId, pageNo, pageSize);
        Long count = userActivityMapper.selectUserCount(associationId, departmentId);
        PageDto<UserActivityDto> pageDto = new PageDto<>();
        pageDto.setData(userActivityDtos);
        pageDto.setTotal(count);
        return pageDto;
    }


}