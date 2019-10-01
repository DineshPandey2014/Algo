package TestCode;

public class FindPivot {

  public int findPivot(int nums[]) {
    int leftSum = 0;
    int totalSum = 0;

    for(int i = 0; i < nums.length; i++) {
      totalSum = totalSum + nums[i];
    }

    for(int i = 0; i < nums.length; i++) {
      if(leftSum == totalSum - leftSum - nums[i]) {
        return i;
      } else {
        leftSum = leftSum + nums[i];
      }
    }
    return -1;
  }
}
