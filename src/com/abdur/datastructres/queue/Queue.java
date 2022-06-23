package com.abdur.datastructres.queue;

public interface Queue<E>{
    void clear();
    void enqueue(E e);
    E dequeue();
    E frontValue();
    int length();
}
