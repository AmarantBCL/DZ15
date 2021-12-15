package com.vpetelsky;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("TASK #1: ");
        task1();
        System.out.println("\nTASK #2: ");
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
        List<Domain> list = df.getDomainList();
        System.out.println("TOP-10 domains: ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s - %d\n", list.get(i).getName(), list.get(i).getCount());
        }
    }
}
