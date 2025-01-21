package com.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Double rating;
    private Boolean available;
    private String vehicleId;

    //Geometry: This is a data type that allows storage of spatial data (like points, lines, and polygons) in a single column.
    //Point: Indicates that the geometry is specifically a point, which represents a single location in space defined by coordinates (latitude and longitude).
    //4326: This is the Spatial Reference System Identifier (SRID) that specifies the coordinate system for the spatial data. SRID 4326 refers to the WGS 84 coordinate system, which is the standard used by GPS and is a commonly used format for geographical data.
    @Column(columnDefinition = "Geometry(Point,4326)")
    Point currentLocation;
    //This is a field in your Driver class that will hold the current location of the driver.

}
