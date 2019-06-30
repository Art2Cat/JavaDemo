package com.art2cat.dev.rabbitmqdemo.entity;

import com.art2cat.dev.rabbitmqdemo.serializer.LocalDateTimeDeserializer;
import com.art2cat.dev.rabbitmqdemo.serializer.LocalDateTimeSerializer;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RabbitmqRequest implements Serializable {

    private static final long serialVersionUID = -7585826694024446402L;

    @TableId(value = "RABBITMQ_ID", type = IdType.UUID)
    private String rabbitmqId;

    private String rabbitmqType;

    private Object rabbitmqContext;

    private String rabbitmqRemark;

    private Integer delFlag;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
