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
        TreeMap<Integer, String> map = df.getDomainList();

        for(Map.Entry<Integer, String> item : map.entrySet()){
            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
        }
//        int i = 1;
//        for (String s : map.keySet()) {
//            //System.out.println(i + ") " + s);
//            i++;
//        }

    }
}
