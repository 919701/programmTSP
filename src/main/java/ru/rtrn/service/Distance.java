package ru.rtrn.service;

import lombok.NoArgsConstructor;
import ru.rtrn.entity.CheckPoint;

import static org.apache.lucene.util.SloppyMath.haversinMeters;

@NoArgsConstructor(staticName = "getInstance")
public class Distance {

    public double calculateDistanceInMeters(double lat1, double long1, double lat2, double long2) {
        return haversinMeters(lat1, long1, lat2, long2);
    }
    public double getDistanceInMeters(CheckPoint checkPointA, CheckPoint checkPointB) {
        return haversinMeters(checkPointA.getLatitude(), checkPointA.getLongitude(),
                checkPointB.getLatitude(), checkPointB.getLongitude());
    }
}
