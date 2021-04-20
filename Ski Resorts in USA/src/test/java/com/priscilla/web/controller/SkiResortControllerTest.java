package com.priscilla.web.controller;

import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.exception.DataNotExistException;
//import com.priscilla.web.mockmvc.JSONObjectValidation;
import com.priscilla.web.mockmvc.MockMvcValidation;
//import com.priscilla.web.mockmvc.ObjectValidation;
import com.priscilla.web.objectfactory.SkiResortJSONObjectFactory;
import com.priscilla.web.objectfactory.SkiResortObjectFactory;
import com.priscilla.web.repository.SkiResortRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SkiResortControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SkiResortRepository skiResortRepository;

    @Autowired
    private SkiResortObjectFactory skiResortObjectFactory;
    @Autowired
    private SkiResortJSONObjectFactory skiResortJSONObjectFactory;

    @Autowired
    private MockMvcValidation mockMvcValidation;

    private HttpHeaders httpHeaders;

    @BeforeEach
    public void init() {
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        skiResortRepository.deleteAll();
    }

    @AfterEach
    public void clear() {
        skiResortRepository.deleteAll();
    }

    @Test
    public void testCreateSkiResort() throws Exception {
        // Builder the request
        JSONObject reqSkiResort = skiResortJSONObjectFactory.createInstance01();

        // Builder the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/ski-resorts-json")
                                                              .headers(httpHeaders)
                                                              .contentType(MediaType.APPLICATION_JSON)
                                                              .content(reqSkiResort.toString());

        // MockMvc validation
        mockMvcValidation.validateCreateStatus(requestBuilder).validateBody(null, reqSkiResort);
    }

    @Test
    public void testReadSkiResort() throws Exception {
        // Add one ski resort data for reading operation
        SkiResort skiResort = skiResortObjectFactory.createInstance01();
        skiResortRepository.save(skiResort);

        // Builder the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ski-resorts-json/" + skiResort.getId()).headers(httpHeaders);

        // MockMvc validation
        mockMvcValidation.validateOkStatus(requestBuilder).validateBody(skiResort, null);
    }

    @Test
    public void testUpdateSkiResort() throws Exception {
        // Add one ski resort data for update
        SkiResort skiResort = skiResortObjectFactory.createInstance01();
        skiResortRepository.save(skiResort);

        // Builder the request
        JSONObject reqSkiResort = skiResortJSONObjectFactory.createInstance01(skiResort);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/ski-resorts-json/" + skiResort.getId())
                                                              .headers(httpHeaders)
                                                              .contentType(MediaType.APPLICATION_JSON)
                                                              .content(reqSkiResort.toString());

        // MockMvc validation
        mockMvcValidation.validateOkStatus(requestBuilder).validateBody(skiResort, reqSkiResort);
    }

    @Test
    public  void testDeleteSkiReport() throws Exception {
        // Add one ski resort data for deletion
        SkiResort skiResort = skiResortObjectFactory.createInstance01();
        skiResortRepository.save(skiResort);

        // Builder the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/ski-resorts-json/" + skiResort.getId())
                .headers(httpHeaders);

        // MockMvc validation
        mockMvcValidation.validateNoContent(requestBuilder);

        // Assert exception
        assertThrows(DataNotExistException.class, () -> {
            skiResortRepository.findById(skiResort.getId()).orElseThrow(DataNotExistException::new);
        });
    }








}
