package com.example.domain;

import com.example.anno.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("t_jpa_user")
public class User {

    private String name;
    private Integer age;
}
