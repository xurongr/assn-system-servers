package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.UserDto;
import com.xrr.assnsystem.dto.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    UserDto selectByPrimaryKey(Long id);

    int updateByPrimaryKey(User record);

    /**
     * 查询用户列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<UserDto> selectAll(@Param("identityId")Long identityId,
                            @Param("associationId") Long associationId,
                            @Param("departmentId") Long departmentId,
                            @Param("name") String name,
                            @Param("userName") String userName,
                            @Param("pageNo") Integer pageNo,
                            @Param("pageSize")Integer pageSize);

    /**
     * 查询总数
     * @return
     */
    Long selectCount(@Param("identityId")Long identityId,
                     @Param("associationId") Long associationId,
                     @Param("departmentId") Long departmentId,
                     @Param("name") String name,
                     @Param("userName") String userName);

    /**
     * 通过账号密码查询
     *
     * @param userName
     * @param pwd
     * @return
     */
    UserDto selectByUserNameAndPwd(@Param("userName") String userName, @Param("pwd") String pwd);

    /**
     * 修改密码
     * @param userName
     * @param oldPwd
     * @param newPwd
     * @return
     */
    int updatePwd(@Param("userName") String userName, @Param("oldPwd") String oldPwd, @Param("newPwd") String newPwd);
}