package ru.rtrn.service;

import lombok.NoArgsConstructor;
import ru.rtrn.entity.Point;

import static org.apache.lucene.util.SloppyMath.haversinMeters;

@NoArgsConstructor(staticName = "getInstance")
public class Distance {
    public double getDistanceInMeters(Point pointA,Point pointB) {
        return haversinMeters(pointA.getLatitude(), pointA.getLongitude(),
                pointB.getLatitude(), pointB.getLatitude());
    }
}
