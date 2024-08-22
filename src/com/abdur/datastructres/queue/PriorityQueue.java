package com.abdur.datastructres.queue;


import java.util.*;

public class PriorityQueue<T extends Comparable<T>> {
    private int size;
    private int capacity;
    private List<T> heap = null;
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public PriorityQueue() {
        this(10);
    }

    public PriorityQueue(int size) {
        heap = new ArrayList<>(size);
    }

    public PriorityQueue(T[] elements) {
        size = capacity = elements.length;
        heap = new ArrayList<T>(capacity);

        //place all elements in heap
        for (int i = 0; i < size; i++) {
            heap.add(elements[i]);
        }

        //Heapify process, O(n)
        for (int i = Math.max(0, (size / 2) - 1); i >= 0; i--) {
            bubbleDown(i);
        }
    }

    //PQ initialization using O(nlog(n))
    public PriorityQueue(Collection<T> elements) {
        this(elements.size());
        for (T element : elements) {
            add(element);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        //set all indices to  null
        for (int i = 0; i < size; i++)
            heap.set(1, null);

        map.clear();
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (!heap.isEmpty())
            return heap.get(0);
        return null;
    }

    public T poll() {
        return removeAt(0);
    }

    public boolean contains(T elem) {
        if (elem == null) return false;
        //Map lookup for O(1) check
        return map.containsKey(elem);

        //Linear search using for loop takes O(n)
    }

    private void add(T element) {
        if (element == null) throw new IllegalArgumentException();
        if (size < capacity) {
            heap.set(size, element);
        } else {
            heap.add(element);
            capacity++;
        }

        mapAdd(element, size);

        bubbleUp(size);
        size++;
    }

    private void mapAdd(T element, int idx) {
        TreeSet<Integer> indices = map.get(element);

        if (indices == null) {
            indices = new TreeSet<>();
            indices.add(idx);
            map.put(element, indices);
        } else indices.add(idx);
    }

    //Tests if value of node i is <= node j
    public boolean less(int i, int j) {
        T elem1 = heap.get(i);
        T elem2 = heap.get(j);
        return elem1.compareTo(elem2) <= 0;
    }

    //swim to the top O(log(n))
    private void bubbleUp(int idx) {
        //Grab the index of the parent wrt to idx
        int parent = (idx - 1) / 2;

        //Keep swimming up until we have not reached the root and we are less than our parent
        while (idx > 0 && less(idx, parent)) {
            //Exchange idx with parent
            swap(parent, idx);
            //assign parent to idx since we have moved up now, we will check for parent with grand-parent
            idx = parent;
            //Grab the grand-parent idx to repeat the process
            parent = (idx - 1) / 2;
        }
    }

    //sink to the bottom O(log(n))
    private void bubbleDown(int idx) {
        while (true) {
            int leftNode = 2 * idx + 1;
            int rightNode = 2 * idx + 2;
            //Assume left node is smallest until we figure it out further
            int smallest = leftNode;

            //Identify if right is smallest
            if (rightNode < size && less(rightNode, leftNode))
                smallest = rightNode;

            //Stop if we are outside the bounds of the tree
            //or stop early if we cannot bubble down anymore
            if (leftNode >= size || less(idx, smallest)) break;

            //Move down the tree following the smallest node
            swap(smallest, idx);

            //assign smallest child to idx since we have moved down now, we will check for children with grand-children
            idx = smallest;


        }
    }

    private void swap(int idx1, int idx2) {
        T elem1 = heap.get(idx1);
        T elem2 = heap.get(idx2);

        heap.set(idx1, elem2);
        heap.set(idx2, elem1);

        mapSwap(elem1, elem2, idx1, idx2);

    }

    private void mapSwap(T elem1, T elem2, int idx1, int idx2) {
        TreeSet<Integer> indices1 = map.get(elem1);
        TreeSet<Integer> indices2 = map.get(elem2);

        indices1.remove(idx1);
        indices2.remove(idx2);

        indices1.add(idx2);
        indices2.add(idx1);
    }

    public boolean remove(T element) {
        if (element == null) return false;

        //Linear remove is possible by for loop and removeAt(i);

        //Logarithmic removal with map O(log n)
        Integer idx = mapGet(element);
        if (idx != null) removeAt(idx);
        return idx != null;
    }


    private T removeAt(int i) {
        if (isEmpty()) return null;

        size--;
        T removedElem = heap.get(i);

        swap(i, size);

        heap.set(size, null);
        mapRemove(removedElem, size);

        if (i == size) return removedElem;

        T swappedLastNode = heap.get(i);

        bubbleDown(i);

        if (heap.get(i).equals(swappedLastNode))
            bubbleUp(i);

        return removedElem;
    }

    private void mapRemove(T element, int idx) {
        TreeSet<Integer> indices = map.get(element);
        indices.remove(idx);
        if (indices.isEmpty()) map.remove(element);
    }

    private Integer mapGet(T element) {
        TreeSet<Integer> indices = map.get(element);
        if (!indices.isEmpty()) return indices.last();
        return null;
    }
}
