import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lab1_65011338 {


   static void q1() { System.out.println("-q1----");
      List<String> listA = new ArrayList<>(Arrays.asList("lilly","tulip","daisy"));
      List<String> listB = Arrays.asList("pomeranian", "terrier", "jack", "beagle");
      listA.addAll(listB);

      System.out.println(listA); System.out.println(listB);
      System.out.println("=============END OF Q1================\n" );
   }

   static void q2() { System.out.println("-q2----");
      ArrayList<String> listA = new ArrayList<>(Arrays.asList("pomeranian", "terrier", "jack", "beagle"));
      List<String> listB = Arrays.asList("lilly","tulip","daisy");
      ArrayList<String> q1List = null;

      q1List = new ArrayList<>(listB);
      q1List.addAll(listA);

      System.out.println(listA); 
      System.out.println(listB);
      System.out.println(q1List);
      System.out.println("=============END OF Q2================\n");
   }

   static void q3() {
      System.out.println("-q3----");

      ArrayList<Dog> q3List = new ArrayList<>();
      q3List.add(new Dog("jack")); q3List.add(new Dog("terrier"));
      System.out.println("snapshot 1 " + q3List);

      add(q3List, new Dog("pomeranian"));
      System.out.println("snapshot 2 " + q3List);

      add(q3List,new Dog("jack"));
      System.out.println("snapshot 3 " + q3List);

      add(q3List,new Dog("beagle"));

      System.out.println(q3List);

      System.out.println("=============END OF Q3================\n");
      
   }
   
   private static void add(ArrayList<Dog> list, Dog d) {
      if (!list.contains(d)) {
         list.add(d);
      }
   }

   static void q4() {
      System.out.println("-q4----");
      ArrayList<String> listA = new ArrayList<>(Arrays.asList("jack","pomeranian", "terrier", "jack", "beagle"));
      ArrayList<String> listB = removeDuplicates(listA);
      listA = removeDuplicates(listA);
      System.out.println(listA);
      System.out.println(listB);

      System.out.println("=============END OF Q4================\n");
   }
   private static ArrayList<String> removeDuplicates(List<String> list) {
      HashSet<String> set = new HashSet<>(list);
      return new ArrayList<>(set);
   }  



   static void q5() { System.out.println("-q5----");
      List<String> listA = Arrays.asList("pomeranian", "terrier", "jack", "beagle",
      "pomeranian" , "beagle",
      "jack", "beagle");
      HashMap<String,Integer> q5map = new HashMap<>();
      String key;
      for (int i = 0; i < listA.size(); i++) {
         key = listA.get(i);
         q5map.put(key, ((q5map.get(key) == null) ? 1 : q5map.get(key) + 1));
      }
      System.out.println(q5map);
      System.out.println("=============END OF Q5================\n");
   }

   public static void main(String[] args) {
      q1();
      q2();
      q3();
      q4();
      q5();
   }
}


class Dog {
   String name;
   Dog(String name) { 
      this.name = name;
   }

   @Override
   public String toString() { 
      String address = "(" + (Integer.toHexString(this.name.hashCode())) + ")";
      return 
         name + address;
   }

   @Override
   public boolean equals(Object o) {
      if (o instanceof Dog) {
         Dog d = (Dog) o;
         return this.name.equals(d.name);
      }
      return false;
   }
}