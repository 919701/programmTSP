package ru.rtrn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelInfo {

    private int pointFrom;
    private int pointTo;
    private double distance;

}
