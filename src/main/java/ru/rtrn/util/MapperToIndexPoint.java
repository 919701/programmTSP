package ru.rtrn.util;

import lombok.NoArgsConstructor;
import ru.rtrn.entity.Point;
import ru.rtrn.service.TravelService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@NoArgsConstructor(staticName = "of")
public class MapperToIndexPoint {

    public ArrayList<Integer> toIndex(TravelService travelList) {
        var pointList = travelList.getTravel();
        var indexList = new ArrayList<Integer>();
        var pointMap = InputStreamPoints.getMap();
        for (Point point :
                pointList) {
            var index = pointMap.entrySet().stream()
                    .filter(p -> point.equals(p.getValue()))
                    .map(Map.Entry::getKey)
                    .findFirst().get();
            indexList.add(index);
        }
        return indexList;
    }
}
