package DP;

import org.junit.Test;

public class Trapping_Rain_Water {

  @Test
  public void testRainWater() {
    int input [] = {7,1,4,0,2,8,6,3,5};
    int area = findRainWater(input);
    System.out.println(area);
  }

  int findRainWater(int[] x) {

    //int x [] = {7,1,4,0,2,8,6,3,5};
    int left = 0;
    int right = x.length-1;

    int leftMax = 0;
    int rightMax = 0;
    int sum = 0;

    while(left < right) {
      int heighLeft = x[left];
      int heightRight = x[right];

      if(heighLeft < heightRight) {
        if(heighLeft >= leftMax) {
          leftMax = heighLeft;
        } else {
          sum = sum + leftMax - heighLeft;
        }
        left++;
      } else {
        if(heightRight >= rightMax) {
          rightMax = heightRight;
        } else {
          sum = sum +rightMax - heightRight;
        }
        right--;
      }

    }
    return sum;
  }

  public int trapRainWater(int[] height) {
    // For each index we will hold max to left of the index
    int leftMax [] = new int [height.length];
    // For each index we will hold max for right of the index.
    int rightMax[] = new int [height.length];
    int leftMaxTemp = 0;
    for (int i = 0; i < height.length; i++) {
      if(leftMaxTemp < height[i]) {
        leftMaxTemp = height[i];
        leftMax[i] =   leftMaxTemp;
      } else {
        leftMax[i] = leftMaxTemp;
      }
    }

    int rightMaxTemp = 0;
    for (int i = height.length -1; i >=0; i-- ) {
      if(rightMaxTemp < height[i]) {
        rightMaxTemp = height[i];
        rightMax[i] =   rightMaxTemp;
      } else {
        rightMax[i] = rightMaxTemp;
      }
    }

    int area = 0;
    // To find area for each index
    for (int j = 0; j<height.length; j++) {
      int leftHeight = leftMax[j];
      int rightHeight = rightMax[j];
      int currentHeight = height[j];
      int minIndex = Math.min(leftHeight, rightHeight);
      if(minIndex - currentHeight > 0) {
        area = area + (minIndex - currentHeight);
      } else {
        area = area + 0;
      }

    }

    return area;
  }
}
