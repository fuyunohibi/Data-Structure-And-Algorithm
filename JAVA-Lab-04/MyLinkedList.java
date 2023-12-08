public class MyLinkedList {
  private static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node head;
  private int size;

  public MyLinkedList() {
    head = null;
    size = 0;
  }

  // [d]
  // []-->[]-->[]-->[]
  void add(int d) {
    Node newNode = new Node(d);
    newNode.next = head;
    head = newNode;
    size++;
  }



  // [1] [2] [3] [5] []
  // [4]
  void insert(int d) {
    Node newNode = new Node(d);
    if (head == null || head.data >= d) {
      newNode.next = head;
      head = newNode;
    } else {
      Node current = head;
      while (current.next != null && current.next.data < d) {
        current = current.next;
      }

      newNode.next = current.next;
      current.next = newNode;
    }
    size++;
  }

  // List: [2] [4] [5] [] []
  // index: 2
  // current: [5]
  // find: [6] 
  public int find(int d) {
    int index = 0;
    Node current = head;
    while (current.next != null) {
      if (current.data == d) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  // [7] [6] [1] [] []
  // current: [7]
  // data: [6]
  public void delete(int d) {
    if (head == null) return;
    if (head.data == d) {
      head = head.next;
      size--;
      return;
    }
    Node current = head;
    while (current.next != null) {
      if (current.next.data == d) {
        current.next = current.next.next;
        size--;
        return;
      } 
      current = current.next;
    }
  }
  
  void printList() {
    Node current = head;
    System.out.print("List: ");
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }
    System.out.print("null" + "\n");
  }


  // [1] [2] [3]

  // next = [2]
  // [1] -> [null]
  // prev = [1]
  // current = [2]

  
  public void reverse() {
    Node prev = null;
    Node current = head;
    Node next;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev;
  }
  


  public static void main(String[] args) {
    MyLinkedList list =  new MyLinkedList();
    list.add(3);
    list.add(2);
    list.add(1);
    list.printList();
    // System.out.println(list.find(7));
    // list.delete(6);
    list.printList();

  }
}
