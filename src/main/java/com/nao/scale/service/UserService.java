package com.nao.scale.service;

import com.nao.scale.pojo.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface UserService extends IService<User> {

	int insertUser(User user);

	
	
}
