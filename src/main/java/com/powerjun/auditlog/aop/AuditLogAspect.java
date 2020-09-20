package com.powerjun.auditlog.aop;


import com.powerjun.auditlog.entity.AuditLog;
import com.powerjun.auditlog.service.IAuditLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class AuditLogAspect {
    private Logger logger = LoggerFactory.getLogger(AuditLogAspect.class);

    private IAuditLogService auditLogService;

    public AuditLogAspect(IAuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @Around("@annotation(MyAuditLog)")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        try {
            saveAuditLog(point);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return point.proceed();
    }

    private void saveAuditLog(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        MyAuditLog myAuditLog = ((MethodSignature) point.getSignature()).getMethod().getAnnotation(MyAuditLog.class);
        String operation = myAuditLog.operation();
        String descriptionExpression = myAuditLog.descriptionExpression();
        String description = parseDescriptionExpression(args, descriptionExpression);

        AuditLog auditLog = new AuditLog.Builder()
                .withOperator("test")
                .withOperation(operation)
                .withDescription(description)
                .withArgs(Arrays.toString(args))
                .withLogTime(LocalDateTime.now())
                .build();

        auditLogService.save(auditLog);
    }

    private String parseDescriptionExpression(Object[] args, String descriptionExpression) {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression = spelExpressionParser.parseExpression(descriptionExpression, new TemplateParserContext());
        return expression.getValue(new StandardEvaluationContext(args), String.class);
    }


}
