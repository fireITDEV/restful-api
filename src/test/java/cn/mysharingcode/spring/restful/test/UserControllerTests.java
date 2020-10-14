package cn.mysharingcode.spring.restful.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void testList() throws Exception {
		// 查询用户列表
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/user"));
		// 校验结果
		resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200
		resultActions.andExpect(MockMvcResultMatchers.content().json("[\n" +
				"    {\n" +
				"        \"id\": 1,\n" +
				"        \"userName\": \"struts1\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": 2,\n" +
				"        \"userName\": \"struts2\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": 3,\n" +
				"        \"userName\": \"spring mvc\"\n" +
				"    }\n" +
				"]")); // 响应结果
		// <1> 打印结果
		resultActions.andDo(MockMvcResultHandlers.print());

		// <2> 获得 MvcResult ，后续执行各种自定义逻辑
		MvcResult mvcResult = resultActions.andReturn();
		System.out.println("拦截器数量：" + mvcResult.getInterceptors().length);
	}

	@Test
	public void testGet() throws Exception {
		// 获得指定用户编号的用户
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/user/1"));
		// 校验结果
		resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200
		resultActions.andExpect(MockMvcResultMatchers.content().json("{\n" +
				"\"id\": 1,\n" +
				"\"userName\": \"struts1\"\n" +
				"}")); // 响应结果
		// <1> 打印结果
		resultActions.andDo(MockMvcResultHandlers.print());

		// <2> 获得 MvcResult ，后续执行各种自定义逻辑
		MvcResult mvcResult = resultActions.andReturn();
		System.out.println("拦截器数量：" + mvcResult.getInterceptors().length);
	}

	@Test
	public void testAdd() throws Exception {
		// 获得指定用户编号的用户
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/user")
				.param("userName", "struts1")
				.param("id", "1"));
		// 校验结果
		resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200
		resultActions.andExpect(MockMvcResultMatchers.content().string("1")); // 响应结果
		// <1> 打印结果
		resultActions.andDo(MockMvcResultHandlers.print());

		// <2> 获得 MvcResult ，后续执行各种自定义逻辑
		MvcResult mvcResult = resultActions.andReturn();
		System.out.println("拦截器数量：" + mvcResult.getInterceptors().length);
	}

	@Test
	public void testUpdate() throws Exception {
		// 获得指定用户编号的用户
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.put("/user/1")
				.param("userName", "yudaoyuanma")
				.param("id", "3"));
		// 校验结果
		resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200
		resultActions.andExpect(MockMvcResultMatchers.content().string("true")); // 响应结果
		// <1> 打印结果
		resultActions.andDo(MockMvcResultHandlers.print());

		// <2> 获得 MvcResult ，后续执行各种自定义逻辑
		MvcResult mvcResult = resultActions.andReturn();
		System.out.println("拦截器数量：" + mvcResult.getInterceptors().length);
	}

	@Test
	public void testDelete() throws Exception {
		// 获得指定用户编号的用户
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.delete("/user/1"));
		// 校验结果
		resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200
		resultActions.andExpect(MockMvcResultMatchers.content().string("false")); // 响应结果
		// <1> 打印结果
		resultActions.andDo(MockMvcResultHandlers.print());

		// <2> 获得 MvcResult ，后续执行各种自定义逻辑
		MvcResult mvcResult = resultActions.andReturn();
		System.out.println("拦截器数量：" + mvcResult.getInterceptors().length);
	}

}
