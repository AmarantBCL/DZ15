package com.vpetelsky;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        //task1();
        System.out.println();
        task2();
    }

    private static void task1() {
        IntList list = new IntList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.set(1, 123);
        System.out.println(list); // [10, 123, 30]
        System.out.println(list.get(1));
        System.out.println(list.size());
    }

    private static void task2() {
        DomainFinder df = new DomainFinder();
        Map<String, Integer> map = df.getDomainList();
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.printf("Key: %s  Value: %d \n", item.getKey(), item.getValue());
        }
    }
}
