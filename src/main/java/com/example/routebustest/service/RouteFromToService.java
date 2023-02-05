package com.example.routebustest.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RouteFromToService {

    private final ReadFileDataService readFileData;

    public RouteFromToService(ReadFileDataService readFileData) {
        this.readFileData = readFileData;
    }

    public boolean availableRoute(Integer from, Integer to) {
        Map<Integer, List<Integer>> buStops = readFileData.BUS_STOPS;

        for (Map.Entry<Integer, List<Integer>> busStop : buStops.entrySet()){
            List<Integer> value = busStop.getValue();
            for (int i = 0; i < value.size(); i++){
                if (value.get(i).equals(from)){
                    for (int n = i; n < value.size(); n++){
                        if (value.get(n).equals(to)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
