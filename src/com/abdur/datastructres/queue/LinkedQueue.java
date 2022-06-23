package com.abdur.datastructres.queue;

import com.abdur.datastructres.base.Node;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;
    public LinkedQueue(){
        init(0);
    }
    public LinkedQueue(int size){
        init(size);
    }
    private void init(int size) {
        front = rear = new Node<>(null);
        this.size = size;
    }
    @Override
    public void clear() {
        init(0);
    }

    @Override
    public void enqueue(E e) {
        rear.setNext(new Node<E>(e,null));
        rear = rear.next();
        size++;
    }

    @Override
    public E dequeue() {
        if (size==0){
            throw new IllegalStateException("Queue is empty");
        }
        E e = front.next().element();
        front.setNext(front.next().next());
        if (front.next()==null){
            rear = front;
        }
        size--;
        return e;

    }

    @Override
    public E frontValue() {
        if (size==0){
            throw new IllegalStateException("Queue is empty");
        }
        return front.next().element();
    }

    @Override
    public int length() {
        return size;
    }
}
