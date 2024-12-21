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

//    @Query(value = "select d.*, ST_DISTANCE(d.current_location, :pickupLocation) AS distance " +
//            " from driver AS d " +
//            "where available = true and ST_WITHIN(d.current_location, :pickupLocation, 10000) " +
//            "ORDER BY distance " +
//            "LIMIT 10", nativeQuery = true)
//    // : means it will take pickup from parameter
//    List<Driver> findTenNearestDrivers(Point pickupLocation);

    @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance " +
            "FROM drivers AS d " +
            "WHERE d.available = true " +
            "AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
            "ORDER BY distance " +
            "LIMIT 10", nativeQuery = true)
// Accepts a Point parameter
    List<Driver> findTenNearestDrivers(Point pickupLocation);

    @Query(value = "Select d.* " +
            "FROM drivers d " +
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 150000 " +
            "ORDER BY d.rating DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Driver> findTenNearbytTopRatedDrivers(Point pickupLocation);
}
