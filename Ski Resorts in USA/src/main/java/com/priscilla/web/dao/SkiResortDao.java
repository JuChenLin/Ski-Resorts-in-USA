package com.priscilla.web.dao;

import com.priscilla.web.entities.skiresorts.PriceRange;
import com.priscilla.web.entities.skiresorts.SkiResort;
import com.priscilla.web.entities.skiresorts.State;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SkiResortDao {

    private static Map<String, SkiResort> skiResorts = new HashMap<String, SkiResort>();
    private static Integer defaultIdNum = 1;

    static{
        skiResorts.put("CA00001", new SkiResort("CA00001","Mammoth Mountain", "https://www.mammothmountain.com/", State.parse("CA"), PriceRange.HIGH));
        skiResorts.put("CA00002", new SkiResort("CA00002","Heavenly", "https://www.skiheavenly.com/", State.parse("CA"), PriceRange.HIGH));

    }


    // Get all resorts
    public Collection<SkiResort> getAll(){
        return skiResorts.values();
    }

    // Get a resort by ID
    public SkiResort get(String id){
        return skiResorts.get(id);
    }

    // Add/Save a resort
    public void save(SkiResort skiResort){
//        System.out.println("ID type:" + skiResort.getId().getClass());

        if(skiResort.getId()==null){
            System.out.println("ID == null, create ID");
            String state = skiResort.getAddress().getState().toString();
            skiResort.setId(state + String.format("%05d", defaultIdNum++));
        }

        skiResorts.put(skiResort.getId(), skiResort);
    }

    // Delete a member
    public void delete(String id){
        skiResorts.remove(id);
    }

}
