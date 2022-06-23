package com.abdur.datastructres.queue;

public class CircularQueue<E> implements Queue<E>{
    private static final int defaultSize = 10;
    private int front;
    private int rear;
    private E[] elements;
    private int maxSize;
    public CircularQueue(){
        this(defaultSize);
    }

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize+1;
        front = 1;
        rear=0;
        elements = (E[]) new Object[maxSize];
    }

    @Override
    public void clear() {
        rear=0; front=1;
    }

    @Override
    public void enqueue(E e) {
        if (((rear+2)%maxSize)==front){
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear+1)%maxSize;
        elements[rear] = e;
    }

    @Override
    public E dequeue() {
        if (length()==0){
            throw new IllegalStateException("Queue is empty");
        }
        E e = elements[front];
        front = (front+1)%maxSize;
        return e;
    }

    @Override
    public E frontValue() {
        if (length()==0){
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }

    @Override
    public int length() {
        return((rear+maxSize)-front+1)% maxSize;
    }
}
