package com.zhf.signup;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Race {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid",strategy = "uuid")
    private String id;

    private Integer year;
    private String name;
    private String profession;
    private String organizer;
    private String level;
    private String category;
}
