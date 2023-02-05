package com.example.routebustest.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReadFileDataService {

    public final Map<Integer, List<Integer>> BUS_STOPS = new HashMap<>();

    @Value("${data.path}")
    private String dataPath;

    @PostConstruct
    private void postConstruct(){
        parseBusStops();
    }

    private List<String> readAllLinesFromData() {
        try {
            return Files.readAllLines(Paths.get(dataPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Map<Integer, List<Integer>> parseBusStops() {
        List<String> lines = readAllLinesFromData();

        for (String line : lines) {
            String[] route = line.split(" ");
            Integer routeNumber = Integer.valueOf(route[0]);
            List<Integer> busStopsForRoute = new ArrayList<>();
            for (int i = 1; i < route.length; i++){
                Integer busStop = Integer.valueOf(route[i]);
                busStopsForRoute.add(busStop);
            }
            BUS_STOPS.put(routeNumber, busStopsForRoute);
        }
        return null;
    }
}
