package com.priscilla.web.objectfactory;

import com.priscilla.web.entity.enumerate.PriceRange;
import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.entity.skiresort.Address;
import com.priscilla.web.entity.skiresort.MountainStat;
import com.priscilla.web.entity.skiresort.SkiResort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SkiResortObjectFactory {

    public SkiResort createInstance01() {
//        String[] addresses_name = { "lodge 1", "lodge 2"};
//        String[] addresses_street = { "street 1", "street 2"};
//        String[] addresses_city = { "city 1", "city 2"};
//        State[] addresses_state = { State.CA, State.NV};
//        String[] addresses_zipCode = { "12345", "54321"};

        String addresses_name = "lodge 1";
        String addresses_street = "street 1";
        String addresses_city = "city 1";
        State addresses_state = State.CA;
        String addresses_zipCode = "12345";

        return createSkiResortObject("HY", "www.hy.com", PriceRange.HIGH, 350,
                                     3800, 6170, 9067, 98, 29, 4,
                                     8, 62, 25, 5,
                                      addresses_name, addresses_street, addresses_city, addresses_state, addresses_zipCode);
    }

    private SkiResort createSkiResortObject(String name, String website, PriceRange priceRange, Integer annualSnowfall,
                                            Integer acres, Integer baseElevation, Integer peakElevation,
                                            Integer numRuns, Integer numLifts, Integer numTerrainParks,
                                            Integer pctBeginnerTerrain, Integer pctIntermediateTerrain,
                                            Integer pctAdvancedTerrain, Integer pctExpertTerrain,
                                            String addresses_name, String addresses_street, String addresses_city,
                                            State addresses_state, String addresses_zipCode) {

        SkiResort skiResort = new SkiResort(name, website, priceRange, annualSnowfall);

        MountainStat mountainStat = createMountainStatObject(acres, baseElevation, peakElevation,
                                                             numRuns, numLifts, numTerrainParks,
                                                             pctBeginnerTerrain, pctIntermediateTerrain, pctAdvancedTerrain, pctExpertTerrain, skiResort);
        Address address = createAddressObject(addresses_name, addresses_street, addresses_city, addresses_state, addresses_zipCode, skiResort);

//        List<Address> addresses = new ArrayList<>();
//        for(int i = 0; i < addresses_name.length; i++) {
//            Address address = createAddressObject(addresses_name[i], addresses_street[i], addresses_city[i], addresses_state[i], addresses_zipCode[i], skiResort);
//            addresses.add(address);
//        }

        skiResort.setMountainStat(mountainStat);
        skiResort.setAddress(address);
//        skiResort.setAddresses(addresses);

        return skiResort;
    }

    private MountainStat createMountainStatObject(Integer acres, Integer baseElevation, Integer peakElevation,
                                                  Integer numRuns, Integer numLifts, Integer numTerrainParks,
                                                  Integer pctBeginnerTerrain, Integer pctIntermediateTerrain,
                                                  Integer pctAdvancedTerrain, Integer pctExpertTerrain, SkiResort skiResort) {

        return new MountainStat(acres, baseElevation, peakElevation, numRuns, numLifts, numTerrainParks,
                                pctBeginnerTerrain, pctIntermediateTerrain, pctAdvancedTerrain, pctExpertTerrain, skiResort);
    }

    private Address createAddressObject(String name, String street, String city, State state, String zipCode, SkiResort skiResort) {

        return new Address(name, street, city, state, zipCode, skiResort);
    }

}
