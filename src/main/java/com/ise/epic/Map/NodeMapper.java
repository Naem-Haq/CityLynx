package com.ise.epic.Map;

import com.ise.epic.DataStructures.HashMapImplementation;
import java.util.Map;

public class NodeMapper {
    private final Map<String, String> locationToMapLetter;

    public NodeMapper() {
        locationToMapLetter = new HashMapImplementation<>();
        // Add mappings for each location
        locationToMapLetter.put("University of Limerick", "U");
        locationToMapLetter.put("Plassey", "P");
        locationToMapLetter.put("Cappavilla", "C");
        locationToMapLetter.put("Groody", "G");
        locationToMapLetter.put("Dromroe", "D");
        locationToMapLetter.put("City Centre", "L");
        locationToMapLetter.put("Crescent", "S");
        locationToMapLetter.put("ICON", "I");
        locationToMapLetter.put("Arthur's Quay", "Q");
        locationToMapLetter.put("Train Station", "T");
        locationToMapLetter.put("Hurlers Bar", "H");
    }

    public String getMapLetter(String location) {
        return locationToMapLetter.get(location);
    }
}
