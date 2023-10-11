package ru.rtrn;

import ru.rtrn.service.TravelService;

public class TravelRunnerTest {
    public static void main(String[] args) {

        TravelService travel = new TravelService();
        travel.generateInitialTravel();
        System.out.println(travel.toIndex());
        TravelService currentSolution = travel;
        System.out.println(currentSolution.toIndex());
        currentSolution.swapPointes();
        System.out.println(currentSolution.toIndex());
    }

}
