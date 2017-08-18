/**
 * 
 */
package com.davis.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davis.test.UserVo;

/**
 * @author huangwei
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserVo userVo;

	@Value("${com.davis.test.name}")
	private String name;
	
	@Value("${com.davis.test.sex}")
	private String sex;
	
	@RequestMapping
	public String greeting(){
		return userVo.getName()+":"+userVo.getSex();
	}
	
	@RequestMapping("/index")
	public String index(){
		return "Index Page!";
	}
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name){
		return "hello "+name;
	}
}
