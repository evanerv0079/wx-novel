package com.wx.novel.controller;


import com.google.gson.Gson;
import com.wx.novel.entity.NovelContent;
import com.wx.novel.service.INovelContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lh
 * @since 2019-11-02
 */
@RestController
@RequestMapping("/novel")
public class NovelContentController {

    @Autowired
    private INovelContentService contentService;

    @GetMapping("/getNovels")
    @CrossOrigin(origins="http://localhost:8080",allowCredentials="true")
    public String getNovels(){
        List<NovelContent> contents =  contentService.list();
        return  new Gson().toJson(contents);
    }

}
