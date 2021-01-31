package com.zhf.signup;

import org.springframework.data.annotation.Id;

public class student {
    @Id
    private String id;

    private String name;
    private String year;
    private String zhuanyeclass;
    private String idCard;
    private String bankno;
}
