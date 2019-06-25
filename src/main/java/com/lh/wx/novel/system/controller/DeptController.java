package com.lh.wx.novel.system.controller;

import java.util.List;
import java.util.Map;

import com.lh.wx.novel.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	DeptService detpService;

	@GetMapping("/list/{parentid}")
	@CrossOrigin(origins="http://localhost:8080",allowCredentials="true")
	public List<Map<String,Object>> list(@PathVariable("parentid") String parentid){
		List<Map<String,Object>> list = detpService.getDeptBParentId(parentid);
		return list;
	}
	
	
}
