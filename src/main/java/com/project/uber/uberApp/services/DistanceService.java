package com.project.uber.uberApp.services;

import java.awt.*;
import org.locationtech.jts.geom.Point;


public interface DistanceService {
    double calculateDistance(Point src, Point dest);
}
