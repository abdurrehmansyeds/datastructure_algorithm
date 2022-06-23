package com.abdur.datastructres.list;

import com.abdur.datastructres.base.Link;

public class DoubleLinkedList<E> implements List<E> {
    private int count;
    private Link<E> head;
    private Link<E> curr;
    private Link<E> tail;

    DoubleLinkedList() {
        count = 0;
        head = curr = tail = new Link<>(null, null, null);

    }

    @Override
    public void clear() {
        count = 0;
        head.setNext(null);
        head = curr = tail = new Link<>(null, null, null);

    }

    @Override
    public void insert(E e) {
        curr.setNext(new Link<>(e, curr, curr.next()));
        if(curr.next().next()!=null){
            curr.next().next().setPrev(curr.next());
        }
        curr=curr.next();
        count++;
    }

    @Override
    public void append(E e) {
        tail.setPrev(new Link<>(e, tail.prev(), tail));
        if (tail.prev().prev()!=null){
            tail.prev().prev().setNext(tail.prev());
        }
        curr = tail.prev();
        count++;
    }

    @Override
    public E remove() {
        if (curr.next() == tail) return null;
        E e = curr.getElement();
        curr.prev().setNext(curr.next());
        curr.next().setPrev(curr.prev());
        count--;
        return e;
    }

    @Override
    public void moveToStart() {
        curr = head;
    }

    @Override
    public void moveToEnd() {
        if (curr.next()!=tail)
        curr = tail;
    }

    @Override
    public void prev() {
        if (curr.prev() != head) {
            curr = curr.prev();
        }
    }

    @Override
    public void next() {
        curr = curr.next();
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public int currentPos() {
        Link<E> temp = head;
        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    @Override
    public void moveToPos(int i) {
        if ((i <= 0) && (i >= count)) {
            throw new IllegalArgumentException("Position out of range");
        }
        //point curr to head and iterate until given index
        //while iterating point curr to current's next
        curr = head;
        for (int pos = 0; pos < i; pos++) {
            curr = curr.next();
        }
    }

    @Override
    public E getValue() {
        return curr.getElement();
    }
}
