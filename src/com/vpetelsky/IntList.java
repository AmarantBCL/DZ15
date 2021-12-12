package com.vpetelsky;

import java.io.Serializable;
import java.util.Arrays;

/*
1) Дополнить класс IntList
https://gist.github.com/akadatsky/4aa0f9ee381c54194aa0dd54f138de7f

Необходимо создать класс аналогичный стандартному ArrayList<Integer> на базе массива.
Реализовать 5 методов:

add - добавить значение в список
get - получить по индексу
set - заменить по индексу
size - вернуть размер, изначально 0
toString - красиво печатет список

Логика метода add:
создаем временный массив на 1 элемент больше чем arr, копируем в него все элементы из arr, на последнюю
позицию записываем новый элемент и заменяем arr на временный массив.
*/
public class IntList {

    private int[] arr = new int[0];

    public void add(int value) {
        int[] tempArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        tempArr[tempArr.length - 1] = value;
        arr = tempArr;
    }

    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int size() {
        return arr.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
