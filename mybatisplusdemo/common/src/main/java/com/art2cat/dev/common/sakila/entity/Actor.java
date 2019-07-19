package com.art2cat.dev.common.sakila.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("actor")
public class Actor extends Model<Actor> {

    private static final long serialVersionUID = 3559158317749227170L;

    @TableId(value = "ACTOR_ID", type = IdType.AUTO)
    private Integer actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
}
