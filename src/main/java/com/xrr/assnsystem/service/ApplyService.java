package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.ApplyDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.po.Apply;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.ApplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    /**
     * 获取申请列表
     * @return
     */
    public PageDto<ApplyDto> selectApplyAll(Apply apply, Integer pageNo , Integer pageSize){
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
//
//    @Transactional
//    public Integer updateApplyState(Long applyId,Integer state){
//        int i = 0;
//        if (2 == state) {
//            i = applyMapper.updateState(applyId, state);
//        }
//
//
//    }
}
