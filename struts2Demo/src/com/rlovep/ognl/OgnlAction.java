package com.rlovep.ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;


public class OgnlAction extends ActionSupport{
	//属性也是map根元素
	private User user = new User(29, "peace");
    private String text="peace";
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		 ActionContext ac=ActionContext.getContext();
		// 映射数据
		ac.getContextMap().put("request_data", "request_data");
		ac.getSession().put("session_data", "Session_data");
		ac.getApplication().put("application_data", "Application_data");
		//值栈对象存储
		ValueStack valueStack = ac.getValueStack();//值栈也是存储在request的域对象
		//ValueStack vs1 = (ValueStack) request.getAttribute("struts.valueStack");
		//操作根元素：压入栈顶元素,栈顶元素可以直接操作属性
		valueStack.push(new User(23,"peace2"));
		//valueStack.push("user");
		//存储一个map根元素
		valueStack.set("user1", new User(23,"peace3"));
		valueStack.set("user2", new User(23,"peace4"));
		
		// 测试迭代标签
		List<User> list = new ArrayList<User>();
		Map<Integer, User> map = new HashMap<Integer, User>();

		// 初始化
		for (int i = 1; i < 11; i++) {
			User user = new User(i, "Jack" + i);

			list.add(user);
			map.put(user.getId(), user);
		}
		// 保存
		ActionContext.getContext().getContextMap().put("list", list);
		ActionContext.getContext().getContextMap().put("map", map);
		return SUCCESS;
	}
}
