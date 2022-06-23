package com.abdur.datastructres.list;

public interface List<E> {
    void clear();
    void insert(E e);
    void append(E e);
    E remove();
    void moveToStart();
    void moveToEnd();
    void prev();
    void next();
    int length();
    int currentPos();
    void moveToPos(int i);
    E getValue();
}
