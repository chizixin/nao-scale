package com.nao.scale.mapper;

import com.nao.scale.pojo.User;


import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface UserMapper extends BaseMapper<User> {

	

	User selectUser(Integer userID);

	int insertUser(User user);

}