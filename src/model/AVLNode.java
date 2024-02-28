/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 * @param <T>
 */
public class AVLNode<T extends Comparable<T>>  {
    
    private T data;
    private int height;
    private AVLNode left;
    private AVLNode right;
    private AVLNode parent;

    public AVLNode(T data, AVLNode left, AVLNode right, AVLNode parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.height = 1;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public AVLNode getParent() {
        return parent;
    }

    public void setParent(AVLNode parent) {
        this.parent = parent;
    }
    

    @Override
    public String toString() {
        return data.toString();
    }
    
    
    
    
    
}
