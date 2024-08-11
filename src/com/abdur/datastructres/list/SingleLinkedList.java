package com.abdur.datastructres.list;

import com.abdur.datastructres.base.Node;

public class SingleLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private Node<E> trav;
    int count;

    SingleLinkedList() {
        trav = tail = head = new Node<E>(null);
        count = 0;
    }

    @Override
    public void clear() {
        count = 0;
        head.setNext(null);
        trav = tail = head = new Node<>(null);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E get(int idx) {
        int currIdx = 0;
        for (trav = head; trav.next() != null; trav = trav.next()) {
            if (currIdx == idx) {
                return trav.element();
            }
            currIdx++;
        }
        return null;
    }

    @Override
    public void insertAt(int idx, E e) {
        if (idx < 0 || idx >= count) throw new IndexOutOfBoundsException();
        int currIdx = 0;
        for (trav = head; trav.next() != null; trav = trav.next(), currIdx++) {
            if (currIdx == idx) {
                //set new node as current's next and set new node's next as current next
                trav.setNext(new Node<>(e, trav.next()));
            }
        }

        //set new node as tail node if given idx was pointed to last node
        if (tail == trav) {
            tail = trav.next();
        }
        count++;
    }

    @Override
    public E removeAt(int idx) {
        if (idx < 0 && idx >= count) throw new IndexOutOfBoundsException();

        if (idx == 0) {
            head = head.next();
            count--;
            return head.element();
        }

        Node<E> trav1 = head.next();
        int currIdx = 0;
        for (trav = head; trav1.next() != null; trav = trav.next(), trav1 = trav1.next(), currIdx++) {
            if (currIdx == idx) {
                if (trav1.next() != tail)
                    trav.setNext(trav1.next());
                else
                    trav.setNext(null);

                count--;

            }
        }
        return trav1.element();
    }

    @Override
    public void append(E e) {
        //add new node to tail's next
        tail = tail.setNext(new Node<E>(e, null));
        count++;
    }

    @Override
    public boolean remove(E e) {
        Node<E> trav1 = head.next();
        for (trav = head; trav1.next() != null; trav = trav.next(), trav1 = trav1.next()) {
            if (trav1.element().equals(e)) {
                if (trav1.next() != tail)
                    trav.setNext(trav1.next());
                else
                    trav.setNext(null);

                count--;
                return true;
            }

        }
        return false;
    }

    @Override
    public int indexOf(E elem) {
        int currIdx = 0;
        for (trav = head; trav.next() != null; trav = trav.next(), currIdx++) {
            if (trav.element().equals(elem)) {
                return currIdx;
            }
        }
        return -1;
    }

    @Override
    public int length() {
        return count;
    }


    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder("[");
        Node<E> temp = head;
        for (int i = 0; i < count; i++) {
            elements.append(temp.next().element()).append(" ");
            temp = temp.next();
        }
        elements.append("]");
        return elements.toString();
    }
}
