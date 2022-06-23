package com.abdur.datastructres.tree;

public class BinaryNode<E> {

    private E e;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode(E e, BinaryNode<E> left, BinaryNode<E> right) {
        this.e = e;
        this.left = left;
        this.right = right;
    }

    public E element() {
        return e;
    }

    public void setElement(E e) {
        this.e = e;
    }

    public BinaryNode<E> left() {
        return left;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> right() {
        return right;
    }

    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }
}
