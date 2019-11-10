package com.wx.chapter.controller;

import com.google.gson.Gson;
import com.wx.chapter.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chapter")
public class ChapterController {


    @Autowired
    private ChapterService chapterService;

    @GetMapping("/getNovels")
    @CrossOrigin(origins="http://localhost:8080",allowCredentials="true")
    public String getNovels(){
        List<Map<String, Object>> list = chapterService.getNovels();
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", "20000");
        res.put("data",list);
        return new Gson().toJson(res);
    }

}
