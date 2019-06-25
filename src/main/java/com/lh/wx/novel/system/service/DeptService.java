package com.lh.wx.novel.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeptService {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据父级部门id获取相关子部门信息
	 *
	 * @param parentId
	 * @return
	 */
	public List<Map<String, Object>> getDeptBParentId(String parentId) {
		String sql = "select * from sys_dept where parentid = '"+parentId+"'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}
	
	
}
