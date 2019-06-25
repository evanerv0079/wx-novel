package com.lh.wx.novel.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据用户登录名，密码返回用户信息
	 *
	 * @param loginName
	 * @param password
	 * @return
	 */
	public Map<String, Object> getUsersByLoginNameAndPassword(String loginName,String password) {
		String sql = "select * from sys_user where login_name = '"+loginName+"' and password='"+password+"'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list.get(0);
	}

    /**
     * 根据用户的登陆名，查询当前用户的信息,以及当权用户的权限信息
     * @param loginName
     * @return
     */
	public Map<String,Object> getUsersAndRoleByLoginName(String loginName){
		String sql = "select u.user_name,GROUP_CONCAT(r.role_name) role_name ,u.introduction,u.image from sys_user u,sys_role r,sys_user_role ur  where u.id=ur.userid and r.id=ur.roleid and  u.login_name='"+loginName+"'";
		List<Map<String,Object>> list =  jdbcTemplate.queryForList(sql);
		return list.get(0);
	}
	
}
