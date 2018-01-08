package com.imooc.controller;

import java.util.List;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.imooc.dto.Front;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.imooc.dto.User;
import com.imooc.mapper.UserMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getAll")
	public List<User> getAll() {
		List<User> user=userMapper.getAll();
		return user;
	}


	@RequestMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") int id) {
		User user = userMapper.getOne(id);
		return user;
	}

	@RequestMapping(value = "/insertUser")
	public void insertUser(User user) {
		userMapper.insert(user);
	}

	@RequestMapping(value = "/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userMapper.delete(id);
	}


	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String index(//@RequestBody @Validated Front front,
			HttpServletRequest request,HttpServletResponse response ) {
		response.setHeader("Access-Control-Allow-Origin", "*");
//		System.out.print(front.toString());
		String c=request.getParameter("username");
		System.out.print(c);
		return c;
	}

	@RequestMapping("/hi")
	public User hi(//HttpServletRequest request, HttpServletResponse response
	                 //@RequestParam("r_userName")String b ,
					 HttpServletRequest request,HttpServletResponse response
					 ){
		String c=request.getParameter("r_userName");

		response.setHeader("Access-Control-Allow-Origin", "*");
		//System.out.println(b);
		User user = userMapper.getOne(1);
		user.setStatus(1);
		return user;
	}

	@RequestMapping(value = "/hello1", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public @ResponseBody Front index1(@RequestBody Front front , HttpServletResponse response) {
		String a=front.toString();
		System.out.println(a);
		response.setHeader("Access-Control-Allow-Origin", "*");
		return front;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(HttpServletRequest request,HttpServletResponse response){
		//0123 注册：0用户已经存在  1成功
		//     登录：2用户名不存在 3密码错误
		response.setHeader("Access-Control-Allow-Origin", "*");

		HttpSession session=request.getSession();

		String status="10";
		User user=new User();
		String act=request.getParameter("action");
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		user.setUsername(u);
		user.setPassword(p);
		System.out.println(u);
		System.out.println(p);
		System.out.println(act);
		User user1=userMapper.getUserbyName(u);
		if(act.equals("register")&&user1==null){
			userMapper.insert(user);
			status= "1";
		}if(act.equals("register")&&user1!=null) {
			status = "0";
		}if(act.equals("login")&&user1==null) {
			status = "2";
		}if(act.equals("login")&&user1!=null&&user.getPassword().equals(user1.getPassword())){
			status="1";
		}if(act.equals("login")&&user1!=null&&!user.getPassword().equals(user1.getPassword())){
			status="3";
		}

		session.setAttribute("test",user);
		session.setAttribute("test",user);
		return session.getAttribute("test");
	}

}