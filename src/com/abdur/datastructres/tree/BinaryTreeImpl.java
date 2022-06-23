package com.abdur.datastructres.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImpl<E> implements BinaryTree<E> {

    private final BinaryNode<E> root;

    public BinaryTreeImpl(E rootElement){
        root = new BinaryNode<E>(rootElement,null,null);
    }

    @Override
    public int sizeByBFS() {
        int count=0;
        if (root.right()==null && root.left()==null){
            return 0;
        }
        Queue<BinaryNode<E>> levels = new LinkedList<>();
        levels.offer(root);
        while (!levels.isEmpty()){
            BinaryNode<E> temp = levels.poll();
            count++;
            if (temp.left()!=null){
                levels.offer(temp.left());
            }
            if (temp.right()!=null){
                levels.offer(temp.right());
            }
        }
        return count;
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
        while (!levels.isEmpty()){
            BinaryNode<E> temp = levels.poll();
            if (temp.left()!=null){
                if (temp.right()!=null){
                    levels.offer(temp.left());
                    levels.offer(temp.right());
                }else {
                    temp.setRight(new BinaryNode<>(e,null,null));
                }
            }else {
                temp.setLeft(new BinaryNode<>(e,null,null));
                return;
            }
        }
    }

    @Override
    public void insertRecursive(BinaryNode<E> node,E e) {
        if (node.left()!=null){
            if (node.right()!=null){
                insertRecursive(node.left(),e);
                insertRecursive(node.right(),e);
            }else {
                node.setRight(new BinaryNode<>(e,null,null));
            }
        }else {
            node.setLeft(new BinaryNode<>(e,null,null));
        }
    }

    @Override
    public boolean searchByBFS(E data) {
        if (root.element().equals(data)){
            return true;
        }
        Queue<BinaryNode<E>> levels = new LinkedList<>();
        levels.offer(root);
        while (!levels.isEmpty()){
            BinaryNode<E> temp = levels.poll();
            if (temp.left()!=null){
                if (temp.left().element().equals(data)){
                    return true;
                }else {
                    levels.offer(temp.left());
                }
            }
            if (temp.right()!=null){
                if (temp.right().element().equals(data)){
                    return true;
                }else {
                    levels.offer(temp.right());
                }
            }
        }
        return false;
    }

    @Override
    public boolean searchRecursive(BinaryNode<E> node,E data) {
        if (node.element().equals(data)){
            return true;
        }
        if (node.left()!=null){
            if (node.left().element().equals(data)){
                return true;
            }else {
                searchRecursive(node.left(),data);
            }
        }
        if (node.right()!=null){
            if (node.right().element().equals(data)){
                return true;
            }else {
                searchRecursive(node.right(),data);
            }
        }
        return false;
    }

    @Override
    public void delete(E data) {
        if (root.element().equals(data)){
            throw new IllegalArgumentException("cannot delete root element");
        }
        Queue<BinaryNode<E>> levels = new LinkedList<>();
        levels.offer(root);
        while (!levels.isEmpty()){
            BinaryNode<E> temp = levels.poll();
            if (temp.left()!=null){
                if (temp.left().element().equals(data)){
                    temp.setLeft(null);
                    return;
                }else {
                    levels.add(temp.left());
                }
            }
            if (temp.right()!=null){
                if (temp.right().element().equals(data)){
                    temp.setRight(null);
                    return;
                }else {
                    levels.add(temp.right());
                }
            }
        }
    }

    @Override
    public BinaryNode<E> getRoot() {
        return root;
    }

    @Override
    public String toString(){
        StringBuilder printAble = new StringBuilder();
        print(root,printAble);
        return printAble.toString();
    }

    private void print(BinaryNode<E> node,StringBuilder text){
        if (node!=null){
            text.append(node.element());
            if (node.left()!=null){
                print(node.left(),text);
            }
            if (node.right()!=null){
                print(node.right(),text);
            }
        }
    }
}
