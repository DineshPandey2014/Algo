package Heap_Priority_Queue.PriorityQueue_In_Java;

import org.junit.Test;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=oAp4GYprVHM
 *
 * Comparable, Comparator
 *
 *  Difference between Comparable and Comparator
 *
 *  Comparable : compareTo()
 *
 *  1. Default natural sorting order.
 *  2. Present in Java.lang package.
 *  3. Comparable interfaace contains only one method compareTo() method
 *  4. All wrapper classes and String class implements comparable interface
 *     Example : Integer, Double, Float, Long, String,
 *
 *  Comparator : compare()
 *
 *  1. Customized sorting order.
 *  2. Present in java.util package.
 *  3. Contains two methods a) compare() and b) equals method.
 *  4. Implements classes are
 *     Example : Collator, RuleBasedCollator
 *
 *  Question 1. When you will use Comparator interface.When your class is not implementing Comparable interface
 *           2. When Comparable interface is implemented based on some property say price but you want to compare
 *              based on manufacturing type. In that case you will use comparator interface.
 *           3. Comparable interface is based on natural order.
 *           4. COmparator interface you can define your own way or custom way of sorting.
 *
 *  Sort Array using : Arrays.sort();
 *  Sort List using : Collections.sort();
 *
 */
public class Diff_Comparable_Comparator {


  /**
   *  When we need to sort the object which is not implementing any comparable interface.
   *  How to sort the list of object which doesn't implemented Comparable interface.
   *
   *  Here we are sorting the laptop based on price.
   *
   */
  @Test
  public void testHowToSortListOfLapTopOne () {
      LapTop lapTopOne = new LapTop (800, 8, "apple");
      LapTop lapTopTwo = new LapTop (1000, 12, "lenova");
      LapTop lapTopThree = new LapTop (1200, 18, "ibm");

    List<LapTop> list= new ArrayList<>();
    list.add(lapTopThree);
    list.add(lapTopOne);
    list.add(lapTopTwo);

    Collections.sort(list);
  }


  /**
   * Test for Comparator interface.
   *  Here we are sorting the laptop based on price. By Implementing comparable interface.
   *
   */
  @Test
  public void testHowToSortListOfLapTop () {
    LapTopOne lapTopOne = new LapTopOne (1800, 18, "apple");
    LapTopOne lapTopTwo = new LapTopOne (11000, 8, "lenova");
    LapTopOne lapTopThree = new LapTopOne (1300, 14, "ibm");

    List<LapTopOne> list= new ArrayList<>();
    list.add(lapTopThree);
    list.add(lapTopOne);
    list.add(lapTopTwo);

    Comparator<LapTopOne> comparator = new Comparator<LapTopOne> () {
      @Override
       public int compare(LapTopOne l1, LapTopOne l2) {
         if(l1.price > l2.price) {
            return -1;
         } else if(l1.price < l2.price) {
            return 1;
         } else {
           return 0;
         }
       }
    };

    // Sorting based on price.
    // Output lapTopThree, lapTopOne, lapTopTwo
    Collections.sort(list,comparator);
    System.out.println(list); // 1300, 1800, 11000
  }



  /**
   * Test for Comparator interface. Here class is implementing the interface
   *  Here we are sorting the laptop based on ram. By Implementing comparable interface.
   *
   */
  @Test
  public void testHowToSortListOfLapTopThree () {
    LapTopThree lapTopOne = new LapTopThree (1800, 18, "apple");
    LapTopThree lapTopTwo = new LapTopThree (11000, 8, "lenova");
    LapTopThree lapTopThree = new LapTopThree (1300, 14, "ibm");

    List<LapTopThree> list= new ArrayList<>();
    list.add(lapTopThree);
    list.add(lapTopOne);
    list.add(lapTopTwo);



    // Sorting based on price.
    // Output lapTopThree, lapTopOne, lapTopTwo
    Collections.sort(list, new SortByRam());
    System.out.println(list); // 1300, 1800, 11000
  }
}


class LapTop implements Comparable<LapTop> {
  int price;
  int ram;
  String name;

  public LapTop(int price, int ram, String name) {
    this.price = price;
    this.ram = ram;
    this.name = name;
  }


  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(LapTop object) {
   if(this.price - object.price > 0) {
     return 1;
   } else if(this.price - object.price  < 0){
     return -1;
   } else {
     return 0; // If both price is equal
   }
  }
}


class LapTopOne  {
  int price;
  int ram;
  String name;

  public LapTopOne(int price, int ram, String name) {
    this.price = price;
    this.ram = ram;
    this.name = name;
  }


  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}


class LapTopThree {
  int price;
  int ram;
  String name;

  public LapTopThree(int price, int ram, String name) {
    this.price = price;
    this.ram = ram;
    this.name = name;
  }


  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class SortByRam implements Comparator<LapTopThree> {
  @Override
  public int compare(LapTopThree l1, LapTopThree l2) {
    if(l1.ram > l2.ram) {
      return 1;
    } else if(l1.ram < l2.ram) {
      return  -1;
    } else {
      return 0;
    }
  }
}