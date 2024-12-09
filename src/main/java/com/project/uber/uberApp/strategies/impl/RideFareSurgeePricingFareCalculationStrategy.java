package com.project.uber.uberApp.strategies.impl;

import com.project.uber.uberApp.dto.RideRequestDto;
import com.project.uber.uberApp.entities.RideRequest;
import com.project.uber.uberApp.strategies.RideFareCalculationStrategy;

public class RideFareSurgeePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
