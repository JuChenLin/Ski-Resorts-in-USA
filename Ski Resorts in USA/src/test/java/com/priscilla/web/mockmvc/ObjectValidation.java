//package com.priscilla.web.mockmvc;
//
//import com.priscilla.web.entity.skiresort.Address;
//import com.priscilla.web.entity.skiresort.MountainStat;
//import com.priscilla.web.entity.skiresort.SkiResort;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@Component
//public class ObjectValidation extends MockMvcValidation {
//
//    @Override
//    public void validateBodySkiResort(RequestBuilder requestBuilder, Object object) throws Exception {
//        SkiResort skiResort = (SkiResort) object;
//
//        mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
//                .andExpect(jsonPath("$.id").value(skiResort.getId()))
//                .andExpect(jsonPath("$.name").value(skiResort.getName()))
//                .andExpect(jsonPath("$.website").value(skiResort.getWebsite()))
//                .andExpect(jsonPath("$.priceRange").value(skiResort.getPriceRange().name()))
//                .andExpect(jsonPath("$.annualSnowfall").value(skiResort.getAnnualSnowfall()));
//
//        System.out.println("MockMvc Body Object Ski Resort Checked");
//    }
//
//    public void validateBodySkiResort(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception {};
//
//    @Override
//    public void validateBodyMountainStat(RequestBuilder requestBuilder, Object object) throws Exception {
//        SkiResort skiResort = (SkiResort) object;
//        MountainStat mountainStat = skiResort.getMountainStat();
//
//        mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
//                .andExpect(jsonPath("$.mountainStat.id").value(mountainStat.getId()))
//                .andExpect(jsonPath("$.mountainStat.acres").value(mountainStat.getAcres()))
//                .andExpect(jsonPath("$.mountainStat.peakElevation").value(mountainStat.getPeakElevation()))
//                .andExpect(jsonPath("$.mountainStat.baseElevation").value(mountainStat.getBaseElevation()))
//                .andExpect(jsonPath("$.mountainStat.numRuns").value(mountainStat.getNumRuns()))
//                .andExpect(jsonPath("$.mountainStat.numLifts").value(mountainStat.getNumLifts()))
//                .andExpect(jsonPath("$.mountainStat.numTerrainParks").value(mountainStat.getNumTerrainParks()))
//                .andExpect(jsonPath("$.mountainStat.pctBeginnerTerrain").value(mountainStat.getPctBeginnerTerrain()))
//                .andExpect(jsonPath("$.mountainStat.pctIntermediateTerrain").value(mountainStat.getPctIntermediateTerrain()))
//                .andExpect(jsonPath("$.mountainStat.pctAdvancedTerrain").value(mountainStat.getPctAdvancedTerrain()))
//                .andExpect(jsonPath("$.mountainStat.pctExpertTerrain").value(mountainStat.getPctExpertTerrain()));
//
//        System.out.println("MockMvc Body Object Mountain Stat Checked");
//    }
//
//    public void validateBodyMountainStat(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception {};
//
//    @Override
//    public void validateBodyAddresses(RequestBuilder requestBuilder, Object object) throws Exception {
//        SkiResort skiResort = (SkiResort) object;
//        List<Address> addresses = skiResort.getAddresses();
//
//        mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
//                .andExpect(jsonPath("$.addresses", hasSize(addresses.size())));
//
//        for (int i = 0; i < addresses.size(); i++) {
//            mockMvc.perform(get("/ski-resorts/" + skiResort.getId()))
//                    .andExpect(jsonPath("$.addresses[" + i + "].id").value(addresses.get(i).getId()))
//                    .andExpect(jsonPath("$.addresses[" + i + "].name").value(addresses.get(i).getName()))
//                    .andExpect(jsonPath("$.addresses[" + i + "].street").value(addresses.get(i).getStreet()))
//                    .andExpect(jsonPath("$.addresses[" + i + "].city").value(addresses.get(i).getCity()))
//                    .andExpect(jsonPath("$.addresses[" + i + "].state").value(addresses.get(i).getState().name()))
//                    .andExpect(jsonPath("$.addresses[" + i + "].zipCode").value(addresses.get(i).getZipCode()));
//        }
//
//        System.out.println("MockMvc Body Object Body Addresses Checked");
//    }
//
//    @Override
//    public void validateBodyAddresses(RequestBuilder requestBuilder, Object object, Object jsonObject) throws Exception {};
//}
//
