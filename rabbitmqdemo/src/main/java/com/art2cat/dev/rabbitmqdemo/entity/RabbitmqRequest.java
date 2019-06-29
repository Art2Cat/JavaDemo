package com.art2cat.dev.rabbitmqdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
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

    private Date createDate;
}
