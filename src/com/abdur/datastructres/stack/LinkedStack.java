package com.abdur.datastructres.stack;

import com.abdur.datastructres.base.Node;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int count;

    LinkedStack(){
        top = null;
        count = 0;
    }

    @Override
    public void clear() {
        count = 0;
        top = null;
    }

    @Override
    public void push(E e) {
        top = new Node<E>(e, top);
        count++;
    }

    @Override
    public E pop() {
        E element = top.element();
        top = top.next();
        count--;
        return element;
    }

    @Override
    public E topValue() {
        return top.element();
    }

    @Override
    public int length() {
        return count;
    }
}
