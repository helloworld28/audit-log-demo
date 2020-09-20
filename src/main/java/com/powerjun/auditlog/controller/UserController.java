package com.powerjun.auditlog.controller;


import com.powerjun.auditlog.aop.MyAuditLog;
import com.powerjun.auditlog.bean.Result;
import com.powerjun.auditlog.entity.User;
import com.powerjun.auditlog.service.IUserService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Powerjun
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @MyAuditLog(operation = "用户-增加", descriptionExpression = "增加了用户[#{[0].userName}]")
    @PostMapping
    public Result add(User user) {
        boolean saved = userService.save(user);
        if (saved) {
            return new Result.Builder().withCode(200).build();
        } else {
            return new Result.Builder().withCode(500).build();
        }
    }

    @MyAuditLog(operation = "用户-删除", descriptionExpression = "删除了用户[#{[0]}]")
    @DeleteMapping("/{userId}")
    public Result delete(@PathVariable("userId") Integer userId) {
        boolean saved = userService.removeById(userId);
        if (saved) {
            return new Result.Builder().withCode(200).build();
        } else {
            return new Result.Builder().withCode(500).build();
        }
    }

    @MyAuditLog(operation = "用户-更新", descriptionExpression = "删除了用户[#{[0].toString()}]")
    @PutMapping
    public Result update(@RequestBody User user) {
        boolean saved = userService.updateById(user);
        if (saved) {
            return new Result.Builder().withCode(200).build();
        } else {
            return new Result.Builder().withCode(500).build();
        }
    }

    @GetMapping("/list")
    public Result list() {
        return new Result.Builder().withCode(200).withData(userService.list()).build();
    }

    @MyAuditLog(operation = "用户-查询", descriptionExpression = "查询用户[#{[0]}]")
    @GetMapping("/{userId}")
    public Result get(@PathVariable("userId") Integer userId) {
        User user = userService.getById(userId);
        return new Result.Builder().withCode(200).withData(user).build();
    }


}
