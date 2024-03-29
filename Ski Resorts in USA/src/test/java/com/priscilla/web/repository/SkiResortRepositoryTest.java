package com.priscilla.web.repository;

import com.priscilla.web.entity.skiresort.SkiResort;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SkiResortRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateSkiResort() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        JSONObject request = new JSONObject();
        request.put("name", "Ski Resort 01");
        request.put("website", "www.skiresort01.com");
        request.put("priceRange", "LOW");
        request.put("annualSnowfall", 130);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/ski-resorts")
                                                              .headers(httpHeaders)
                                                              .content(request.toString());

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").hasJsonPath())
                .andExpect(jsonPath("$.name").value(request.getString("name")))
                .andExpect(jsonPath("$.website").value(request.getString("website")))
                .andExpect(jsonPath("$.priceRange").value(request.getString("priceRange")))
                .andExpect(jsonPath("$.annualSnowfall").value(request.getInt("annualSnowfall")))
//                .andExpect(header().exists("Location"))
                .andExpect(header().string("Content-Type", "application/json"));
    }

//    @Autowired
//    SkiResort skiResort;
//    @Autowired
//    SkiResortRepository skiResortRepository;
//
//
//    @Test
//    public void getSkiResort() {
//        Optional<SkiResort> optionalSkiResort = skiResortRepository.findById(000001);
//    }


}
