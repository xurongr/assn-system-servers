package com.xrr.assnsystem.web;


import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.ResultDto;
import com.xrr.assnsystem.dto.UserActivityDto;
import com.xrr.assnsystem.service.UserActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags ={"1-3 成员管理"})
public class UserActivityCotroller {

    @Autowired
    private UserActivityService userActivityService;

    @ApiOperation("添加用户进社团")
    @GetMapping("insertUserToAssociation")
    public ResultDto<Integer> insertUserToAssociation(@RequestParam Long userId,@RequestParam Long associationId){
        return ResultDto.ok(userActivityService.insertUserToAssociation(userId,associationId));
    }

    @ApiOperation("添加用户进社团里的某部门")
    @GetMapping("insertUserToDepartment")
    public ResultDto<Integer> insertUserToDepartment(@RequestParam  Long userId,
                                                     @RequestParam Long associationId,
                                                     @RequestParam Long departmentId){
        return ResultDto.ok(userActivityService.insertUserToDepartment(userId,associationId,departmentId));
    }

    @ApiOperation("从某社团中删除一个用户（退出该社团）")
    @GetMapping("deleteUserInAssociation")
    public ResultDto<Integer> deleteUserInAssociation(@RequestParam Long userId,@RequestParam Long associationId){
        return ResultDto.ok(userActivityService.deleteUserInAssociation(userId,associationId));
    }

    @ApiOperation("在某部门中删除该用户，保留该用户在社团中的信息、以及其它部门的信息")
    @GetMapping("deleteUserInDepartment")
    public ResultDto<Integer> deleteUserInDepartment(@RequestParam Long userId,
                                                     @RequestParam Long associationId,
                                                     @RequestParam Long departmentId){
        return ResultDto.ok(userActivityService.deleteUserInDepartment(userId,associationId,departmentId));
    }

    @ApiOperation("查询某用户参与的所有社团列表")
    @GetMapping("selectAssociationAllByUserId")
    public ResultDto<PageDto<UserActivityDto>> selectAssociationAllByUserId(@RequestParam Long userId,
                                                                            @RequestParam Integer pageNo,
                                                                            @RequestParam Integer pageSize){
        return ResultDto.ok(userActivityService.selectAssociationAllByUserId(userId,pageNo,pageSize));
    }

    @ApiOperation("查询某用户参与的所有部门列表")
    @GetMapping("selectDepartmentAllByUserId")
    public ResultDto<PageDto<UserActivityDto>> selectDepartmentAllByUserId(@RequestParam Long userId,
                                                                           @RequestParam Long associationId,
                                                                           @RequestParam Integer pageNo,
                                                                           @RequestParam Integer pageSize){
        return ResultDto.ok(userActivityService.selectDepartmentAllByUserId(userId,associationId,pageNo,pageSize));
    }

    @ApiOperation("查询社团成员列表")
    @GetMapping("selectAssociationUserAll")
    public ResultDto<PageDto<UserActivityDto>> selectAssociationUserAll(@RequestParam Long associationId,
                                                                        @RequestParam(value ="name",required = false) String  name,
                                                                        @RequestParam(value ="userName",required = false) String  userName,
                                                                        @RequestParam Integer pageNo,
                                                                        @RequestParam Integer pageSize){
        return ResultDto.ok(userActivityService.selectAssociationUserAll(associationId,name,userName,pageNo,pageSize));
    }

    @ApiOperation("查询部门成员列表")
    @GetMapping("selectDepartmentUserAll")
    public ResultDto<PageDto<UserActivityDto>> selectDepartmentUserAll(@RequestParam Long associationId,
                                                                       @RequestParam Long departmentId,
                                                                       @RequestParam(value ="name",required = false) String  name,
                                                                       @RequestParam(value ="userName",required = false) String  userName,
                                                                       @RequestParam Integer pageNo,
                                                                       @RequestParam Integer pageSize){
        return ResultDto.ok(userActivityService.selectDepartmentUserAll(associationId,departmentId,name,userName,pageNo,pageSize));
    }

    @ApiOperation("参加活动")
    @GetMapping("joinActivity")
    public ResultDto<Integer> joinActivity(@RequestParam Long userId,
                                            @RequestParam Long associationId,
                                            @RequestParam Long activityId){
        return ResultDto.ok(userActivityService.joinActivity(userId,associationId,activityId));
    }

    @ApiOperation("查询参加某活动成员列表")
    @GetMapping("selectActivityUserAll")
    public ResultDto<PageDto<UserActivityDto>> selectActivityUserAll(@RequestParam Long associationId,
                                                                       @RequestParam Long activityId,
                                                                     @RequestParam(value ="name",required = false) String  name,
                                                                     @RequestParam(value ="userName",required = false) String  userName,
                                                                       @RequestParam Integer pageNo,
                                                                       @RequestParam Integer pageSize){
        return ResultDto.ok(userActivityService.selectActivityUserAll(associationId,activityId,name,userName,pageNo,pageSize));
    }

    @ApiOperation("删除参加活动的某用户")
    @GetMapping("deleteUserInActivity")
    public ResultDto<Integer> deleteUserInActivity(@RequestParam Long userId,
                                                    @RequestParam Long associationId,
                                                     @RequestParam Long activityId){
        return ResultDto.ok(userActivityService.deleteUserInActivity(userId,associationId,activityId));
    }
}
