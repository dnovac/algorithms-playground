package com.dnovac.tree;

public class BinaryTreeImpl {

  private Node root;

  public BinaryTreeImpl(Node root) {

    this.root = root;
  }

  public static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {

      this.data = data;
    }

  }


  /**
   * First, we have to find the place where we want to add a new node in order to keep the tree sorted.
   * We'll follow these rules starting from the root node:
   * <p>
   * if the new node's value is lower than the current node's, we go to the left child
   * if the new node's value is greater than the current node's, we go to the right child
   * when the current node is null, we've reached a leaf node and we can insert the new node in that position
   */
  public Node insert(Node current, int value) {

    if (current == null) {
      return new Node(value);
    }

    if (value < current.data) {
      current.left = insert(current.left, value);
    } else if (value > current.data) {
      current.right = insert(current.right, value);
    } else {
      //value already exists
      return current;
    }
    return current;
  }


  public void add(int value) {

    root = insert(root, value);
  }


  public static int sumOfTreeNodes(Node root) {
    //calculate the sum of all the nodes of the tree in O(n) complexion

    //Edge case
    if (root == null) {
      return 0;
    } else {
      //handle children
      int leftSum = sumOfTreeNodes(root.left);
      System.out.println("Sum of left node is: " + leftSum);

      int rightSum = sumOfTreeNodes(root.right);
      System.out.println("Sum of right node is: " + rightSum);

      //merge results
      return root.data + leftSum + rightSum;
    }
  }

  //Left - Node - Right
  public static void inOrder(Node node) {

    if (node != null) {
      inOrder(node.left);
      System.out.print(" " + node.data);
      inOrder(node.right);
    }
  }

  //Node - Left - Right
  public static void preOrder(Node node) {

    if (node != null) {
      System.out.print(" " + node.data);
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  //Left - Right - Node
  public static void postOrder(Node node) {

    if (node != null) {
      postOrder(node.left);
      postOrder(node.right);
      System.out.print(" " + node.data);
    }
  }


}
