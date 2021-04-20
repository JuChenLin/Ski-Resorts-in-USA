//package com.priscilla.web.mockmvc;
//
//import com.priscilla.web.entity.skiresort.Address;
//import com.priscilla.web.entity.skiresort.MountainStat;
//import com.priscilla.web.entity.skiresort.SkiResort;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.configurationprocessor.json.JSONArray;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
//import org.springframework.stereotype.Component;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@Component
//public class JSONObjectValidation extends MockMvcValidation {
//
//    @Override
//    public void validateBodySkiResort(RequestBuilder requestBuilder, Object jsonObject) throws Exception {
//        JSONObject reqSkiResort = (JSONObject) jsonObject;
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(jsonPath("$.id").hasJsonPath())
//                .andExpect(jsonPath("$.name").value(reqSkiResort.getString("name")))
//                .andExpect(jsonPath("$.website").value(reqSkiResort.getString("website")))
//                .andExpect(jsonPath("$.priceRange").value(reqSkiResort.getString("priceRange")))
//                .andExpect(jsonPath("$.annualSnowfall").value(reqSkiResort.getInt("annualSnowfall")));
//
//        System.out.println("MockMvc Body JSONObject Ski Resort Checked");
//    }
//
//    @Override
//    public void validateBodySkiResort(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception {
//        SkiResort skiResort = (SkiResort) object;
//        JSONObject reqSkiResort = (JSONObject) jsonObject;
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(jsonPath("$.id").value(skiResort.getId()))
//                .andExpect(jsonPath("$.name").value(reqSkiResort.getString("name")))
//                .andExpect(jsonPath("$.website").value(reqSkiResort.getString("website")))
//                .andExpect(jsonPath("$.priceRange").value(reqSkiResort.getString("priceRange")))
//                .andExpect(jsonPath("$.annualSnowfall").value(reqSkiResort.getInt("annualSnowfall")));
//
//        System.out.println("MockMvc Body JSONObject Ski Resort Checked");
//    }
//
//    @Override
//    public void validateBodyMountainStat(RequestBuilder requestBuilder, Object jsonObject) throws Exception {
//        JSONObject reqSkiResort = (JSONObject) jsonObject;
//        JSONObject reqMountainStat = reqSkiResort.getJSONObject("mountainStat");
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(jsonPath("$.mountainStat.id").hasJsonPath())
//                .andExpect(jsonPath("$.mountainStat.acres").value(reqMountainStat.getInt("acres")))
//                .andExpect(jsonPath("$.mountainStat.peakElevation").value(reqMountainStat.getInt("peakElevation")))
//                .andExpect(jsonPath("$.mountainStat.baseElevation").value(reqMountainStat.getInt("baseElevation")))
//                .andExpect(jsonPath("$.mountainStat.numRuns").value(reqMountainStat.getInt("numRuns")))
//                .andExpect(jsonPath("$.mountainStat.numLifts").value(reqMountainStat.getInt("numLifts")))
//                .andExpect(jsonPath("$.mountainStat.numTerrainParks").value(reqMountainStat.getInt("numTerrainParks")))
//                .andExpect(jsonPath("$.mountainStat.pctBeginnerTerrain").value(reqMountainStat.getInt("pctBeginnerTerrain")))
//                .andExpect(jsonPath("$.mountainStat.pctIntermediateTerrain").value(reqMountainStat.getInt("pctIntermediateTerrain")))
//                .andExpect(jsonPath("$.mountainStat.pctAdvancedTerrain").value(reqMountainStat.getInt("pctAdvancedTerrain")))
//                .andExpect(jsonPath("$.mountainStat.pctExpertTerrain").value(reqMountainStat.getInt("pctExpertTerrain")));
//
//        System.out.println("MockMvc Body JSONObject Mountain Stat Checked");
//    }
//
//    @Override
//    public void validateBodyMountainStat(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception {
//        SkiResort skiResort = (SkiResort) object;
//        JSONObject reqSkiResort = (JSONObject) jsonObject;
//        JSONObject reqMountainStat = reqSkiResort.getJSONObject("mountainStat");
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(jsonPath("$.mountainStat.id").value(skiResort.getMountainStat().getId()))
//                .andExpect(jsonPath("$.mountainStat.acres").value(reqMountainStat.getInt("acres")))
//                .andExpect(jsonPath("$.mountainStat.peakElevation").value(reqMountainStat.getInt("peakElevation")))
//                .andExpect(jsonPath("$.mountainStat.baseElevation").value(reqMountainStat.getInt("baseElevation")))
//                .andExpect(jsonPath("$.mountainStat.numRuns").value(reqMountainStat.getInt("numRuns")))
//                .andExpect(jsonPath("$.mountainStat.numLifts").value(reqMountainStat.getInt("numLifts")))
//                .andExpect(jsonPath("$.mountainStat.numTerrainParks").value(reqMountainStat.getInt("numTerrainParks")))
//                .andExpect(jsonPath("$.mountainStat.pctBeginnerTerrain").value(reqMountainStat.getInt("pctBeginnerTerrain")))
//                .andExpect(jsonPath("$.mountainStat.pctIntermediateTerrain").value(reqMountainStat.getInt("pctIntermediateTerrain")))
//                .andExpect(jsonPath("$.mountainStat.pctAdvancedTerrain").value(reqMountainStat.getInt("pctAdvancedTerrain")))
//                .andExpect(jsonPath("$.mountainStat.pctExpertTerrain").value(reqMountainStat.getInt("pctExpertTerrain")));
//
//        System.out.println("MockMvc Body JSONObject Mountain Stat Checked");
//    }
//
//    @Override
//    public void validateBodyAddresses(RequestBuilder requestBuilder, Object object) throws Exception {
////        List<Address> addresses = skiResort.getAddresses();
////
////        mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
////                .andExpect(jsonPath("$.addresses", hasSize(addresses.size())));
////
////        for (int i = 0; i < addresses.size(); i++) {
////            mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
////                    .andExpect(jsonPath("$.addresses[" + i + "].id").value(addresses.get(i).getId()))
////                    .andExpect(jsonPath("$.addresses[" + i + "].name").value(addresses.get(i).getName()))
////                    .andExpect(jsonPath("$.addresses[" + i + "].street").value(addresses.get(i).getStreet()))
////                    .andExpect(jsonPath("$.addresses[" + i + "].city").value(addresses.get(i).getCity()))
////                    .andExpect(jsonPath("$.addresses[" + i + "].state").value(addresses.get(i).getState().name()))
////                    .andExpect(jsonPath("$.addresses[" + i + "].zipCode").value(addresses.get(i).getZipCode()));
////        }
////
////        System.out.println("MockMvc Body JSONObject Addresses Checked");
//    }
//
//    @Override
//    public void validateBodyAddresses(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception {
//        SkiResort skiResort = (SkiResort) object;
//        JSONObject reqSkiResort = (JSONObject) jsonObject;
//        JSONArray reqAddresses = reqSkiResort.getJSONArray("addresses");
//
//        for (int i = 0; i < reqAddresses.length(); i++) {
//            mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
//                    .andExpect(jsonPath("$.addresses[" + i + "].name").value(reqAddresses.getJSONObject(i).getString("name")))
//                    .andExpect(jsonPath("$.addresses[" + i + "].street").value(reqAddresses.getJSONObject(i).getString("street")))
//                    .andExpect(jsonPath("$.addresses[" + i + "].city").value(reqAddresses.getJSONObject(i).getString("city")))
//                    .andExpect(jsonPath("$.addresses[" + i + "].state").value(reqAddresses.getJSONObject(i).getString("state")))
//                    .andExpect(jsonPath("$.addresses[" + i + "].zipCode").value(reqAddresses.getJSONObject(i).getString("zipCode")));
//        }
//
//        System.out.println("MockMvc Body JSONObject Addresses Checked");
//    }
//}
