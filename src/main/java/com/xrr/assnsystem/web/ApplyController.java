package com.xrr.assnsystem.web;


import com.xrr.assnsystem.dto.ApplyDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.ResultDto;
import com.xrr.assnsystem.dto.po.Apply;
import com.xrr.assnsystem.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"2-3 入团申请"})
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @ApiOperation("获取申请列表")
    @GetMapping("selectApplyAll")
    public ResultDto<PageDto<ApplyDto>> selectApplyAll(Long userId,
                                                       @RequestParam Long associationId,
                                                       @RequestParam Long departmentId,
                                                       @RequestParam Long type,
                                                       @RequestParam Long state,
                                                       @RequestParam Integer pageNo ,
                                                       @RequestParam Integer pageSize){
        return ResultDto.ok(applyService.selectApplyAll(userId, associationId, departmentId, type, state, pageNo, pageSize));
    }

    @ApiOperation("添加申请")
    @PostMapping("insertApply")
    public ResultDto<Integer> insertApply(@RequestBody Apply apply){
        return ResultDto.ok(applyService.insertApply(apply));
    }

    @ApiOperation("修改申请(不能修改申请状态)")
    @PostMapping("updateApply")
    public ResultDto<Integer> updateApply(@RequestBody Apply apply){
        return ResultDto.ok(applyService.updateApply(apply));
    }

    @ApiOperation("查询申请")
    @GetMapping("selectApplyById")
    public ResultDto<ApplyDto> selectApplyById(@RequestParam Long applyId){
        return ResultDto.ok(applyService.selectApplyById(applyId));
    }

    @ApiOperation("修改申请状态")
    @GetMapping("updateApplyState")
    public ResultDto<Integer> updateApplyState(@RequestParam Long applyId,@RequestParam Integer state){
        return ResultDto.ok(applyService.updateApplyState(applyId,state));
    }

    @ApiOperation("删除申请记录")
    @GetMapping("deleteApply")
    public ResultDto<Integer> deleteApply(@RequestParam Long applyId){
        return ResultDto.ok(applyService.deleteApply(applyId));
    }

}
