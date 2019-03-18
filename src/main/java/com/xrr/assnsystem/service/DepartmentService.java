package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.DepartmentDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.po.Department;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.DepartmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取部门列表
     * @return
     */
    public PageDto<DepartmentDto> selectDepartmentAll(Long associationId, Long ministerUserId, Integer pageNo , Integer pageSize){
        pageNo = pageSize * (pageNo - 1);
        List<DepartmentDto> departmentDtoList = departmentMapper.selectAll(associationId,ministerUserId,pageNo,pageSize);
        Long count = departmentMapper.selectCount(associationId,ministerUserId);
        PageDto<DepartmentDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(departmentDtoList);
        return pageDto;
    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    public Integer insertDepartment(Department department){
        Assert.notNull(department.getAssociationId(), "所属社团ID不能为空");
        Assert.notNull(department.getDepartmentName(), "部门名称不能为空");
        if(null == department.getCreateTime())
        department.setCreateTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        int result = departmentMapper.insert(department);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    public Integer updateDepartment(Department department){
        Assert.notNull(department.getAssociationId(), "所属社团ID不能为空");
        Assert.notNull(department.getDepartmentName(), "部门名称不能为空");
        int result = departmentMapper.updateByPrimaryKey(department);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询社团
     * @param departmentId
     * @return
     */
    public DepartmentDto selectDepartmentById(Long departmentId){
        return departmentMapper.selectByPrimaryKey(departmentId);
    }
}
