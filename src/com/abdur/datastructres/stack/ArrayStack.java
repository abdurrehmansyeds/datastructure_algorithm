package com.abdur.datastructres.stack;

public class ArrayStack<E> implements Stack<E>{
    private static final int defaultSize = 10;
    private final int maxSize;
    private int top;
    private final E[] eleArray;
    ArrayStack(){
        this(defaultSize);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        maxSize =  size;
        top = 0;
        eleArray = (E[]) new Object[size];
    }

    @Override
    public void clear() {
        for (int i=0;i<maxSize;i++){
            eleArray[i] = null;
        }
        top=0;
    }

    @Override
    public void push(E o) {
        if (top==maxSize){
            throw new IllegalStateException("Stack is full");
        }
        eleArray[top++]=o;
    }

    @Override
    public E pop() {
        if (top==0){
            throw new IllegalStateException("Stack is empty");
        }
        return eleArray[--top];
    }

    @Override
    public E topValue() {
        if (top==0){
            throw new IllegalStateException("Stack is empty");
        }
        return eleArray[top-1];
    }

    @Override
    public int length() {
        return top;
    }
}
