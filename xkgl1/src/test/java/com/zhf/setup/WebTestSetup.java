package com.zhf.setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhf.XkglApplicationTests;
import com.zhf.signup.repository.RaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AutoConfigureMockMvc
public class WebTestSetup extends XkglApplicationTests {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper mapper;

    @Autowired
    protected RaceRepo raceRepo;
}
