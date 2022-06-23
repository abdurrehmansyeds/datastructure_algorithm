package com.abdur.datastructres.list;

public class Driver {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.insert(1);
        integerList.append(2);
        System.out.println(integerList);
        integerList.clear();
        System.out.println(integerList);

        List<Integer> list = new SingleLinkedList<>();
        list.append(1);
        list.append(2);
        System.out.println(list);

        List<Integer> dList = new DoubleLinkedList<>();
        dList.append(1);
        dList.insert(2);
        System.out.println(dList.currentPos());
        System.out.println(dList.getValue());

    }
}
