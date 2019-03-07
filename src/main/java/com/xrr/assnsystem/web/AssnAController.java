package com.xrr.assnsystem.web;


import com.xrr.assnsystem.dto.AssociationActivityDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.ResultDto;
import com.xrr.assnsystem.dto.po.AssociationActivity;
import com.xrr.assnsystem.service.AssociationActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"2-2 社团活动"})
public class AssnAController {
    @Autowired
    private AssociationActivityService associationActivityService;

    @ApiOperation("获取社团活动列表")
    @GetMapping("selectAssnAAll")
    public ResultDto<PageDto<AssociationActivityDto>> selectAssnAAll(@RequestParam Long associationId,
                                                                     @RequestParam Long userId,
                                                                     @RequestParam Integer pageNo ,
                                                                     @RequestParam Integer pageSize){
        return ResultDto.ok(associationActivityService.selectAssnAAll(associationId,userId,pageNo,pageSize));
    }

    @ApiOperation("添加社团活动")
    @PostMapping("insertAssnA")
    public ResultDto<Integer> insertAssnA(@RequestBody AssociationActivity associationActivity){
        return ResultDto.ok(associationActivityService.insertAssnA(associationActivity));
    }

    @ApiOperation("修改社团活动")
    @PostMapping("updateAssnA")
    public ResultDto<Integer> updateAssnA(@RequestBody AssociationActivity associationActivity){
        return ResultDto.ok(associationActivityService.updateAssnA(associationActivity));
    }

    @ApiOperation("查询社团活动")
    @GetMapping("selectAssnAById")
    public ResultDto<AssociationActivityDto> selectAssnAById(Long associationActivityId){
        return ResultDto.ok(associationActivityService.selectAssnAById(associationActivityId));
    }

}
