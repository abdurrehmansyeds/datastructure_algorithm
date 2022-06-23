package com.abdur.datastructres.tree;

public interface BinaryTree<E> {
    int sizeByBFS();
    int sizeRecursive(BinaryNode<E> node);
    void insertByBFS(E e);
    void insertRecursive(BinaryNode<E> node,E e);
    boolean searchByBFS(E data);
    boolean searchRecursive(BinaryNode<E> node,E data);
    void delete(E data);
    BinaryNode<E> getRoot();
}
