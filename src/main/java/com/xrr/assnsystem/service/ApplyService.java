package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.ApplyDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.UserActivityDto;
import com.xrr.assnsystem.dto.po.Apply;
import com.xrr.assnsystem.dto.po.UserActivity;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.ApplyMapper;
import com.xrr.assnsystem.mapper.UserActivityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    @Autowired
    private UserActivityMapper userActivityMapper;

    @Autowired
    private AssociationService associationService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取申请列表
     * @return
     */
    public PageDto<ApplyDto> selectApplyAll(Long userId, Long associationId, Long departmentId, Long type, Long state, Integer pageNo , Integer pageSize){
        pageNo = pageSize * (pageNo - 1);
        List<ApplyDto> applyDtoList = applyMapper.selectAll(userId, associationId, departmentId, type, state, pageNo, pageSize);
        Long count = applyMapper.selectCount(userId, associationId, departmentId, type, state);
        PageDto<ApplyDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(applyDtoList);
        return pageDto;
    }

    /**
     * 添加申请
     * @param apply
     * @return
     */
    public Integer insertApply(Apply apply){
        Assert.notNull(apply.getUserId(), "申请人不能为空");
        Assert.notNull(apply.getAssociationId(), "所属社团不能为空");
        Assert.notNull(apply.getIdentityId(), "身份不能为空");
        Assert.notNull(apply.getType(), "申请类型不能为空");
        apply.setState(0);
        if(null == apply.getApplyTime())
        apply.setApplyTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        int result = applyMapper.insert(apply);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改申请
     * @param apply
     * @return
     */
    public Integer updateApply(Apply apply){
        Assert.notNull(apply.getUserId(), "申请人不能为空");
        Assert.notNull(apply.getAssociationId(), "所属社团不能为空");
        int result = applyMapper.updateByPrimaryKey(apply);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询申请
     * @param applyId
     * @return
     */
    public ApplyDto selectApplyById(Long applyId){
        return applyMapper.selectByPrimaryKey(applyId);
    }


    /**
     * 修改申请状态
     * @param applyId
     * @param state
     * @return
     */
    @Transactional
    public Integer updateApplyState(Long applyId, Integer state){
        ApplyDto applyDto = applyMapper.selectByPrimaryKey(applyId);
        Integer result1 = 0;
        Integer result2 = 0;
        if(0 == state) throw new ServiceException(501, "不能将状态改成申请中");
        if(1 == applyDto.getState()){
            throw new ServiceException(501, "已通过申请，不能再做修改!");
        }else{
            result1 = applyMapper.updateState(applyId, state);
            if(0 == applyDto.getType()){
                if(1 == state) {
                    List<UserActivityDto> userActivityDtos = userActivityMapper.selectUserAll(applyDto.getUserId(),
                            null, null, applyDto.getAssociationId(),
                            0L, 0L, 0, 5);
                    if ((null == userActivityDtos) || (userActivityDtos.size() == 0)) {
                        UserActivity userActivity = new UserActivity();
                        userActivity.setUserId(applyDto.getUserId());
                        userActivity.setAssociationId(applyDto.getAssociationId());
                        userActivity.setIdentityId(applyDto.getIdentityId());
                        result2 = userActivityMapper.insert(userActivity);
                        if (null != applyDto.getDepartmentId()) {
                            userActivity.setDepartmentId(applyDto.getDepartmentId());
                            userActivityMapper.insert(userActivity);
                        }
                    } else if(!applyDto.getIdentityId().equals(userActivityDtos.get(0).getIdentityId())) {
                        result2 = userActivityMapper.updateIdentity(applyDto.getUserId(), applyDto.getAssociationId(), applyDto.getIdentityId());
                    } else {throw new ServiceException(501, "成员已经存在社团中，并且信息没有更换，不能通过申请！");}
                }else { result2 = 1;}
            }else if(1 == applyDto.getType()){
                if(1 == state) {
                    result2 = (null != applyDto.getDepartmentId()) ?
                            departmentService.deleteDepartment(applyDto.getDepartmentId())
                            : associationService.deleteAssociation(applyDto.getAssociationId());
                }else { result2 = 1;}
            }else {throw new ServiceException(501, "处理类型不正确，无法进行处理！");}
        }
        if ((0 == result1) || (0 == result2)) {
            throw new ServiceException(501, "修改状态失败");
        }
        return 1;
    }

    /**
     * 删除申请
     * @param applyId
     * @return
     */
    public Integer deleteApply(Long applyId){
        int result = applyMapper.deleteByPrimaryKey(applyId);
        if(0 == result) throw new ServiceException(501, "删除失败");
        return result;
    }
}
