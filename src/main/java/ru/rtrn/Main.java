package ru.rtrn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(0,1);
        list.add(list.size(), 1);
        var subList = list.subList(1, list.size() - 1);
        System.out.println(subList);
        Collections.shuffle(subList);
        System.out.println(subList);

    }
}