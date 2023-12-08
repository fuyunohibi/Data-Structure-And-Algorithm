// 65011338 Ko-Kwan Mongkholtham
import code.TreeNode;

public class BST {
  TreeNode root;

  public BST() {
    root = null;
  }

  public static void main(String[] args) {
    demo1();
  }

  public TreeNode getRoot() {
    return root;
  }

  public void insert(int d) {
    if (root == null) {
      root = new TreeNode(d);
    } else {
      TreeNode cur = root;
      while (cur != null) {
        if (d < cur.data) {
          if (cur.left != null)
            cur = cur.left;
          else {
            cur.left = new TreeNode(d);
            cur.left.parent = cur;
            return;
          }
        } else { // ! (d < p.data)
          if (cur.right != null)
            cur = cur.right;
          else {
            cur.right = new TreeNode(d);
            cur.right.parent = cur;
            return;
          }
        }
      } // while
    }
  } // insert by iteration

  public void printPreOrder() {
    printPreOrderRecurse(root);
  }

  private void printPreOrderRecurse(TreeNode node) {
    if (node != null) {
      System.out.print(node.data + " ");
      printPreOrderRecurse(node.left);
      printPreOrderRecurse(node.right);
    }
  }

  public static void demo1() {
    System.out.println("-insert and preOrder traversal-");
    int[] dat = { 15, 20, 10, 18, 16,
        12, 8, 25, 19, 30 };
    BST bst = new BST();
    for (int j = 0; j < dat.length; j++)
      bst.insert(dat[j]);
    bst.printPreOrder();
    // 15 10 8 12 20 18 16 19 25 30
    System.out.println();
    demo2(bst);
    demo3(bst);
  }

  static void demo2(BST bst) {
    System.out.println("-more traversal---");
    bst.printInOrder();
    System.out.println();
    // 8 10 12 15 16 18 19 20 25 30
    bst.printPostOrder();
    System.out.println();
    // 8 12 10 16 19 18 30 25 20 15
    // demo3(bst);
  }

  static void demo3(BST bst) {
    System.out.println("-search recursive---");
    System.out.println(bst.search(20)); // 18<-20->25
    System.out.println(bst.search(25)); // null<-25->30
    System.out.println(bst.search(12)); // null<-12->null
    System.out.println(bst.search(1)); // null
    System.out.println(bst.searchRecurse(10, bst.getRoot())); // 8<-10->12
    // if searchRecurse and getRoot is available
    System.out.println("-search iterative---");
    System.out.println(bst.searchIter(20));
    System.out.println(bst.searchIter(25));
    System.out.println(bst.searchIter(12));
    System.out.println(bst.searchIter(1));
  }

  public void printInOrder() {
    printInOrderRecurse(root);
  }

  private void printInOrderRecurse(TreeNode node) {
    if (node != null) {
      printInOrderRecurse(node.left);
      System.out.print(node.data + " ");
      printInOrderRecurse(node.right);
    }

  }

  public void printPostOrder() {
    printPostOrderRecurse(root);
  }

  private void printPostOrderRecurse(TreeNode node) {
    if (node != null) {
      printPostOrderRecurse(node.left);
      printPostOrderRecurse(node.right);
      System.out.print(node.data + " ");
    }
  }

  public TreeNode search(int d) {
    TreeNode result = searchRecurse(d, root);
    return result;
  }

  public TreeNode searchRecurse(int d, TreeNode n) {
    if (n == null)
      return null;
    if (d == n.data)
      return n;
    if (d < n.data)
      return searchRecurse(d, n.left);
    else
      return searchRecurse(d, n.right);
  }

  public TreeNode searchIter(int key) {
    if (root.data == key)
      return root;
    TreeNode current = root;
    while (current != null) {
      if (key < current.data) {
        if (current.left != null)
          current = current.left;
        else
          current = null; // NOTE: stop the loop if left child is null
      } else {
        if (current.right != null)
          current = current.right;
        else
          current = null; // NOTE: stop the loop if right child is null
      }
      if (current != null && current.data == key)
        return current;
    } // while
    return null;
  }

}