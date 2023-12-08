package a.code5;

import java.util.Arrays;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.Collections;


public class Main {
  
    public static void main(String[] args) {
        ex0();
        demo1();
        demo2();
        demo4();
        demo5();
    }

    static void ex0() {
        System.out.println("-ex0---");
        int[] arr = {7, 3, 1, 9, 6, 8, 4, 2, 5};
        println(Arrays.toString(arr));
        Arrays.sort(arr);
        println(Arrays.toString(arr));
    }

    static void demo1() {
        println("-demo1---");
        SillyLuckyNumber[] arr = {
            new SillyLuckyNumber("Terrier"),
            new SillyLuckyNumber("Jack"),
            new SillyLuckyNumber("Pom"),
            new SillyLuckyNumber("Beagle")
        };
        println(Arrays.toString(arr));

        Comparator<SillyLuckyNumber> engine = 
            (o1, o2) -> Integer.compare(o1.getLuckyNumber(), o2.getLuckyNumber());

        Arrays.sort(arr, engine);
        println(Arrays.toString(arr));
    }

    // static void demo2() {
    //   println("-demo2----");
    //   ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
    //       new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
    //       new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
    //   println(list.toString());

    //   Collections.sort(list, Comparator.comparing(SillyLuckyNumber::getLuckyNumber));

    //   println(list.toString());
    // }

    static void demo2() {
      println("-demo2----");
      ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
          new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
          new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
      println(list.toString());

      list.sort(Comparator.comparing(SillyLuckyNumber::getLuckyNumber));

      println(list.toString());

      // demo shallow copy
      ArrayList<SillyLuckyNumber> anotherList = new ArrayList<>(list.subList(0, list.size()));
      anotherList.get(0).setBreed("newBreed"); // modifies the breed of Terrier
      println(list.toString()); // notice how Terrier in the list is also affected
    }

    static void demo4() {
      println("-demo4----");
      MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
      arr.add(new SillyLuckyNumber("Terrier"));
      arr.add(new SillyLuckyNumber("Jack"));
      arr.add(new SillyLuckyNumber("Pom"));
      arr.add(new SillyLuckyNumber("Beagle"));
      println(arr.toString());
      arr.swap(1, 3);
      println(arr.toString());
    }

    static void demo5() {
      System.out.println("-demo5----");
      MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
      arr.add(new SillyLuckyNumber("Terrier"));
      arr.add(new SillyLuckyNumber("Jack"));
      arr.add(new SillyLuckyNumber("Pom"));
      arr.add(new SillyLuckyNumber("Beagle"));
      arr.add(new SillyLuckyNumber("Cocker Spaniel"));
      arr.add(new SillyLuckyNumber("Basenji"));
      System.out.println(arr);
      selectionSort(arr);
      System.out.println(arr);
    }

    public static void selectionSort(MyArrDemo<SillyLuckyNumber> arr) {
      int n = arr.currentSize();

      for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
          if (arr.get(j).getLuckyNumber() < arr.get(minIndex).getLuckyNumber()) {
            minIndex = j;
          }
        }
        arr.swap(i, minIndex);
      }
    }

    
    static void println(String message) {
        System.out.println(message);
    }
}
