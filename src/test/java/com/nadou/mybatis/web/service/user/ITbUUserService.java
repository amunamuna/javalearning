package com.nadou.mybatis.web.service.user;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import com.nadou.mybatis.web.model.user.TbUUser;

/**
 *
 * TbUUser 表数据服务层接口
 *
 */
public interface ITbUUserService extends IService<TbUUser> {

	/**
	 * 保存用户信息
	 * @param entity
	 * @return
	 */
	@Override
	boolean save(TbUUser entity);

	/**
	 * 查询全部用户信息
	 * @return
	 */
	List<TbUUser> getUserList();

}