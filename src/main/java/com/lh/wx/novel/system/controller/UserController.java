package com.lh.wx.novel.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	public com.lh.wx.novel.system.service.UserService UserService;
	
	@RequestMapping("/login")
    @ResponseBody
    @CrossOrigin(origins="http://localhost:8080",allowCredentials="true")
    public String login(HttpServletRequest request) {
		String loginName = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, Object> map = UserService.getUsersByLoginNameAndPassword(loginName, password);

		Map<String,Object> token  = new HashMap<String,Object>();
		if(!map.isEmpty() && !StringUtils.isEmpty(map.get("login_name"))) {
			token.put("token", map.get("login_name")+"-token");
		}
		
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("code", "20000");
		res.put("data",token);
		String resjson = new Gson().toJson(res);
		return resjson;
    }
	
	@RequestMapping("/info")
	@ResponseBody
	@CrossOrigin(origins="http://localhost:8080",allowCredentials="true")
	public String getUserInfo(HttpServletRequest request) {
		String token   = request.getParameter("token");
		String resjson = "";
		if(!StringUtils.isEmpty(token)) {
			String loginName = token.substring(0,token.indexOf("-"));
			Map<String,Object> map = UserService.getUsersAndRoleByLoginName(loginName);
			Map<String,Object> message = new HashMap<String,Object>();
			message.put("roles",map.get("role_name"));
			message.put("instroduction", map.get("introduction"));
			message.put("avatar",map.get("image"));
			message.put("name",map.get("user_name"));
			Map<String,Object> res = new HashMap<String,Object>();
			res.put("code",20000);
			res.put("data",message);
			resjson = new Gson().toJson(res);
		}
		return resjson;
	}
	
	
	@RequestMapping("/logout")
	@ResponseBody
	@CrossOrigin(origins="http://localhost:8080",allowCredentials="true")
	public String logout(HttpServletRequest request) {
		String resjson ="";
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("code","20000");
		res.put("data","success");
		resjson = new Gson().toJson(res);
		return resjson;
	}
}
