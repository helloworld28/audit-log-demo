package com.powerjun.auditlog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powerjun.auditlog.bean.PageAdapter;
import com.powerjun.auditlog.entity.AuditLog;
import com.powerjun.auditlog.service.IAuditLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Powerjun
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/auditLog")
public class AuditLogController {

    private IAuditLogService auditLogService;

    public AuditLogController(IAuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping
    public PageAdapter list(int offset, int limit) {
        Page<AuditLog> auditLogPage = new Page<>();
        auditLogPage.setSize(limit);
        auditLogPage.setCurrent((offset / limit) + 1);
        auditLogPage.setSearchCount(true);


        return new PageAdapter(auditLogService.page(auditLogPage, new QueryWrapper<>()));
    }
}
