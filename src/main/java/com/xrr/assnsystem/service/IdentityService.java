package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.po.Identity;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.IdentityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IdentityService {

    @Autowired
    private IdentityMapper identityMapper;

    /**
     * 获取身份列表
     * @return
     */
    public List<Identity> selectIdentityAll(){
        List<Identity> identityList = identityMapper.selectAll();
        if ((null == identityList) || (identityList.isEmpty()) || (0 == identityList.size())) {
            throw new ServiceException(501, "获取列表失败");
        }
        return identityList;
    }

    /**
     * 添加身份
     * @param identity
     * @return
     */
    public Integer insertIdentity(Identity identity){
        int result = identityMapper.insert(identity);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改身份信息
     * @param identity
     * @return
     */
    public Integer updateIdentity(Identity identity){
        int result = identityMapper.updateByPrimaryKey(identity);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询身份
     * @param identityId
     * @return
     */
    public Identity selectIdentityById(Long identityId){
        return identityMapper.selectByPrimaryKey(identityId);
    }

}
