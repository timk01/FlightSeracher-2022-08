package ru.otus.searcher.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import common_dto.SearchRequestDto;
import common_dto.SearchResultDto;
import common_dto.SearchResultDtoList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SearchControllerTest {

    @Value("${test.test}")
    private String testField;

    @Autowired
    private MockMvc mvc;

    static ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    public static void configure() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void testTicketsSearchSuccess() throws Exception {
        SearchRequestDto searchRequestDto = SearchRequestDto
                .builder()
                .origin("MOW")
                .destination("LON")
                .date(LocalDate.of(2022, 12, 12))
                .build();

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .post("/api/search")
                        .content(objectMapper.writeValueAsString(searchRequestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.searchResultDtoList").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.searchResultDtoList[*].departCity").isNotEmpty())
                .andReturn();

        String jsonString = mvcResult.getResponse().getContentAsString();

        SearchResultDtoList searchResultDtoList = objectMapper.readValue(jsonString, SearchResultDtoList.class);

        assertNotNull(searchResultDtoList);
        List<SearchResultDto> actualSearchResult = searchResultDtoList.getSearchResultDtoList();
        assertNotNull(actualSearchResult);
        assertEquals(actualSearchResult.size(), 30);

        for (int i = 0; i < actualSearchResult.size(); i++) {
            assertEquals(actualSearchResult.get(i).getDepartCity(), "MOW");
            assertTrue(actualSearchResult.get(i).getArriveCity().equals("LON"));
        }
    }

    @Test
    void testProperty() throws Exception {
        assertEquals("hello world", testField);
    }
}