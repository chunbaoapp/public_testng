package nl.cb.testng;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MaxProductOfThree {
  /*
  A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

  For example, array A such that:

    A[0] = -3
    A[1] = 1
    A[2] = 2
    A[3] = -2
    A[4] = 5
    A[5] = 6
  contains the following example triplets:

  (0, 1, 2), product is −3 * 1 * 2 = −6
  (1, 2, 4), product is 1 * 2 * 5 = 10
  (2, 4, 5), product is 2 * 5 * 6 = 60
  Your goal is to find the maximal product of any triplet.

  Write a function:

  class Solution { public int solution(int[] A); }

  that, given a non-empty array A, returns the value of the maximal product of any triplet.

  For example, given array A such that:

    A[0] = -3
    A[1] = 1
    A[2] = 2
    A[3] = -2
    A[4] = 5
    A[5] = 6
  the function should return 60, as the product of triplet (2, 4, 5) is maximal.

  Write an efficient algorithm for the following assumptions:

  N is an integer within the range [3..100,000];
  each element of array A is an integer within the range [−1,000..1,000].
      */
  public int solution(int[] A) {
    // convert to list
    List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
    // sort it
    Collections.sort(list);
    //
    int[] selected = new int[4];
    for (int i = 0; i < selected.length; i++) {
      // find the biggest number
      int j = Math.abs(list.get(0)) > Math.abs(list.get(list.size() - 1)) ? 0 : list.size() - 1;
      selected[i] = list.get(j);
      // remove it
      list.remove(j);
    }
    return triplet(selected);
  }

  private int triplet(int[] A) {
    return Math.max(A[0] * A[1] * A[2], Math.max(A[0] * A[1] * A[3], A[1] * A[2] * A[3]));
  }

  public int solutionFailed(int[] A) {
    return Arrays.stream(A).distinct().boxed().collect(Collectors.toList()).size();
  }

  @DataProvider(name = "MaxProductOfThree")
  public Object[][] solutionData() {
    //
    return new Object[][] {
      {new int[] {-3, 1, 2, -2, 5, 6}, 60},
      {new int[] {-3, 1, 2, -2, 5, -6}, 90},
      {new int[] {-3, 1, 2, -2, -5, -6}, 60}
    };
  }

  @Test(dataProvider = "MaxProductOfThree")
  public void myTest(int[] A, int distinctSum) {
    Assert.assertEquals(distinctSum, solution(A));
  }
}
