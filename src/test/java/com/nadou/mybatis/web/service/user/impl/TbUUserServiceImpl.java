package com.nadou.mybatis.web.service.user.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.nadou.mybatis.web.mapper.user.TbUUserMapper;
import com.nadou.mybatis.web.model.user.TbUUser;
import com.nadou.mybatis.web.service.user.ITbUUserService;

/**
 *
 * TbUUser 表数据服务层接口实现类
 *
 */
@Service
public class TbUUserServiceImpl extends ServiceImpl<TbUUserMapper, TbUUser> implements ITbUUserService {

	static Logger logger = LoggerFactory.getLogger(TbUUserServiceImpl.class);
	@Override
	public boolean save(TbUUser entity) {
		return super.save(entity);
	}

	@Override
	public List<TbUUser> getUserList() {
		return baseMapper.selectList(Wrappers.<TbUUser>lambdaQuery());
	}

}