package com.xrr.assnsystem.mapper;

import com.xrr.assnsystem.dto.UserActivityDto;
import com.xrr.assnsystem.dto.po.UserActivity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserActivity record);

    UserActivityDto selectByPrimaryKey(Long id);

    int updateByPrimaryKey(UserActivity record);

    /**
     * 根据条件删除
     * @param userId
     * @param associationId
     * @param departmentId
     * @return
     */
    int deleteBy(@Param("userId")Long userId,@Param("associationId")Long associationId,@Param("departmentId")Long departmentId,@Param("activityId") Long  activityId);


    /**
     * 查询某用户参与的所有社团列表
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<UserActivityDto> selectAssociationAllByUserId(@Param("userId")Long userId, @Param("pageNo") Integer pageNo , @Param("pageSize")Integer pageSize);

    /**
     * 查询某用户参与的社团总数
     * @param userId
     * @return
     */
    Long selectCountAssociationAllByUserId(@Param("userId") Long userId);


    /**
     * 查询某用户参与的所有部门列表
     * @param userId
     * @param associationId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<UserActivityDto> selectDepartmentAllByUserId(@Param("userId") Long userId,
                                                      @Param("associationId") Long associationId,
                                                      @Param("pageNo") Integer pageNo,
                                                      @Param("pageSize") Integer pageSize);

    /**
     * 查询某用户参与的部门总数
     * @param userId
     * @param associationId
     * @return
     */
    Long selectCountDepartmentAllByUserId(@Param("userId") Long userId, @Param("associationId") Long associationId);

    /**
     * 根据条件查询成员列表
     * @param associationId
     * @param departmentId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<UserActivityDto> selectUserAll(@Param("associationId") Long  associationId,
                                        @Param("departmentId") Long  departmentId,
                                        @Param("activityId") Long  activityId,
                                        @Param("pageNo") Integer pageNo ,
                                        @Param("pageSize")Integer pageSize);

    /**
     * 根据条件查询成员总数
     * @param associationId
     * @param departmentId
     * @return
     */
    Long selectUserCount(@Param("associationId") Long  associationId,
                         @Param("departmentId") Long  departmentId,
                         @Param("activityId") Long  activityId);
}