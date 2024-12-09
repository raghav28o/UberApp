package com.project.uber.uberApp.services.impl;

import com.project.uber.uberApp.services.DistanceService;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dest) {
        // Call 3rd party api to OSRM to fetch distanc
        return 0;
    }
}
