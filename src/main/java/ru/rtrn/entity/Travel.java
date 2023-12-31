package ru.rtrn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {

    private List<Point> pointTravel;
    private List<Integer> indexTravel;
    private double distance;

}
