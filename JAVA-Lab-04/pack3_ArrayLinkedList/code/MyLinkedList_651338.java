package code;
import java.util.Stack;
import java.util.Arrays;


public class MyLinkedList_651338 {

   private Node head;
   private int size;

   private static class Node {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }

   public MyLinkedList_651338() {
      head = null;
      size = 0;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      Node current = head;
      sb.append("head -> ");
      while (current != null) {
         sb.append("(" + current.data + ")");
         sb.append(" -> ");
         current = current.next;
      }
      sb.append("null");
      return sb.toString();
   }



   // ================================= START: TASK 1 ================================  
   public void add(int d) {
      Node newNode = new Node(d);
      newNode.next = head;
      head = newNode;
      size++;
   }

   public void insert(int d) {
      Node newNode = new Node(d);
      if (head == null || head.data >= newNode.data) {
         newNode.next = head;
         head = newNode;
      } else {
         Node current = head;
         while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
         }
         newNode.next = current.next;
         current.next = newNode;
      }
      size++;
   }

   public int find(int d) {
      Node current = head;
      int index = 0;
      while (current != null) {
         if (current.data == d) {
            return index;
         }
         current = current.next;
         index++;
      }
      return -1;
   }
   
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



   // ================================= START: TASK 2 ================================
   private int size() { return size; }

   private void add(int[] d) {
      for (int i = 0; i < d.length; i++) {
         add(d[i]);
      }
   }

   private void insert(int[] d) {
      for (int value : d) {
         insert(value);
      }
   }


   // PUBLIC METHODS FOR TESTING
   public int checkSize() {
      return size();
   }

   public void addArray(int[] d) {
      add(d);
   }  

            
   public void insertArray(int[] d) {
      insert(d);
            
   }




   // ================================= START: TASK 3 ================================
   public void q1_rotate_clockwise(int k) {
      if (head == null)
         return;
      k = k % size; // If k is larger than size, rotate only the remainder times
      if (k == 0) return; // If no rotation is needed

      Node newHead = head;
      Node newTail = null;
      for (int i = 0; i < size - k; i++) {
          newTail = newHead;
          newHead = newHead.next;
      }

      // The last node points to the previous head
      Node current = newHead;
      while (current.next != null) {
          current = current.next;
      }
      current.next = head;

      // The previous tail points to null
      newTail.next = null;
      // The head is moved
      head = newHead;
   }

   public void q2_reverse() {
      Node previous = null;
      Node current = head;
      Node next;

      while (current != null) {
          next = current.next;
          current.next = previous;
          previous = current;
          current = next;
      }

      head = previous;
   }

   public void q3_remove_dup() {
      Node current = head;
      while (current != null) {
         Node runner = current;
         while (runner.next != null) {
               if (runner.next.data == current.data) {
                  runner.next = runner.next.next;
               } else {
                  runner = runner.next;
               }
         }
         current = current.next;
      }
   }

   public void q4_increment_digits() {
      Node last = null;
      Node current = head;

      // Find rightmost node not equal to 9
      while (current != null) {
         if (current.data != 9) {
               last = current;
         }
         current = current.next;
      }
      if (last == null) {
         last = new Node(0);
         last.next = head;
         head = last;;
      }

      // Increment the rightmost node not equal to 9
      last.data++;
      last = last.next;

      // Change all the following 9's to 0
      while (last != null) {
          last.data = 0;
          last = last.next;
      }
   }

   public boolean q5_isPalindrome() {
      Node fast = head;
      Node slow = head;

      // Stack for first half elements
      Stack<Integer> stack = new Stack<>();

      while (fast != null && fast.next != null) {
          stack.push(slow.data);
          slow = slow.next;
          fast = fast.next.next;
      }

      // Has odd number of elements, skip the middle one
      if (fast != null) {
          slow = slow.next;
      }

      while (slow != null) {
          int top = stack.pop();
          if (top != slow.data) {
              return false; // Not a palindrome
          }
          slow = slow.next;
      }

      return true; // Is a palindrome
   }


}