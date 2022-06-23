package com.abdur.datastructres.list;

import com.abdur.datastructres.base.Node;

public class SingleLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private Node<E> curr;
    int count;

    SingleLinkedList() {
        curr = tail = head = new Node<E>(null);
        count = 0;
    }

    @Override
    public void clear() {
        count = 0;
        head.setNext(null);
        curr = tail = head = new Node<>(null);
    }

    @Override
    public void insert(E e) {
        //set new node as current's next and set new node's next as current next
        curr.setNext(new Node<E>(e, curr.next()));
        //set new node as tail node
        if (tail == curr) {
            tail = curr.next();
        }
        count++;
    }

    @Override
    public void append(E e) {
        //add new node to tail's next
        tail = tail.setNext(new Node<E>(e, null));
        count++;
    }

    @Override
    public E remove() {
        //curr is pointed to preceded node, so we will consider current's next as curr node
        //this is to have access to previous node
        if (curr.next() == null) return null;
        E e = curr.next().element();
        // if removed element is tail node then assign current node(preceded node) as tail
        if (tail == curr.next()) tail = curr;
        //set current node(preceded node)s next as current's next's next node
        //the centered node now has no links hence will be GCed
        curr.setNext(curr.next().next());
        count--;
        return e;
    }

    @Override
    public void moveToStart() {
        curr = head;
    }

    @Override
    public void moveToEnd() {
        curr = tail;
    }

    @Override
    public void prev() {
        if (curr == head) return;
        Node<E> temp = head;
        //traverse whole links starting from head to match the current node
        //if matched set the preceded node as current
        while (temp.next()!=curr){
            temp = temp.next();
        }
        curr = temp;
    }

    @Override
    public void next() {
        if (curr!=tail){
            curr = curr.next();
        }
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public int currentPos() {
        Node<E> temp = head;
        int i;
        for (i =0; curr!=temp; i++){
            temp = temp.next();
        }
        return i;
    }

    @Override
    public void moveToPos(int i) {
        if ((i<=0)&&(i>=count)){
            throw new IllegalArgumentException("Position out of range");
        }
        //point curr to head and iterate until given index
        //while iterating point curr to current's next
        curr = head;
        for(int pos=0;pos<i;pos++){
            curr = curr.next();
        }
    }

    @Override
    public E getValue() {
        if (curr.next() == null) return  null;
        return curr.next().element();
    }

    @Override
    public String toString(){
        StringBuilder elements = new StringBuilder("[");
        Node<E> temp = head;
        for (int i=0;i<count;i++){
            elements.append(temp.next().element()).append(" ");
            temp = temp.next();
        }
        elements.append("]");
        return elements.toString();
    }
}
