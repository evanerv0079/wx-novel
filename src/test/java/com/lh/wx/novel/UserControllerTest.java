package com.lh.wx.novel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

	@Autowired
	private WebApplicationContext wac; // 注入WebApplicationContext

	@Before // 在测试开始前初始化工作
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testlogin() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/user/login").contentType(MediaType.APPLICATION_JSON)
				.param("loginName", "admin")
				.param("password","111111")
		)
				.andExpect(status().isOk())// 模拟向testRest发送get请求
				.andReturn();// 返回执行请求的结果
		System.out.println("result=="+result.getResponse().getContentAsString());
	}

	@Test
	public void testgetUserInfo() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/user/info").contentType(MediaType.APPLICATION_JSON)
				.param("token", "admin-token")
		)
				.andExpect(status().isOk())// 模拟向testRest发送get请求
				.andReturn();// 返回执行请求的结果
		System.out.println("result=="+result.getResponse().getContentAsString());
	}

	@Test
	public void testlogout() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/user/logout").contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk())// 模拟向testRest发送get请求
				.andReturn();// 返回执行请求的结果
		System.out.println("result=="+result.getResponse().getContentAsString());
	}


}
