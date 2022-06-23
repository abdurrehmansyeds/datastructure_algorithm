package com.abdur.datastructres.tree;

public class Driver {

    public static void main(String[] args) {
        BinaryTreeImpl<Integer> bt = new BinaryTreeImpl<>(1);
        bt.insertByBFS(2);
        bt.insertRecursive(bt.getRoot(), 3);
        bt.delete(3);
        System.out.println(bt);
        System.out.println(bt.searchByBFS(3));
        System.out.println(bt.searchRecursive(bt.getRoot(), 1));


    }
}
