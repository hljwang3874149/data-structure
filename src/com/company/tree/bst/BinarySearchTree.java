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

    public E minNode() {
        if (size == 0) throw new IllegalArgumentException("BST is null ");
        return minNode(root).data;
    }

    private Node minNode(Node node) {

        if (node.left == null) {
            return node;
        }
        return minNode(node.left);

    }

    public E maxNode() {
        if (size == 0) throw new IllegalArgumentException("BST is null ");
        return maxNode(root).data;
    }

    private Node maxNode(Node node) {

        if (node.right == null) {
            return node;
        }

        return maxNode(node.right);
    }

    public E removeMin() {
        E min = minNode();
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;

    }

    public E removeMax() {
        E max = maxNode();
        root = removeMax(root);
        return max;

    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;

    }

    public void remove(E e) {
        remove(root, e);


    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.data) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else if (e.compareTo(node.data) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }

            return findSuccessorByRightMinNode(node);
//            return findSuccessorByLeftMaxNode(node); /

        }

    }

    /**
     * 使用右子树 最小节点
     *
     * @param node
     * @return
     */
    private Node findSuccessorByRightMinNode(Node node) {
        Node successor = minNode(node.right);
        successor.left = node.left;
        successor.right = removeMin(node.right);
        node.left = node.right = null;
        return successor;
    }

    /**
     * 使用 左子树最大值节点
     *
     * @param node
     * @return
     */

    private Node findSuccessorByLeftMaxNode(Node node) {
        Node successor = maxNode(node.left);
        successor.left = removeMax(node.left);
        successor.right = node.right;
        node.right = node.left = null;
        return successor;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        generationBSTString(root, 0, builder);
        return builder.toString();
    }

    private void generationBSTString(Node node, int deptch, StringBuilder builder) {

        if (node == null) {
            builder.append(generationString(deptch)).append(" null \n");
            return;

        }
        builder.append(generationString(deptch)).append(node.data).append("\n");
        generationBSTString(node.left, deptch + 1, builder);
        generationBSTString(node.right, deptch + 1, builder);


    }

    private String generationString(int deptch) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < deptch; i++) {
            builder.append("--");
        }
        return builder.toString();

    }
}
