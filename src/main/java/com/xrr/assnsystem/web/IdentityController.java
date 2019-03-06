package com.xrr.assnsystem.web;


import com.xrr.assnsystem.dto.ResultDto;
import com.xrr.assnsystem.dto.po.Identity;
import com.xrr.assnsystem.service.IdentityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags ={"1-2 身份管理"})
public class IdentityController {
    @Autowired
    private IdentityService identityService;

    @ApiOperation("获取身份列表")
    @GetMapping("selectIdentityList")
    public ResultDto<List<Identity>> selectIdentityAll(){
        return ResultDto.ok(identityService.selectIdentityAll());
    }

    @ApiOperation("添加身份")
    @PostMapping("insertIdentity")
    public ResultDto<Integer> insertIdentity(@RequestBody Identity identity){
        return ResultDto.ok(identityService.insertIdentity(identity));
    }

    @ApiOperation("修改身份信息")
    @PostMapping("updateIdentity")
    public ResultDto<Integer> updateIdentity(@RequestBody Identity identity){
        return ResultDto.ok(identityService.updateIdentity(identity));
    }

    @ApiOperation("查询身份")
    @GetMapping("selectIdentityById")
    public ResultDto<Identity> selectIdentityById(Long identityId){
        return ResultDto.ok(identityService.selectIdentityById(identityId));
    }

}
