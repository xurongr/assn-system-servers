package com.xrr.assnsystem.web;


import com.xrr.assnsystem.dto.AssociationDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.ResultDto;
import com.xrr.assnsystem.dto.po.Association;
import com.xrr.assnsystem.service.AssociationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"2-1 社团管理"})
public class AssociationController {
    @Autowired
    private AssociationService associationService;

    @ApiOperation("获取社团列表")
    @GetMapping("selectAssociationAll")
    public ResultDto<PageDto<AssociationDto>> selectAssociationAll(@RequestParam(value ="userId",required = false) Long userId,
                                                                @RequestParam(value ="recruitState",required = false) Integer recruitState,
                                                                @RequestParam Integer pageNo ,
                                                                @RequestParam Integer pageSize){
        return ResultDto.ok(associationService.selectAssociationAll(userId,recruitState,pageNo,pageSize));
    }

    @ApiOperation("添加社团")
    @PostMapping("insertAssociation")
    public ResultDto<Integer> insertAssociation(@RequestBody Association association){
        return ResultDto.ok(associationService.insertAssociation(association));
    }

    @ApiOperation("修改社团信息")
    @PostMapping("updateAssociation")
    public ResultDto<Integer> updateAssociation(@RequestBody Association association){
        return ResultDto.ok(associationService.updateAssociation(association));
    }

    @ApiOperation("查询社团")
    @GetMapping("selectAssociationById")
    public ResultDto<AssociationDto> selectAssociationById(Long associationId){
        return ResultDto.ok(associationService.selectAssociationById(associationId));
    }

}
