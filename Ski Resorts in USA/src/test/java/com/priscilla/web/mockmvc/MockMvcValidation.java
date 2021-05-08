package com.priscilla.web.mockmvc;

import com.priscilla.web.entity.skiresort.Address;
import com.priscilla.web.entity.skiresort.MountainStat;
import com.priscilla.web.entity.skiresort.SkiResort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;;

@Component
public class MockMvcValidation{
    @Autowired
    MockMvc mockMvc;

    ResultActions resultActions;

    public MockMvcValidation() {};
    public MockMvcValidation(ResultActions resultActions) {
        this.resultActions = resultActions;
    };

    public MockMvcValidation validateCreateStatus(RequestBuilder requestBuilder) throws Exception {
        ResultActions resultActions = mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isCreated())
                                             .andExpect(header().exists("Location"))
                                             .andExpect(header().string("Content-Type", "application/json"));

        return new MockMvcValidation(resultActions);
    }

    public MockMvcValidation validateOkStatus(RequestBuilder requestBuilder) throws Exception {
        ResultActions resultActions = mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());

        return new MockMvcValidation(resultActions);
    }

    public MockMvcValidation validateNoContent(RequestBuilder requestBuilder) throws  Exception {
        ResultActions resultActions = mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isNoContent());

        return new MockMvcValidation(resultActions);
    }

    public void validateBody(Object object, Object jsonObject) throws Exception {
        SkiResort skiResort = object != null? (SkiResort)object : null;
        JSONObject reqSkiResort = jsonObject != null? (JSONObject)jsonObject : null;

        if (skiResort != null) {
            MountainStat mountainStat = skiResort.getMountainStat();
//            List<Address> Addresses = skiResort.getAddresses();
            Address Address = skiResort.getAddress();

            System.out.println("Ski Resort Id = " + skiResort.getId());
            System.out.println("Ski Resort Id = " + skiResort.getId());
            this.resultActions.andExpect(jsonPath("$.id").value(skiResort.getId()))
                              .andExpect(jsonPath("$.mountainStat.id").value(mountainStat.getId()));
            this.resultActions.andExpect(jsonPath("$.address.id").value(Address.getId()));

//            for (int i = 0; i < skiResort.getAddresses().size(); i++) {
//                this.resultActions.andExpect(jsonPath("$.addresses[" + i + "].id").value(Addresses.get(i).getId()));
//            }
        } else {
            this.resultActions.andExpect(jsonPath("$.id").hasJsonPath())
                              .andExpect(jsonPath("$.mountainStat.id").hasJsonPath());

            for (int i = 0; i < reqSkiResort.getJSONArray("addresses").length(); i++) {
                this.resultActions.andExpect(jsonPath("$.addresses[" + i + "].id").hasJsonPath());
            }
        }

        if (reqSkiResort != null) {
            JSONObject reqMountainStat = reqSkiResort.getJSONObject("mountainStat");
            JSONObject reqAddress = reqSkiResort.getJSONObject("address");
//            JSONArray reqAddresses = reqSkiResort.getJSONArray("addresses");

            expectSkiResort(reqSkiResort.getString("name"), reqSkiResort.getString("website"),
                            reqSkiResort.getString("priceRange"), reqSkiResort.getInt("annualSnowfall"));

            expectMountainStat( reqMountainStat.getInt("acres"), reqMountainStat.getInt("baseElevation"),
                                reqMountainStat.getInt("peakElevation"), reqMountainStat.getInt("numRuns"),
                                reqMountainStat.getInt("numLifts"), reqMountainStat.getInt("numTerrainParks"),
                                reqMountainStat.getInt("pctBeginnerTerrain"), reqMountainStat.getInt("pctIntermediateTerrain"),
                                reqMountainStat.getInt("pctAdvancedTerrain"), reqMountainStat.getInt("pctExpertTerrain") );

            expectAddress(reqAddress.getString("name"), reqAddress.getString("street"), reqAddress.getString("city"), reqAddress.getString("state"), reqAddress.getString("zipCode"));

//            for (int i = 0; i < reqAddresses.length(); i++) {
//                JSONObject reqAddress = reqAddresses.getJSONObject(i);
//                expectAddress(i, reqAddress.getString("name"), reqAddress.getString("street"),
//                              reqAddress.getString("city"), reqAddress.getString("state"), reqAddress.getString("zipCode"));
//            }
        } else {
            MountainStat mountainStat = skiResort.getMountainStat();
//            List<Address> addresses = skiResort.getAddresses();
            Address address = skiResort.getAddress();

            expectSkiResort(skiResort.getName(), skiResort.getWebsite(), skiResort.getPriceRange().name(), skiResort.getAnnualSnowfall());

            expectMountainStat( mountainStat.getAcres(), mountainStat.getBaseElevation(), mountainStat.getPeakElevation(),
                                mountainStat.getNumRuns(), mountainStat.getNumLifts(), mountainStat.getNumTerrainParks(),
                                mountainStat.getPctBeginnerTerrain(), mountainStat.getPctIntermediateTerrain(),
                                mountainStat.getPctAdvancedTerrain(), mountainStat.getPctExpertTerrain() );
            expectAddress(address.getName(), address.getStreet(), address.getCity(), address.getState().name(), address.getZipCode());

//            for (int i = 0; i < addresses.size(); i++) {
//                Address address = addresses.get(i);
//                expectAddress(i, address.getName(), address.getStreet(), address.getCity(), address.getState().name(), address.getZipCode());
//            }
        }

        System.out.println("MockMvc Body Object Ski Resort Checked");
    };

    private void expectSkiResort(Object name, Object website, Object price, Object snowfall) throws Exception {
        this.resultActions.andExpect(jsonPath("$.name").value(name))
                          .andExpect(jsonPath("$.website").value(website))
                          .andExpect(jsonPath("$.priceRange").value(price))
                          .andExpect(jsonPath("$.annualSnowfall").value(snowfall));
    }

    private void expectMountainStat(Object acres, Object baseElevation, Object peakElevation,
                                    Object numRuns, Object numLifts, Object numTerrainParks,
                                    Object pctBeginnerTerrain, Object pctIntermediateTerrain,
                                    Object pctAdvancedTerrain, Object pctExpertTerrain) throws Exception {

        this.resultActions.andExpect(jsonPath("$.mountainStat.acres").value(acres))
                          .andExpect(jsonPath("$.mountainStat.baseElevation").value(baseElevation))
                          .andExpect(jsonPath("$.mountainStat.peakElevation").value(peakElevation))
                          .andExpect(jsonPath("$.mountainStat.numRuns").value(numRuns))
                          .andExpect(jsonPath("$.mountainStat.numLifts").value(numLifts))
                          .andExpect(jsonPath("$.mountainStat.numTerrainParks").value(numTerrainParks))
                          .andExpect(jsonPath("$.mountainStat.pctBeginnerTerrain").value(pctBeginnerTerrain))
                          .andExpect(jsonPath("$.mountainStat.pctIntermediateTerrain").value(pctIntermediateTerrain))
                          .andExpect(jsonPath("$.mountainStat.pctAdvancedTerrain").value(pctAdvancedTerrain))
                          .andExpect(jsonPath("$.mountainStat.pctExpertTerrain").value(pctExpertTerrain));
    }

    private void expectAddress(Object name, Object street, Object city, Object state, Object zipCode) throws Exception {

        this.resultActions.andExpect(jsonPath("$.addresses.name").value(name))
                .andExpect(jsonPath("$.addresses.street").value(street))
                .andExpect(jsonPath("$.addresses.city").value(city))
                .andExpect(jsonPath("$.addresses.state").value(state))
                .andExpect(jsonPath("$.addresses.zipCode").value(zipCode));
    }

//    private void expectAddress(Integer idx, Object name, Object street, Object city, Object state, Object zipCode) throws Exception {
//
//        this.resultActions.andExpect(jsonPath("$.addresses[" + idx + "].name").value(name))
//                          .andExpect(jsonPath("$.addresses[" + idx + "].street").value(street))
//                          .andExpect(jsonPath("$.addresses[" + idx + "].city").value(city))
//                          .andExpect(jsonPath("$.addresses[" + idx + "].state").value(state))
//                          .andExpect(jsonPath("$.addresses[" + idx + "].zipCode").value(zipCode));
//    }

//    public abstract void validateBodySkiResort(RequestBuilder requestBuilder, Object object) throws Exception;
//
//    public abstract void validateBodySkiResort(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception;
//
//    public abstract void validateBodyMountainStat(RequestBuilder requestBuilder, Object object) throws Exception;
//
//    public abstract void validateBodyMountainStat(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception;
//
//    public abstract void validateBodyAddresses(RequestBuilder requestBuilder, Object object) throws Exception;
//
//    public abstract void validateBodyAddresses(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception;
}
