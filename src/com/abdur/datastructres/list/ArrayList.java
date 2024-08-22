package com.abdur.datastructres.list;

import java.util.Iterator;
import java.util.Objects;

public class ArrayList<E> implements List<E> {
    private int capacity = 0;
    private int length = 0;
    private E[] arr;

    ArrayList() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    ArrayList(int capacity) {
        this.capacity = capacity;
        arr = (E[]) new Object[capacity];
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public E get(int idx) {
        return arr[idx];
    }

    @Override
    public void clear() {
        for (int i = 0; i <= length; i++) {
            arr[i] = null;
        }
        length = 0;
    }

    @Override
    public void insertAt(int idx, E e) {
        mayBeIncreaseCapacity();
        if (idx < 0 || idx >= length ) throw new IndexOutOfBoundsException();
        //shift elements up
        for (int i = length; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = e;
        length++;
    }

    @Override
    public void append(E elem) {
        mayBeIncreaseCapacity();
        arr[length++] = elem;
    }

    private void mayBeIncreaseCapacity() {
        if (length + 1 > capacity) {
            capacity *= 2;
            E[] newArr = (E[]) new Object[capacity];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }

    @Override
    public E removeAt(int idx) {
        if (idx >= length && idx < 0) throw new IndexOutOfBoundsException();
        E elem = arr[idx];
        E[] newArr = (E[]) new Object[capacity];
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == idx) j--;
            else newArr[j] = arr[i];
        }
        arr = newArr;
        length--;
        return elem;
    }

    @Override
    public boolean remove(E elem) {
        int idx = indexOf(elem);
        if (idx != -1) {
            removeAt(idx);
            return true;
        } else return false;

    }

    @Override
    public int indexOf(E elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder();
        listString.append("[");
        for (E e : arr) {
            if (Objects.nonNull(e)) {
                listString.append(e).append(" ");
            }
        }
        listString.append("]");
        return listString.toString();
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public E next() {
                return arr[index++];
            }
        };
    }

}
