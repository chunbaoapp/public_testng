package nl.cb.testng;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Distinct {

  // the take away is using set to avoid duplicated item

  /*
  Write a function

  class Solution { public int solution(int[] A); }

  that, given an array A consisting of N integers, returns the number of distinct values in array A.

  For example, given array A consisting of six elements such that:

   A[0] = 2    A[1] = 1    A[2] = 1
   A[3] = 2    A[4] = 3    A[5] = 1
  the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

  Write an efficient algorithm for the following assumptions:

  N is an integer within the range [0..100,000];
  each element of array A is an integer within the range [−1,000,000..1,000,000].
    */
  public int solution(int[] A) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < A.length; i++) {
      set.add(A[i]);
    }
    return set.size();
  }

  public int solutionFailed(int[] A) {
    return Arrays.stream(A).distinct().boxed().collect(Collectors.toList()).size();
  }

  @DataProvider(name = "Distinct")
  public Object[][] solutionData() {
    // x,y,d steps
    return new Object[][] {
      {new int[] {9}, 1},
      {new int[] {2, 1, 1, 2, 3, 1}, 3},
      {new int[] {1, 1}, 1}
    };
  }

  @Test(dataProvider = "Distinct")
  public void myTest(int[] A, int distinctSum) {
    Assert.assertEquals(distinctSum, solution(A));
  }
}
