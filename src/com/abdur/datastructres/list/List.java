package com.abdur.datastructres.list;

public interface List<E> {
    void clear();
    boolean isEmpty();
    E get(int idx);
    void insertAt(int idx, E e);
    E removeAt(int idx);
    boolean remove(E elem);
    int indexOf(E elem);
    void append(E e);
    int length();
}
