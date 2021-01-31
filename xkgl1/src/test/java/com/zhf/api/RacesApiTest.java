package com.zhf.api;

import com.zhf.application.RaceInputDTO;
import com.zhf.signup.Race;
import com.zhf.setup.WebTestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RacesApiTest extends WebTestSetup {
    private static final String URL = "/competitions";

    private static final Integer year = 2021;
    private static final String name = "赛事名称";
    private static final String profession = "所属专业";
    private static final String organizer = "主办单位";
    private static final String level = "级别";
    private static final String category = "类别";


    @Test
    @DisplayName("创建新的赛事")
    void create() throws Exception {
        // given
        RaceInputDTO model = new RaceInputDTO();
        model.setYear(year);
        model.setName(name);
        model.setProfession(profession);
        model.setOrganizer(organizer);
        model.setLevel(level);
        model.setCategory(category);

        String content = mapper.writeValueAsString(model);

        // when
        ResultActions actions = mockMvc.perform(
                post(URL).content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        );

        // then 断言接口返回内容
        actions.andDo(print())
                .andExpect(status().isOk())
                // JSON Path
                .andExpect(jsonPath("$.id").isNotEmpty())
                // 对比JSON
                .andExpect(content().json(content));

        // then 断言数据库
        List<Race> entities = raceRepo.findAll();
        assertAll(
                () -> assertEquals(1, entities.size()),
                () -> {
                    Race entity = entities.get(0);
                    assertAll(
                            () -> assertEquals(year, entity.getYear()),
                            () -> assertEquals(name, entity.getName()),
                            () -> assertEquals(profession, entity.getProfession())
                            // ...
                    );
                }
        );
    }



//    // 嵌套测试
//    class CompetitionRudTests{
//
//    }
//
//    @Test
//    @DisplayName("删除现有赛事")
//    void delete() {
//
//
//    }
//
//    @Test
//    @DisplayName("根据条件查询赛事")
//    void getBy() {
//
//
//    }
//
//    @Test
//    @DisplayName("修改现有赛事")
//    void update() {
//
//
//    }
}
