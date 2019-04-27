package com.xrr.assnsystem.web;

import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.ResultDto;
import com.xrr.assnsystem.dto.UserDto;
import com.xrr.assnsystem.dto.po.User;
import com.xrr.assnsystem.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"1-1 账户管理"})
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("login")
    public ResultDto<UserDto> longin(@ApiParam(name = "user", value = "参数（userName，pwd）") @RequestBody User user){
        return ResultDto.ok(userService.login(user.getUserName(), user.getPwd()));
    }

    @ApiOperation("修改密码")
    @GetMapping("updatePwd")
    public ResultDto<Integer> updatePwd(@RequestParam String userName,@RequestParam String oldPwd,@RequestParam String newPwd){
        return ResultDto.ok(userService.updatePwd(userName, oldPwd, newPwd));
    }

    @ApiOperation("强制修改密码")
    @GetMapping("updatePwdById")
    public ResultDto<Integer> updatePwdById(@RequestParam Long userId,@RequestParam String pwd){
        return ResultDto.ok(userService.updatePwdById(userId, pwd));
    }

    @ApiOperation("添加新账户")
    @PostMapping("insertUser")
    public ResultDto<Integer> insertUser(@RequestBody User user){
        return ResultDto.ok(userService.insertUser(user));
    }

    @ApiOperation("修改用户信息(不能改密码,不能修改职务)")
    @PostMapping("updateUser")
    public ResultDto<Integer> updateUser(@RequestBody User users){
        return ResultDto.ok(userService.updateUser(users));
    }

    @ApiOperation("查询所有用户列表")
    @GetMapping("selectUsersAll")
    public ResultDto<PageDto<UserDto>> selectUsersAll(@RequestParam(value ="name",required = false) String name,
                                                      @RequestParam(value ="userName",required = false) String userName,
                                                      @RequestParam Integer pageNo,
                                                      @RequestParam Integer pageSize){
        return ResultDto.ok(userService.selectUsersAll(name,userName,pageNo,pageSize));
    }

    @ApiOperation("查询用户信息")
    @GetMapping("selectByUserId")
    public ResultDto<UserDto> selectByUserId(@RequestParam Long UserId){
        return ResultDto.ok(userService.selectByUserId(UserId));
    }

    @ApiOperation("修改职务")
    @GetMapping("updateJob")
    public ResultDto<Integer> updateJob(@RequestParam String  job ,@RequestParam Long userId,@RequestParam Long  associationId){
        return ResultDto.ok(userService.updateJob(job, userId, associationId));
    }

}
