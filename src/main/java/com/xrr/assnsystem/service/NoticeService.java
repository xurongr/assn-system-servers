package com.xrr.assnsystem.service;

import com.xrr.assnsystem.dto.NoticeDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.po.Notice;
import com.xrr.assnsystem.exception.ServiceException;
import com.xrr.assnsystem.mapper.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 获取公告列表
     * @return
     */
    public PageDto<NoticeDto> selectNoticeAll(Long userId,Long associationId, Integer type, Integer pageNo , Integer pageSize){
        List<NoticeDto> noticeDtoList = noticeMapper.selectAll(userId,associationId,type,pageNo,pageSize);
        Long count = noticeMapper.selectCount(userId,associationId,type);
        PageDto<NoticeDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(noticeDtoList);
        return pageDto;
    }

    /**
     * 添加公告
     * @param notice
     * @return
     */
    public Integer insertNotice(Notice notice){
        Assert.notNull(notice.getUserId(), "发布人不能为空");
        Assert.notNull(notice.getContent(), "内容不能为空");
        Assert.notNull(notice.getType(), "类型不能为空");
        if(null == notice.getCreateTime())
        notice.setCreateTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        int result = noticeMapper.insert(notice);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    public Integer updateNotice(Notice notice){
        Assert.notNull(notice.getUserId(), "发布人不能为空");
        Assert.notNull(notice.getContent(), "内容不能为空");
        Assert.notNull(notice.getType(), "类型不能为空");
        int result = noticeMapper.updateByPrimaryKey(notice);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询公告
     * @param noticeId
     * @return
     */
    public NoticeDto selectNoticeById(Long noticeId){
        return noticeMapper.selectByPrimaryKey(noticeId);
    }
}
