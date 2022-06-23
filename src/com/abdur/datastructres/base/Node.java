package com.abdur.datastructres.base;

public class Node<E> {
    private E e;
    private Node<E> next;

    public Node(E e, Node<E> nextNode){
        this.e = e;
        next = nextNode;
    }
    public Node(Node<E> nextNode){
        next  = nextNode;
    }

    public E element() {
        return e;
    }

    public void setElement(E e) {
        this.e = e;
    }

    public Node<E> next() {
        return next;
    }

    public Node<E> setNext(Node<E> next) {
        return this.next = next;
    }
}
