package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.UserDto;
import com.xrr.assnsystem.dto.po.User;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 登录
     * @param userName
     * @param pwd
     * @return
     */
   public UserDto login(String userName, String pwd){
       Assert.notNull(userName, "用户名不能为空");
       Assert.notNull(pwd, "密码不能为空");
       UserDto userDto = userMapper.selectByUserNameAndPwd(userName, pwd);
       if(null == userDto) throw new ServiceException(501, "账号或密码错误");
       return userDto;
   }

    /**
     * 修改密码
     * @param userName
     * @param oldPwd
     * @param newPwd
     * @return
     */
    public Integer updatePwd(String userName, String oldPwd, String newPwd) {
        Assert.notNull(userName, "用户名不能为空");
        Assert.isTrue("admin".equals(userName), "admin账号不允许修改密码");
        Assert.notNull(oldPwd,"旧密码不能为空");
        Assert.notNull(newPwd,"新密码不能为空");
        int result = userMapper.updatePwd(userName, oldPwd, newPwd);
        if (0 == result) throw new ServiceException(501, "账号或密码错误");
        return result;
    }


    /**
     * 添加新账户
     * @param users
     * @return
     */
    public Integer insertUser(User users){
        Assert.notNull(users.getUserName(), "用户名不能为空");
        Assert.notNull(users.getPwd(), "密码不能为空");
        Assert.notNull(users.getIdentityId(), "必须绑定身份");
        List<UserDto> usersList = userMapper
                .selectAll(null,null,null,users.getUserName(),0,99);
        if(0 != usersList.size())
            throw new ServiceException(501, "该用户名已存在！");
        int result = userMapper.insert(users);
        if (0 == result) throw new ServiceException(501, "添加账号失败");
        return result;
    }

    /**
     * 修改用户信息
     * @param users
     * @return
     */
    public Integer updateUser(User users){
        Assert.notNull(users.getIdentityId(), "必须绑定身份");
        int result = userMapper.updateByPrimaryKey(users);
        return result;
    }

    /**
     * 修改职务
     * @param job
     * @param userId
     * @param associationId
     * @return
     */
    public Integer updateJob(String  job , Long userId,Long  associationId){
        Assert.notNull(userId, "用户ID不能为空");
        Assert.notNull(job, "职务不能为空");
        Assert.notNull(associationId, "社团不能为空");
        int result = userMapper.updateJob(job, userId, associationId);
        return result;
    }

    /**
     * 查询所有用户列表
     * @param identityId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<UserDto> selectUsersAll(Long identityId,
                                           String identityName,
                                           String name,
                                           String userName,
                                           Integer pageNo,
                                           Integer pageSize) {
        pageNo = pageSize * (pageNo - 1);
        List<UserDto> users = userMapper.selectAll(identityId,identityName,name,userName,pageNo,pageSize);
        Long count = userMapper.selectCount(identityId,identityName,name,userName);
        PageDto<UserDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(users);
        return pageDto;
    }

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public UserDto selectByUserId(Long userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 删除账户
     * @param userId
     * @return
     */
    public Integer deleteUser(Long userId){
        int result = userMapper.deleteByPrimaryKey(userId);
        if (0 == result) throw new ServiceException(501, "删除账号失败");
        return result;
    }


}
