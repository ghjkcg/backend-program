package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /test 요청 시 Hello World 반환")
    void getTestAPI() throws Exception {
        // Given: (없음)

        // When & Then
        mockMvc.perform(get("/test"))
                .andExpect(status().isOk())                  // HTTP 200 확인
                .andExpect(content().string("Hello World"))  // 본문 내용 확인
                .andDo(print());                             // 로그 출력
    }

    @Test
    @DisplayName("없는 경로로 요청하면 404")
    void notFound() throws Exception {
        mockMvc.perform(get("/none"))
                .andExpect(status().isNotFound());
    }
}