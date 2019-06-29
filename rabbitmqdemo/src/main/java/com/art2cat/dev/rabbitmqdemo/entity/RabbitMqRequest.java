package com.art2cat.dev.rabbitmqdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;

@Data
public class RabbitMqRequest implements Serializable {

    private static final long serialVersionUID = -7585826694024446402L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private String fromClassName;

    private String toClassName;

    private String methodName;

    private String params;

}
