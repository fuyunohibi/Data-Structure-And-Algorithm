// 65011338 Ko-Kwan Mongkholtham
import code.TreeNode;

public class BST {
  TreeNode root;

  public BST() {
    root = null;
  }

  public static void main(String[] args) {
    // demo1();
    // demo2();
    demo3();
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

  public int height() {
    return root == null ? 0 : height(root);
  }

  public TreeNode getRoot() {
    return root;
  }

  // ================ TASK 1 ================
  public int height(TreeNode node) {
    if (node == null)
      return 0;
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);
    System.out.println("node = " + node.data + ", leftHeight = " + leftHeight + ", rightHeight = " + rightHeight);
    return 1 + Math.max(leftHeight, rightHeight);
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

  // ================ TASK 2 ================
  public TreeNode findMaxFrom(TreeNode subtreeHead) {
    if (subtreeHead == null) return null;
    TreeNode current = subtreeHead;
    while (current.right != null) {
      current = current.right;
    }
    return current;
  }

  // ================ TASK 3 ================
  public void delete(int d, TreeNode current) {
    if (current == null) return; // not found

    if (d < current.data)
      delete(d, current.left);
    else if (d > current.data)
      delete(d, current.right);
    else { // found ... time to delete
      if (current.left == null || current.right == null) { // 0 or 1 child
        TreeNode q = (current.left == null) ? current.right : current.left;
        if (current.parent == null) { // NEWCASE: current is the root node  (handleChange root)
        // HANDLE CHANGE ROOT:
          root = q; // assign the root to q, which might be null or the only child of the current
        } else if (current.parent.left == current)
          current.parent.left = q; // this node is left child
        else
          current.parent.right = q;
        if (q != null)
          q.parent = current.parent;
      } else { // two children
        TreeNode maxNode = findMaxFrom(current.left);
        if (maxNode != null) { // NEWCASE: current.left is not null
          current.data = maxNode.data;
          delete(maxNode.data, current.left);
        }
      } // two children
    } // found
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


  // ================ DEMO ================
  public static void demo1() {
    int[] data = { 2, 1, 3, 4, 5, 6, 7, 8, 9 };
    BST bst = new BST();
    for (int j = 0; j < data.length; j++)
      bst.insert(data[j]);
    bst.printInOrder();
    System.out.println("Tree height = " + bst.height());
    int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
    bst = new BST();
    for (int j = 0; j < dat.length; j++)
      bst.insert(dat[j]);
    bst.printInOrder();
    System.out.println("Tree height = " + bst.height());
  }

  public static void demo2() {
    int[] data = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
    BST bst = new BST();
    for (int i = 0; i < data.length; i++)
      bst.insert(data[i]);
    System.out.println("node with max value " + bst.findMaxFrom(bst.getRoot()));
  }

  public static void demo3() {
    int[] data = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
    BST bst = new BST();
    for (int i = 0; i < data.length; i++)
      bst.insert(data[i]);

    bst.delete(12, bst.getRoot());
    System.out.println(bst.search(20)); // 18<-20->25
    System.out.println(bst.search(25)); // null<-25->30
    System.out.println(bst.search(16)); // null<-16->null
    System.out.println(bst.search(10)); // 8<-10->null
    System.out.println(bst.search(12)); // not found
  }
}