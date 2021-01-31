package com.zhf.signup;


import org.springframework.data.annotation.Id;

public class Teacher {
    @Id
    private String id;

    private String name;
    private String telephone;
    private String email;
}
