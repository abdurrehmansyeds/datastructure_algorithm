package com.abdur.datastructres.list;

import java.util.LinkedList;

public class Driver {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.append(1);
        integerList.append(2);
        System.out.println("Index of: "+integerList.indexOf(2));
        integerList.insertAt(1,3);
        System.out.println(integerList);
        integerList.remove(3);
        System.out.println(integerList);
        System.out.println(integerList.get(1));

        List<Integer> list = new SingleLinkedList<>();
        list.append(1);
        list.append(2);
        System.out.println(list.length());
        System.out.println("Index of: "+list.indexOf(2));
        list.insertAt(1,3);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.get(1));


    }
}
