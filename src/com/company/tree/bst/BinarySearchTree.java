package com.company.tree.bst;

public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        Node left;
        Node right;
        E data;

        Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addNode(E e) {
        root = addNode(root, e);

    }

    private Node addNode(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.data.compareTo(e) == 0) {
            return node;
        } else if (node.data.compareTo(e) > 0) {
            node.left = addNode(node.left, e);
        } else {
            node.right = addNode(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {

        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.data.equals(e)) {
            return true;
        } else if (node.data.compareTo(e) > 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }


    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {

        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }

    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        generationBSTString(root, 0, builder);
        return builder.toString();
    }

    private void generationBSTString(Node node, int deptch, StringBuilder builder) {

        if (node == null) {
           builder.append( generationString(deptch) +  " null \n");
            return ;

        }
        builder.append(generationString(deptch)+ node.data  + "\n");
        generationBSTString(node.left,deptch+1,builder);
        generationBSTString(node.right,deptch+1,builder);


    }

    private String generationString(int deptch) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < deptch; i++) {
            builder.append("--");
        }
        return  builder.toString();

    }
}
