package com.xrr.assnsystem.web;


import com.xrr.assnsystem.dto.DepartmentDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.ResultDto;
import com.xrr.assnsystem.dto.po.Department;
import com.xrr.assnsystem.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"3-1 部门管理"})
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("获取部门列表")
    @GetMapping("selectDepartmentAll")
    public ResultDto<PageDto<DepartmentDto>> selectDepartmentAll(@RequestParam(value ="associationId",required = false) Long associationId,
                                                                 @RequestParam(value ="ministerUserId",required = false) Long ministerUserId,
                                                                 @RequestParam(value ="departmentName",required = false) String departmentName,
                                                                 @RequestParam Integer pageNo ,
                                                                 @RequestParam Integer pageSize){
        return ResultDto.ok(departmentService.selectDepartmentAll(associationId,ministerUserId,departmentName,pageNo,pageSize));
    }

    @ApiOperation("添加部门")
    @PostMapping("insertDepartment")
    public ResultDto<Integer> insertDepartment(@RequestBody Department department){
        return ResultDto.ok(departmentService.insertDepartment(department));
    }

    @ApiOperation("修改部门")
    @PostMapping("updateDepartment")
    public ResultDto<Integer> updateDepartment(@RequestBody Department department){
        return ResultDto.ok(departmentService.updateDepartment(department));
    }

    @ApiOperation("查询社团")
    @GetMapping("selectDepartmentById")
    public ResultDto<DepartmentDto> selectDepartmentById(@RequestParam Long departmentId){
        return ResultDto.ok(departmentService.selectDepartmentById(departmentId));
    }

    @ApiOperation("获取成员数量(删除部门前用于确认)")
    @GetMapping("getDepartmentUserCount")
    public ResultDto<Long> getDepartmentUserCount(@RequestParam Long departmentId){
        return ResultDto.ok(departmentService.getDepartmentUserCount(departmentId));
    }

    @ApiOperation("确认删除部门(执行删除操作)")
    @GetMapping("deleteDepartment")
    public ResultDto<Integer> deleteDepartment(@RequestParam Long departmentId){
        return ResultDto.ok(departmentService.deleteDepartment(departmentId));
    }
}
