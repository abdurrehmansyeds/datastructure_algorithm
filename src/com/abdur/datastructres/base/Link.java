package com.abdur.datastructres.base;

public class Link<E> {
    private  E e ;
    private Link<E> prev;
    private Link<E> next;

    public Link(E e, Link<E> prev, Link<E> next) {
        this.e = e;
        this.prev = prev;
        this.next = next;
    }

    public E getElement() {
        return e;
    }

    public void setElement(E e) {
        this.e = e;
    }

    public Link<E> prev() {
        return prev;
    }

    public void setPrev(Link<E> prev) {
        this.prev = prev;
    }

    public Link<E> next() {
        return next;
    }

    public void setNext(Link<E> next) {
        this.next = next;
    }
}
