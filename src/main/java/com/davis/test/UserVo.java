/**
 * 
 */
package com.davis.test;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author huangwei
 *
 */
@ConfigurationProperties(prefix="com.davis.test")
public class UserVo {
	
	private String name;
	
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
