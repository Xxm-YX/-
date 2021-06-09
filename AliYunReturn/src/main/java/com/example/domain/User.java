package com.example.domain;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String age;
}
