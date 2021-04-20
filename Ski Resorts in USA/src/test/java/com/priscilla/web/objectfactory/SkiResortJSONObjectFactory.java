package com.priscilla.web.objectfactory;

import com.priscilla.web.entity.skiresort.SkiResort;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class SkiResortJSONObjectFactory {

    public JSONObject createInstance01() throws JSONException {
        String[] addresses_name = { "lodge 1", "lodge 2"};
        String[] addresses_street = { "street 1", "street 2"};
        String[] addresses_city = { "city 1", "city 2"};
        String[] addresses_state = { "CA", "NV"};
        String[] addresses_zipCode = { "12345", "54321"};

        return createSkiResortJSONObject(null, "Ski Resort Json Object 01", "www.skiresort01.com", "HIGH", 360,
                                         3500, 7953,11053, 150, 25,9,
                                         15, 48, 24, 13,
                                          addresses_name, addresses_street, addresses_city, addresses_state, addresses_zipCode);
    }

    public JSONObject createInstance01(SkiResort skiResort) throws JSONException {
        String[] addresses_name = { "lodge 1", "lodge 2"};
        String[] addresses_street = { "street 1", "street 2"};
        String[] addresses_city = { "city 1", "city 2"};
        String[] addresses_state = { "CA", "NV"};
        String[] addresses_zipCode = { "12345", "54321"};

        return createSkiResortJSONObject(skiResort, "Ski Resort Json Object 01", "www.skiresort01.com", "HIGH", 360,
                                        3500, 7953,11053, 150, 25,9,
                                        15, 48, 24, 13,
                                         addresses_name, addresses_street, addresses_city, addresses_state, addresses_zipCode);
    }

    private JSONObject createSkiResortJSONObject (SkiResort skiResort, String name, String website, String priceRange, Integer annualSnowfall,
                                                 Integer acres, Integer baseElevation, Integer peakElevation,
                                                 Integer numRuns, Integer numLifts, Integer numTerrainParks,
                                                 Integer pctBeginnerTerrain, Integer pctIntermediateTerrain,
                                                 Integer pctAdvancedTerrain, Integer pctExpertTerrain,
                                                 String[] addresses_name, String[] addresses_street, String[] addresses_city,
                                                 String[] addresses_state, String[] addresses_zipCode) throws JSONException {

        Integer mountainStatID = skiResort != null ? skiResort.getMountainStat().getId() : null;
        JSONObject mountainStat = createMountainStatJSONObject( mountainStatID, acres, baseElevation, peakElevation,
                                                                numRuns, numLifts, numTerrainParks,
                                                                pctBeginnerTerrain, pctIntermediateTerrain, pctAdvancedTerrain, pctExpertTerrain);


        JSONArray addresses = new JSONArray();
        for (int i = 0; i < addresses_name.length; i++) {
            Integer addressID =  skiResort != null ? skiResort.getAddresses().get(i).getId() : null;
            JSONObject address = createAddressJSONObject(addressID, addresses_name[i],
                                                         addresses_street[i], addresses_city[i], addresses_state[i], addresses_zipCode[i]);
            addresses.put(address);
        }

        JSONObject ski_resort = new JSONObject();
        ski_resort.put("name", name);
        ski_resort.put("website", website);
        ski_resort.put("priceRange", priceRange);
        ski_resort.put("annualSnowfall", annualSnowfall);
        ski_resort.put("mountainStat", mountainStat);
        ski_resort.put("addresses", addresses);

        return ski_resort;
    }

    private JSONObject createMountainStatJSONObject(Integer id, Integer acres, Integer baseElevation, Integer peakElevation,
                                                    Integer numRuns, Integer numLifts, Integer numTerrainParks,
                                                    Integer pctBeginnerTerrain, Integer pctIntermediateTerrain,
                                                    Integer pctAdvancedTerrain, Integer pctExpertTerrain) throws JSONException {
        JSONObject mountainStat = new JSONObject();

        if (id != null) mountainStat.put("id", id);
        mountainStat.put("acres", acres);
        mountainStat.put("baseElevation", baseElevation);
        mountainStat.put("peakElevation", peakElevation);
        mountainStat.put("numRuns", numRuns);
        mountainStat.put("numLifts", numLifts);
        mountainStat.put("numTerrainParks", numTerrainParks);
        mountainStat.put("pctBeginnerTerrain", pctBeginnerTerrain);
        mountainStat.put("pctIntermediateTerrain", pctIntermediateTerrain);
        mountainStat.put("pctAdvancedTerrain", pctAdvancedTerrain);
        mountainStat.put("pctExpertTerrain", pctExpertTerrain);

        return  mountainStat;
    }

    private JSONObject createAddressJSONObject(Integer id, String name, String street, String city, String state, String zipCode) throws JSONException {
        JSONObject address = new JSONObject();

        if (id != null) address.put("id", id);
        address.put("name", name);
        address.put("street", street);
        address.put("city", city);
        address.put("state", state);
        address.put("zipCode", zipCode);

        return address;
    }
}
