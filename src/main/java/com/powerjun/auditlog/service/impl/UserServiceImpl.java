package com.powerjun.auditlog.service.impl;

import com.powerjun.auditlog.entity.User;
import com.powerjun.auditlog.mapper.UserMapper;
import com.powerjun.auditlog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Powerjun
 * @since 2020-09-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
