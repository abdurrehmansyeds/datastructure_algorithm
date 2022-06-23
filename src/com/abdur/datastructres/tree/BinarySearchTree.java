package com.abdur.datastructres.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {
    private BinaryNode<E> root;

    public BinarySearchTree(E e) {
        root = new BinaryNode<>(e, null, null);
    }

    @Override
    public int sizeByBFS() {

        return 0;
    }

    @Override
    public int sizeRecursive(BinaryNode<E> node) {
        int leftCount = node.left()==null?0:sizeRecursive(node.left());
        int rightCount = node.right()==null?0:sizeRecursive(node.right());
        return 1+leftCount+rightCount;
    }

    @Override
    public void insertByBFS(E e) {
        Queue<BinaryNode<E>> levels = new LinkedList<>();
        levels.offer(root);
        while (!levels.isEmpty()) {
            BinaryNode<E> temp = levels.poll();
            if (temp.element().equals(e)) {
                return;
            }
            if (temp.element().compareTo(e) > 0) {
                if (temp.left() != null) {
                    levels.offer(temp.left());
                } else {
                    temp.setLeft(new BinaryNode<>(e, null, null));
                }
            } else if (temp.element().compareTo(e) < 0) {
                if (temp.right() != null) {
                    levels.offer(temp.right());
                } else {
                    temp.setRight(new BinaryNode<>(e, null, null));
                }
            }
        }
    }

    @Override
    public void insertRecursive(BinaryNode<E> node, E e) {
        if (node.element().equals(e)){
            return;
        }
        if (node.element().compareTo(e) > 0) {
            if (node.left() != null) {
                insertRecursive(node.left(), e);
            } else {
                node.setLeft(new BinaryNode<>(e, null, null));
            }
        }else if (node.element().compareTo(e) < 0){
            if (node.right() != null) {
                insertRecursive(node.right(), e);
            } else {
                node.setRight(new BinaryNode<>(e, null, null));
            }
        }
    }

    @Override
    public boolean searchByBFS(E data) {
        return isPresent(root,data);
    }
    private boolean isPresent(BinaryNode<E> root, E e){
        if (root==null){
            return false;
        }
        while (root!=null){
            if(root.element().equals(e)){
                return true;
            }else if(root.element().compareTo(e)>0){
                root = root.left();
            }else if(root.element().compareTo(e)<0){
                root = root.right();
            }
        }
        return false;
    }

    @Override
    public boolean searchRecursive(BinaryNode<E> node, E data) {
        if (node.element().equals(data)){
            return true;
        }
        if (node.element().compareTo(data)>0 ){
            if (node.left()!=null){
                searchRecursive(node.left(),data);
            }else {
                return false;
            }
        }else if (node.element().compareTo(data)<0 ){
            if (node.right()!=null){
                searchRecursive(node.right(),data);
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void delete(E data) {

    }

    @Override
    public BinaryNode<E> getRoot() {
        return root;
    }
}
