package com.syz.service;

import java.util.List;

import com.syz.service.msg.User;

/**
 * 登陆
 * 
 * @author yunsyz
 *
 */
public interface LoginService {
	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	List<User> queryUserList(User user);
}
