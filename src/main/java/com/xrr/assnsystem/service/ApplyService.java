package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.ApplyDto;
import com.xrr.assnsystem.dto.PageDto;
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

    /**
     * 获取申请列表
     * @return
     */
    public PageDto<ApplyDto> selectApplyAll(Apply apply, Integer pageNo , Integer pageSize){
        pageNo = pageSize * (pageNo - 1);
        List<ApplyDto> applyDtoList = applyMapper.selectAll(apply,pageNo,pageSize);
        Long count = applyMapper.selectCount(apply);
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
    public Integer updateApplyState(Long applyId,Integer state){
        ApplyDto applyDto = applyMapper.selectByPrimaryKey(applyId);
        Integer state1 = applyDto.getState();
        int result1 = 0;
        int result2 = 0;
        if(0 == state) throw new ServiceException(501, "不能将状态改成申请中");
        if(1 == state1){
            throw new ServiceException(501, "成员已通过申请，不能再做修改。");
        }else{
            result1 = applyMapper.updateState(applyId, state);
            if(1 == state){
                UserActivity userActivity = new UserActivity();
                userActivity.setUserId(applyDto.getUserId());
                userActivity.setAssociationId(applyDto.getAssociationId());
                if(null != applyDto.getDepartmentId())
                    userActivity.setDepartmentId(applyDto.getDepartmentId());
                result2 = userActivityMapper.insert(userActivity);
            }
        }
        if (((2 == state) && (1 != result1))
                || ((1 == state) && (1 != result1) && (1 != result2))) {

            throw new ServiceException(501, "修改状态失败");
        }
        return 1;
    }
}
