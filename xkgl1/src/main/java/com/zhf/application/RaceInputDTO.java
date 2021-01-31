package com.zhf.application;

import lombok.Data;

@Data
public class RaceInputDTO {
    private Integer year;
    private String name;
    private String profession;
    private String organizer;
    private String level;
    private String category;
}
