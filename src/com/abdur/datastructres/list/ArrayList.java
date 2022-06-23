package com.abdur.datastructres.list;

import java.util.Objects;

public class ArrayList<E> implements List<E>{
    private static final int defaultSize = 10;
    private final int maxSize;
    private int listSize;
    private int curr;
    private final E[] listArray;
    ArrayList(){
        this(defaultSize);
    }
    @SuppressWarnings("unchecked")
    ArrayList(int size){
        maxSize = size;
        listSize = curr = 0;
        listArray = (E[]) new Object[size];
    }
    @Override
    public void clear() {
        for (int i =0; i<=listSize; i++){
            listArray[i] = null;
        }
        listSize = curr = 0;
    }

    @Override
    public void insert(E e) {
        if (listSize>maxSize){
            throw new IllegalStateException("List capacity exceeded");
        }
        //shift elements up
        for(int i=listSize;i>curr;i--){
            listArray[i] = listArray[i-1];
        }
        listArray[curr] = e;
        listSize++;
    }

    @Override
    public void append(E e) {
        if (listSize>maxSize){
            throw new IllegalStateException("List capacity exceeded");
        }
        listArray[listSize++] = e;
    }

    @Override
    public E remove() {
        if ((curr<0) || (curr>=listSize)){
            return null;
        }
        //shift elements down
        E e = listArray[curr];
        for (int i = curr; i<listSize-1; i++){
            listArray[i] = listArray[i+1];
        }
        listSize--;
        return e;
    }

    @Override
    public void moveToStart() {
        curr=0;
    }

    @Override
    public void moveToEnd() {
        curr = listSize;
    }

    @Override
    public void prev() {
        if (curr!=0){
            curr--;
        }
    }

    @Override
    public void next() {
        if (curr<listSize)
            curr++;
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public int currentPos() {
        return curr;
    }

    @Override
    public void moveToPos(int i) {
        if ((i>=0)&&(i<=listSize))
            curr = i;
    }

    @Override
    public E getValue() {
        return listArray[curr];
    }

    @Override
    public String toString(){
        StringBuilder listString = new StringBuilder();
        listString.append("[");
        for(E e : listArray){
            if (Objects.nonNull(e)){
                listString.append(e).append(" ");
            }
        }
        listString.append("]");
        return listString.toString();
    }
}
