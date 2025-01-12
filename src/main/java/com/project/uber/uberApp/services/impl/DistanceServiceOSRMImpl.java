package com.project.uber.uberApp.services.impl;

import com.project.uber.uberApp.services.DistanceService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.awt.*;
import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private final String OSRM_API_BASE_URL = "http://router.project-osrm.org/route/v1/driving/13.388860,52.517037;13.397634,52.529407";
    @Override
    public double calculateDistance(Point src, Point dest) {
        // Call 3rd party api to OSRM to fetch distance
        OSRMResponseDto responseDto =  RestClient.builder()
                .baseUrl(OSRM_API_BASE_URL)
                .build()
                .get()
                .uri("{},{};{},{}", src.getX(),src.getY(), dest.getX(), dest.getY())
                .retrieve()
                .body(OSRMResponseDto.class);
        return 0;
    }
}

@Data
class OSRMResponseDto {
    private List<OSRMRoute> routes;
}


class OSRMRoute {
    private Double distance;
}