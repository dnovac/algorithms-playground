package com.dnovac.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


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
      this.left = null;
      this.right = null;
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

  public void preOrderWithoutRecursion() {

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node currentNode = stack.pop();

      System.out.println("preOrder without recurs: " + currentNode.data);

      if (currentNode.left != null) {
        stack.push(currentNode.left);
      }
      if (currentNode.right != null) {
        stack.push(currentNode.right);
      }
    }
  }

  public void inOrderWithoutRecursion() {

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node currentNode = stack.pop();
      while (currentNode.left != null) {
        stack.push(currentNode.left);
      }
      currentNode = stack.pop();
      System.out.println("inOrder without recursion: " + currentNode.data);

      if (currentNode.right != null) {
        stack.push(currentNode.right);
      }
    }
  }


  /**
   * Breadth first search
   * search for neighbours first, then children
   */
 /*
  1) Create an empty queue q
  2) temp_node = root *//*start from root*//*
  3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node’s children (first left then right children) to q
    c) Dequeue a node from q and assign it’s value to temp_node
*/
  public void breadthFirstSearch(int target) {

    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      System.out.println("BFS - Node: " + currentNode.data);

      if (currentNode.data == target) {
        System.out.println("FOUND " + currentNode.data);
        break;
      }

      if (currentNode.left != null) {
        queue.add(currentNode.left);
      }

      if (currentNode.right != null) {
        queue.add(currentNode.right);
      }
      queue.remove(currentNode);
    }
  }

  public Node breadthFirstSearchGraph(int target) {

    if (root == null) return null;
    Queue<Node> queue = new LinkedList<>();
    Set<Node> alreadyVisited = new HashSet<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      System.out.println("BFS - Node: " + currentNode.data);

      if (currentNode.data == target) {
        System.out.println("FOUND " + currentNode.data);
        return currentNode;
      } else {
        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }

        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }

        alreadyVisited.add(currentNode);

        queue.remove(currentNode);
        /* Then, when the comparison of values fails, we add the node to the visited ones:
         * alreadyVisited.add(currentNode);
         * Finally, after adding the node's neighbors to the queue,
         * we remove from it the already visited nodes (which is an alternative way of checking the current node's presence in that set):
         * queue.removeAll(alreadyVisited);
         * By doing this, we make sure that the algorithm won't fall into an infinite loop.*/
        queue.removeAll(alreadyVisited);
      }
    }
    return null;
  }


  public void depthFirstSearch(int target) {

    if (root == null) {
      return;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {

      Node currentNode = stack.pop();
      System.out.println("Visiting node with value: " + currentNode.data);

      if (currentNode.data == target) {
        System.out.println("Target found: " + currentNode.data);
        break;
      }

      if (currentNode.left != null) {
        stack.push(currentNode.left);
      }

      if (currentNode.right != null) {
        stack.push(currentNode.right);
      }
    }
  }

  public Node lowestCommonAncestor(Node root, int node1, int node2) {

    if (root == null) {
      return null;
    }

    if (node1 < root.data && node2 < root.data) {
      //if both the searching nodes are less (<) than the root node then go on the left side
      return lowestCommonAncestor(root.left, node1, node2);
    }
    if (node1 > root.data && node2 > root.data) {
      //if both searching nodes are greater than the root data, go on the right side
      return lowestCommonAncestor(root.right, node1, node2);
    }
    //if is not in left, or right, it must be the current node
    System.out.println(String.format("Lowest common ancestor for %s and %s is %s", node1, node2, root.data));
    return root;
  }

  /**
   * Recursive function to construct binary of size len from
   * Inorder traversal inorder[]. Initial values of start and end
   * should be 0 and len -1.
   *
   * @param array
   * @param start
   * @param end
   * @param node
   * @return Node
   */
  private Node buildTreeFromInorder(int[] array, int start, int end, Node node) {

    if (start > end) return null;

    //1) Find index of the maximum element in array. The maximum element must be root of Binary Tree.
    //int maxValueAsInt = Arrays.stream(array).max().getAsInt();

    /* Find index of the maximum element from Binary Tree */
    int maximumValIndex = max(array, start, end);

    /* Pick the maximum value and make it root */
    Node root = new Node(array[maximumValIndex]);

    /* If this is the only element in inorder[start..end],
         then return it */
    if (start == end)
      return node;

    //3) Call buildTree for elements before the maximum element and make the built tree as left subtree of ‘root’.
    node.left = buildTreeFromInorder(array, start, maximumValIndex - 1, node.left);

    //4) Call buildTree for elements after the maximum element and make the built tree as right subtree of ‘root’.
    node.right = buildTreeFromInorder(array, maximumValIndex + 1, end, node.right);

    return root;
  }

  private int max(int[] array, int start, int end) {

    int max = array[start];
    int maxIndex = start;

    for (int j = start; j < end; j++) {
      if (array[j] > max) {
        max = array[j];
        maxIndex = j;
      }
    }
    return maxIndex;
  }


  public void reverseTreeNodes(Node node) {

    if (node != null) {
      Node tempNode = node.left;
      node.left = node.right;
      node.right = tempNode;

      reverseTreeNodes(node.left);
      reverseTreeNodes(node.right);
    }
  }

  public int maxHeight(Node node) {

    if (node == null) {
      return -1;
    }
    int heightLeft = maxHeight(node.left);
    int heightRight = maxHeight(node.right);

    //get the max depth of left or right
    if (heightLeft > heightRight) {
      return 1 + heightLeft;
    } else {
      return 1 + heightRight;
    }
  }

  /**
   * Helper function for getLevel().  It returns level of the data
   * if data is present in tree, otherwise returns 0.
   * <p>
   * The idea is to start from the root and level as 1.
   * If the key matches with root’s data, return level.
   * Else recursively call for left and right subtrees with level as level + 1.
   *
   * @param node
   * @param data
   * @param startLvl
   * @return height of input node as data param
   */
  public int heightOfNode(Node node, int data, int startLvl) {

    if (node == null) {
      return 0;
    }

    if (node.data == data) {
      System.out.println("Data was found on lvl: " + startLvl);
      return startLvl;
    }

    int downLvl = heightOfNode(node.left, data, startLvl + 1);
    if (downLvl != 0) {
      return downLvl;
    }
    downLvl = heightOfNode(node.right, data, startLvl + 1);
    return downLvl;
  }


  public static void printKDistant(Node node, int k) {

    if (node == null) {
      return;
    }

    if (k == 0) {
      System.out.println(String.format("Node %s is at given distance", node.data));
      return;
    } else {
      printKDistant(node.left, k - 1);
      printKDistant(node.right, k - 1);
    }
  }

  public static boolean checkDuplicates(Node node) {

    HashSet<Integer> set = new HashSet<>();
    return checkDuplicatesRec(node, set);
  }


  /**
   *
   * @param node
   * @param set
   * @return true | false
   */
  private static boolean checkDuplicatesRec(Node node, HashSet<Integer> set) {

    if (node == null) {
      return false;
    }

    if (set.contains(node.data)) {
      return true;
    }
    set.add(node.data);

    return checkDuplicatesRec(node.left, set) || checkDuplicatesRec(node.right, set);

  }

}
