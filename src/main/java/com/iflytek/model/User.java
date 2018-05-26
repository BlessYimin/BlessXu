package com.iflytek.model;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "User")
public class User {
    private int id;
    private String name;
    private String password;
}
