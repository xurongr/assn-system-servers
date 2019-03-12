package com.xrr.assnsystem.web;


import com.xrr.assnsystem.dto.NoticeDto;
import com.xrr.assnsystem.dto.PageDto;
import com.xrr.assnsystem.dto.ResultDto;
import com.xrr.assnsystem.dto.po.Notice;
import com.xrr.assnsystem.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"4-1 公告管理"})
public class NoticController {
    @Autowired
    private NoticeService noticeService;

    @ApiOperation("获取公告列表")
    @GetMapping("selectNoticeAll")
    public ResultDto<PageDto<NoticeDto>> selectNoticeAll(@RequestParam Long userId ,
                                                         @RequestParam Long associationId,
                                                         @RequestParam Integer type,
                                                         @RequestParam Integer pageNo ,
                                                         @RequestParam Integer pageSize){
        return ResultDto.ok(noticeService.selectNoticeAll(userId,associationId,type,pageNo,pageSize));
    }

    @ApiOperation("添加公告")
    @PostMapping("insertNotice")
    public ResultDto<Integer> insertNotice(@RequestBody Notice notice){
        return ResultDto.ok(noticeService.insertNotice(notice));
    }

    @ApiOperation("修改公告")
    @PostMapping("updateNotice")
    public ResultDto<Integer> updateNotice(@RequestBody Notice notice){
        return ResultDto.ok(noticeService.updateNotice(notice));
    }

    @ApiOperation("查询公告")
    @GetMapping("selectNoticeById")
    public ResultDto<NoticeDto> selectNoticeById(@RequestParam Long noticeId){
        return ResultDto.ok(noticeService.selectNoticeById(noticeId));
    }

}
