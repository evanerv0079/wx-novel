package com.wx.chapter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChapterService {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有小说
     */
    public List<Map<String, Object>> getNovels() {
        String sql = "select * from novel_content ";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}


