package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

//ST_DISTANCE
//ST-DWITHIN

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("select d.*, ST_DISTANCE(d.current_location, :pickupLocation) AS distance " +
            " from drivers AS d " +
            "where available = true and ST_WITHIN(d.current_location, :pickupLocation, 10000) " +
            "ORDER BY distance " +
            "LIMIT 10")
    // : means it will take pickup from parameter
    List<Driver> findTenNearestDrivers(Point pickupLocation);
}
