package code;

public class MyStackA_65011338 {

   int MAX_SIZE = 100;
   double stack[] = new double[MAX_SIZE];
   int top = 0;

   // ============ Check if stack is full or empty ============

   public boolean isFull() { 
      return top == MAX_SIZE;
   }

   public boolean isEmpty() {
      return top == 0;
   }


   // ============ Stack operations ============
   
   public void push(double d) {
      if (isFull()) {
         System.out.println("Stack is full, cannot push");
         return;
      }
      stack[top++] = d;
   }

   public double pop() {
      if (isEmpty()) {
         System.out.println("Stack is empty, cannot pop");
         return -1;
      }
      return stack[--top];
   }

   public double top() {
      if (isEmpty()) {
         System.out.println("Stack is empty, no top element");
         return -1;
      }
      return stack[top - 1];
   }

   

   @Override 
   public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append("top ->");

      for (int i = top - 1; i >= 0; i--) {
         sb.append("[");
         sb.append(stack[i]);
         sb.append("] ->");
      }

      sb.append("bottom");
      return new String(sb);
   }
}