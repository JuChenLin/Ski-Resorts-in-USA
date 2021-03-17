package com.priscilla.web.controller;

import com.priscilla.web.entity.skiresort.Address;
import com.priscilla.web.entity.skiresort.MountainStat;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.mockmvc.MockMvcValidation;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Content-Type", "application/json"));
    }

    @Test
    public void testReadSkiResort() throws Exception {
        SkiResort skiResort = skiResortObjectFactory.createInstance01();
        skiResortRepository.save(skiResort);
        MountainStat mountainStat = skiResort.getMountainStat();
        List<Address> addresses = skiResort.getAddresses();

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ski-resorts/" + skiResort.getId()).headers(httpHeaders);

        mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
                .andExpect(jsonPath("$.id").hasJsonPath())
                .andExpect(jsonPath("$.name").value(skiResort.getName()))
                .andExpect(jsonPath("$.website").value(skiResort.getWebsite()))
                .andExpect(jsonPath("$.priceRange").value(skiResort.getPriceRange().name()))
                .andExpect(jsonPath("$.annualSnowfall").value(skiResort.getAnnualSnowfall()))
                .andExpect(jsonPath("$.mountainStat.id").hasJsonPath())
                .andExpect(jsonPath("$.mountainStat.acres").value(mountainStat.getAcres()))
                .andExpect(jsonPath("$.mountainStat.peakElevation").value(mountainStat.getPeakElevation()))
                .andExpect(jsonPath("$.mountainStat.baseElevation").value(mountainStat.getBaseElevation()))
                .andExpect(jsonPath("$.mountainStat.numRuns").value(mountainStat.getNumRuns()))
                .andExpect(jsonPath("$.mountainStat.numLifts").value(mountainStat.getNumLifts()))
                .andExpect(jsonPath("$.mountainStat.numTerrainParks").value(mountainStat.getNumTerrainParks()))
                .andExpect(jsonPath("$.mountainStat.pctBeginnerTerrain").value(mountainStat.getPctBeginnerTerrain()))
                .andExpect(jsonPath("$.mountainStat.pctIntermediateTerrain").value(mountainStat.getPctIntermediateTerrain()))
                .andExpect(jsonPath("$.mountainStat.pctAdvancedTerrain").value(mountainStat.getPctAdvancedTerrain()))
                .andExpect(jsonPath("$.mountainStat.pctExpertTerrain").value(mountainStat.getPctExpertTerrain()))
                .andExpect(jsonPath("$.addresses", hasSize(addresses.size())));

        for (int i = 0; i < addresses.size(); i++) {
            mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
                    .andExpect(jsonPath("$.addresses[" + i + "].name").value(addresses.get(i).getName()))
                    .andExpect(jsonPath("$.addresses[" + i + "].street").value(addresses.get(i).getStreet()))
                    .andExpect(jsonPath("$.addresses[" + i + "].city").value(addresses.get(i).getCity()))
                    .andExpect(jsonPath("$.addresses[" + i + "].state").value(addresses.get(i).getState().name()))
                    .andExpect(jsonPath("$.addresses[" + i + "].zipCode").value(addresses.get(i).getZipCode()));
        }
    }

    @Test
    public void testUpdateSkiResort() throws Exception {
        SkiResort skiResort = skiResortObjectFactory.createInstance01();
        skiResortRepository.save(skiResort);

        JSONObject request = skiResortJSONObjectFactory.createInstance01(skiResort);

        JSONObject mountainStat = request.getJSONObject("mountainStat");
        JSONArray addresses = request.getJSONArray("addresses");


        mockMvc.perform(put("/ski-resorts/" + skiResort.getId()).headers(httpHeaders).content(request.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(skiResort.getId()))
                .andExpect(jsonPath("$.name").value(request.getString("name")))
                .andExpect(jsonPath("$.website").value(request.getString("website")))
                .andExpect(jsonPath("$.priceRange").value(request.getString("priceRange")))
                .andExpect(jsonPath("$.annualSnowfall").value(request.getInt("annualSnowfall")))
                .andExpect(jsonPath("$.mountainStat.id").value(skiResort.getMountainStat().getId()))
                .andExpect(jsonPath("$.mountainStat.acres").value(mountainStat.getInt("acres")))
                .andExpect(jsonPath("$.mountainStat.peakElevation").value(mountainStat.getInt("peakElevation")))
                .andExpect(jsonPath("$.mountainStat.baseElevation").value(mountainStat.getInt("baseElevation")))
                .andExpect(jsonPath("$.mountainStat.numRuns").value(mountainStat.getInt("numRuns")))
                .andExpect(jsonPath("$.mountainStat.numLifts").value(mountainStat.getInt("numLifts")))
                .andExpect(jsonPath("$.mountainStat.numTerrainParks").value(mountainStat.getInt("numTerrainParks")))
                .andExpect(jsonPath("$.mountainStat.pctBeginnerTerrain").value(mountainStat.getInt("pctBeginnerTerrain")))
                .andExpect(jsonPath("$.mountainStat.pctIntermediateTerrain").value(mountainStat.getInt("pctIntermediateTerrain")))
                .andExpect(jsonPath("$.mountainStat.pctAdvancedTerrain").value(mountainStat.getInt("pctAdvancedTerrain")))
                .andExpect(jsonPath("$.mountainStat.pctExpertTerrain").value(mountainStat.getInt("pctExpertTerrain")));

        for (int i = 0; i < addresses.length(); i++) {
            mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
                    .andExpect(jsonPath("$.addresses[" + i + "].name").value(addresses.getJSONObject(i).getString("name")))
                    .andExpect(jsonPath("$.addresses[" + i + "].street").value(addresses.getJSONObject(i).getString("street")))
                    .andExpect(jsonPath("$.addresses[" + i + "].city").value(addresses.getJSONObject(i).getString("city")))
                    .andExpect(jsonPath("$.addresses[" + i + "].state").value(addresses.getJSONObject(i).getString("state")))
                    .andExpect(jsonPath("$.addresses[" + i + "].zipCode").value(addresses.getJSONObject(i).getString("zipCode")));
        }
    }








}
