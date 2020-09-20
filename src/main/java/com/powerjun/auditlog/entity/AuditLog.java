package com.powerjun.auditlog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Powerjun
 * @since 2020-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "AuditLog对象", description = "")
public class AuditLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    private String operator;

    private String operation;

    private String description;

    private String args;

    private LocalDateTime logTime;

    public AuditLog() {
    }

    private AuditLog(Builder builder) {
        logId = builder.logId;
        operator = builder.operator;
        operation = builder.operation;
        description = builder.description;
        args = builder.args;
        logTime = builder.logTime;
    }


    public static final class Builder {
        private Long logId;
        private String operator;
        private String operation;
        private String description;
        private String args;
        private LocalDateTime logTime;

        public Builder() {
        }

        public Builder withLogId(Long val) {
            logId = val;
            return this;
        }

        public Builder withOperator(String val) {
            operator = val;
            return this;
        }

        public Builder withOperation(String val) {
            operation = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withArgs(String val) {
            args = val;
            return this;
        }

        public Builder withLogTime(LocalDateTime val) {
            logTime = val;
            return this;
        }

        public AuditLog build() {
            return new AuditLog(this);
        }
    }
}
