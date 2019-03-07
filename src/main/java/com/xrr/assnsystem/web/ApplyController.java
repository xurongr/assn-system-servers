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
    @PostMapping("selectApplyAll")
    public ResultDto<PageDto<ApplyDto>> selectApplyAll(@RequestBody Apply apply,
                                                       @RequestParam Integer pageNo ,
                                                       @RequestParam Integer pageSize){
        return ResultDto.ok(applyService.selectApplyAll(apply,pageNo,pageSize));
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
    public ResultDto<ApplyDto> selectApplyById(Long applyId){
        return ResultDto.ok(applyService.selectApplyById(applyId));
    }

}
