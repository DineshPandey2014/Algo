package Recursion;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/*
 *  Write a function that takes in an array of unique integers and returns an array an array of all
 *  permutations of those integers. If the input is empty your function should returns an empty array.
 *
 *  Sample Input: [1,2,3]
 *  Sample OutPut: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,2,1], [3,1,2]
 *
 *  Time Complexity : O(!n * n)
 *  Space Complexity: It holds the !n permutations and each element is length of n
 *                    O(!n * n)
 *
 */
public class Find_All_Permuation_Of_String {

  public static void main (String args[]) {
    ArrayList<Integer> array = new ArrayList<>();
    array.add(1);
    array.add(2);
    array.add(3);
    ArrayList<ArrayList<Integer>> output = getAllPermutations(array);
    System.out.println(output);
  }

  public static  ArrayList<ArrayList<Integer>>  getAllPermutations(
          ArrayList<Integer> array) {
    ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
    getPermutations(0, array, permutations);
    return permutations;
  }

  public static void getPermutations(int i, ArrayList<Integer> array,
                                     ArrayList<ArrayList<Integer>> permutations) {
    if(i == array.size()) {
      permutations.add(new ArrayList<Integer> (array) );
    } else {
        for (int j = i; j < array.size(); j++) {
          swap(array, i , j);
          getPermutations(i+1, array, permutations);
          swap(array, i, j);
        }
    }
  }

  public static void swap(ArrayList<Integer> array, int i, int j) {
      Integer tmp = array.get(i);
      array.set(i, array.get(j));
      array.set(j, tmp);
  }

}
