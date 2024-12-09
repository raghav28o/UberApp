package com.project.uber.uberApp.services.impl;

import com.project.uber.uberApp.dto.DriverDto;
import com.project.uber.uberApp.dto.RiderDto;
import com.project.uber.uberApp.services.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Override
    public RiderDto acceptRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto startRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        return null;
    }

    @Override
    public List<RiderDto> getAllRides() {
        return null;
    }
}
