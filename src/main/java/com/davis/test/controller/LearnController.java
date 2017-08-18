/**
 * 
 */
package com.davis.test.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.davis.test.UserVo;

/**
 * @author huangwei
 *
 */
@RestController
@RequestMapping("/learn")
public class LearnController {
	@RequestMapping("")
	public ModelAndView index(){
		List<UserVo> userList = new ArrayList<UserVo>();
		UserVo user = new UserVo();
		user.setName("张三");
		user.setSex("男");
		userList.add(user);
		ModelAndView modelView = new ModelAndView("index");
		modelView.addObject("userList",userList);
		return modelView;
	}

}
