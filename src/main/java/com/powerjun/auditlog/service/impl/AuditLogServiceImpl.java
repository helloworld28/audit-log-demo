package com.powerjun.auditlog.service.impl;

import com.powerjun.auditlog.entity.AuditLog;
import com.powerjun.auditlog.mapper.AuditLogMapper;
import com.powerjun.auditlog.service.IAuditLogService;
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
public class AuditLogServiceImpl extends ServiceImpl<AuditLogMapper, AuditLog> implements IAuditLogService {

}
