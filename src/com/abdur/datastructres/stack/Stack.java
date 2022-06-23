package com.abdur.datastructres.stack;

public interface Stack<E> {
    void clear();
    void push(E e);
    E pop();
    E topValue();
    int length();
}
