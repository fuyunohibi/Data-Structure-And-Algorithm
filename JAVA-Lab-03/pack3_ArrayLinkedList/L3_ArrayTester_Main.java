import code.MyArrayBasic;

class L3_ArrayTester_Main {
   public static void main(String[] args) {
      println("-demo1-------");
      arrayBasic_demo1();
      println("-demo2-------");
      arrayBasic_demo2();
      println("-demo3-------");
      arrayBasic_demo3();
   }

   public static void println(String text) {
      System.out.println(text);
   }

   static private void arrayBasic_demo1() {
       MyArrayBasic demo = new MyArrayBasic(7, 6, 8, 1, 2, 3);
       println(demo.toString());
   }

   static private void arrayBasic_demo2() {
      MyArrayBasic demo = new MyArrayBasic();
      demo.insert(9, 0);
      demo.insert(7, 0);
      demo.insert(5, 0);
      println(demo.toString());
      println("5 is at " + demo.find(5));
      println("5 is at " + demo.binarySearch(5));
      demo.delete(1);
      println(demo.toString());
   }

   static private void arrayBasic_demo3() {
      MyArrayBasic demo = new MyArrayBasic();
      demo.add(3);
      demo.add(7);
      demo.add(5);
      demo.add(4);
      demo.add(6);
      // index out of bound due to overflow
      demo.add(1);
      println(demo.toString());
   }
}
