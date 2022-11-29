package ru.otus.searcher.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dto.CountryDto;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;
import ru.otus.searcher.applicationRunner.StaticDataListner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@MockBeans(@MockBean(StaticDataListner.class))
class CountrySearchControllerTest {

    private final static String URI = "https://api.travelpayouts.com/aviasales_resources/v3/countries.json";

    @Autowired
    private MockMvc mvc;

    @MockBean
//    @Mock
    RestTemplate restTemplate;

    static ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void configure() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void testCountrySearchSuccess() throws Exception {
        CountryDto countryDto = new CountryDto();
        countryDto.setCode("BM").setName("Bermuda").setCurrency("BMD");
        CountryDto[] expectedCountryDtos = new CountryDto[]
                {
                        countryDto
                };

        when(restTemplate.getForEntity(URI, CountryDto[].class))
                .thenReturn(new ResponseEntity(expectedCountryDtos, HttpStatus.OK));

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/api/countries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

        String jsonString = mvcResult.getResponse().getContentAsString();

        CountryDto[] realCountryDtos = objectMapper.readValue(jsonString, CountryDto[].class);

        assertNotNull(realCountryDtos);

        assertEquals(expectedCountryDtos.length, realCountryDtos.length);
        //assertEquals(251, realCountryDtos.length);

        assertEquals(expectedCountryDtos[0].getCode(), realCountryDtos[0].getCode());
        assertEquals(expectedCountryDtos[0].getCurrency(), realCountryDtos[0].getCurrency());
        assertEquals(expectedCountryDtos[0].getName(), realCountryDtos[0].getName());

        verify(restTemplate, times(1)).getForEntity(URI, CountryDto[].class);
        //verify(restTemplate, times(0)).getForEntity(URI, CountryDto[].class);
    }
}