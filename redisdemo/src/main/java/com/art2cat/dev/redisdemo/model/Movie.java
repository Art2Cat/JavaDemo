package com.art2cat.dev.redisdemo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * com.art2cat.dev.redisdemo.model
 *
 * @author rorschach
 * @date 7/4/18
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Movie {
    
    @Getter
    @Setter
    private String id;
    
    @Getter
    @Setter
    private String name;
}
