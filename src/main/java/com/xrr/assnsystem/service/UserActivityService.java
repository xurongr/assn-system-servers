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
        Long selectUserCount = userActivityMapper.selectUserCount(userId,associationId, 0L, 0L);
        if(0L != selectUserCount)
            throw new ServiceException(501, "该用户已在该社团中，可将该用户添加到部门中。");
        Integer result = userActivityMapper.insert(UserActivity.builder()
                .userId(userId)
                .associationId(associationId)
                .departmentId(0L)
                .activityId(0L).build());
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
        Long selectUserCount = userActivityMapper.selectUserCount(userId,associationId, departmentId, 0L);
        if(0L != selectUserCount){
            throw new ServiceException(501, "该用户已在该部门中，可将该用户添加到其它部门中。");
        }
        Integer result = userActivityMapper.insert(UserActivity.builder()
                .userId(userId)
                .associationId(associationId)
                .departmentId(departmentId)
                .activityId(0L).build());
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
        Integer result = userActivityMapper.deleteBy(userId, associationId, null,0L);
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
        Integer result = userActivityMapper.deleteBy(userId, associationId, departmentId,0L);
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
        pageNo = pageSize * (pageNo - 1);
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
        pageNo = pageSize * (pageNo - 1);
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
        pageNo = pageSize * (pageNo - 1);
        List<UserActivityDto> userActivityDtos = userActivityMapper.selectUserAll(null,associationId, 0L,0L, pageNo, pageSize);
        Long count = userActivityMapper.selectUserCount(null,associationId, 0L,0L);
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
        pageNo = pageSize * (pageNo - 1);
        List<UserActivityDto> userActivityDtos = userActivityMapper.selectUserAll(null,associationId, departmentId,0L, pageNo, pageSize);
        Long count = userActivityMapper.selectUserCount(null,associationId, departmentId ,0L);
        PageDto<UserActivityDto> pageDto = new PageDto<>();
        pageDto.setData(userActivityDtos);
        pageDto.setTotal(count);
        return pageDto;
    }


    /**
     * 参加活动
     * @param userId
     * @param associationId
     * @param activityId
     * @return
     */
    public Integer joinActivity(Long userId,Long associationId,Long activityId){
        Long selectUserCount = userActivityMapper.selectUserCount(userId,associationId, 0L, activityId);
        if(0L != selectUserCount){
            throw new ServiceException(501, "该用户已参加该活动！");
        }
        Integer result = userActivityMapper.insert(UserActivity.builder()
                .userId(userId)
                .associationId(associationId)
                .departmentId(0L)
                .activityId(activityId).build());
        if(0 == result)
            throw new ServiceException(501, "参加失败");
        return result;
    }

    /**
     * 查询参加某活动成员列表
     * @param associationId
     * @param activityId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<UserActivityDto> selectActivityUserAll(Long associationId,Long activityId, Integer pageNo, Integer pageSize) {
        Assert.notNull(associationId, "社团不能为空");
        Assert.notNull(activityId, "活动不能为空");
        pageNo = pageSize * (pageNo - 1);
        List<UserActivityDto> userActivityDtos = userActivityMapper.selectUserAll(null,associationId, 0L,activityId, pageNo, pageSize);
        Long count = userActivityMapper.selectUserCount(null,associationId,0L,activityId);
        PageDto<UserActivityDto> pageDto = new PageDto<>();
        pageDto.setData(userActivityDtos);
        pageDto.setTotal(count);
        return pageDto;
    }

    /**
     * 删除参加活动的某用户
     * @param userId
     * @param associationId
     * @param activityId
     * @return
     */
    public Integer deleteUserInActivity(Long userId,Long associationId,Long activityId){
        Assert.notNull(userId, "用户不能为空");
        Assert.notNull(associationId, "社团不能为空");
        Assert.notNull(activityId, "活动不能为空");
        Integer result = userActivityMapper.deleteBy(userId, associationId, 0L,activityId);
        if(0 == result)
            throw new ServiceException(501, "删除失败");
        return result;
    }
}
