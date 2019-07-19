package com.art2cat.dev.maindemo.sakila.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("film")
public class Film extends Model<Film> {

    private static final long serialVersionUID = 3559158317749227170L;

    @TableId(value = "FILM_ID", type = IdType.AUTO)
    private Integer filmId;
    private String title;
    private String description;
    private LocalDate releaseYear;
    private Integer languageId;
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Integer rentalRate;
    private Integer length;
    private String rating;
    private String specialFeatures;
    private LocalDateTime lastUpdate;
}
