package com.dnovac.tree;

public class BinaryTreeImpl {

  private Node root; //this is the root

  private int sumOfNodes = 0;
  private int leftSum = 0;
  private int rightSum = 0;

  public BinaryTreeImpl() {
  }


  public int sumOfTreeNodes(Node root) {
    //calculate the sum of all the nodes of the tree in O(n) complexion

    //Edge case
    if (root == null) {
      System.out.println("Root is missing! So sum is 0");
      return 0;
    } else {
      //handle children
      int leftSum = sumOfTreeNodes(root.getLeft());
      System.out.println("Sum of left node is: " + leftSum);

      int rightSum = sumOfTreeNodes(root.getRight());
      System.out.println("Sum of right node is: " + rightSum);

      //merge results
      return root.getData() + leftSum + rightSum;
    }
  }


}
