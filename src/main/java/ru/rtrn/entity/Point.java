package ru.rtrn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rtrn.service.DistanceService;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {

    private Double latitude;
    private Double longitude;

    public Double distanceToPoint(Point point) {
        return DistanceService.getInMeters(latitude, longitude, point.getLatitude(), point.getLongitude());
    }
}
