package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("")
    List<Driver> findMatchingDrivers(Point pickupLocation);
}
