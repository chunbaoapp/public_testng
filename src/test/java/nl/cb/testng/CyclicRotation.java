package nl.cb.testng;

import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CyclicRotation {
  @DataProvider(name = "CyclicRotation")
  public Object[][] solutionData() {
    return new Object[][] {
      {new int[] {}, 1, new int[] {}},
      {new int[] {1, 2, 3, 4}, 4, new int[] {1, 2, 3, 4}},
      {new int[] {1, 2, 3, 4}, 3, new int[] {2, 3, 4, 1}},
      {new int[] {1, 2, 3, 4}, 0, new int[] {1, 2, 3, 4}},
      {new int[] {0, 0, 0, 0}, 100, new int[] {0, 0, 0, 0}},
      {new int[] {0, 0, 0, 0}, 0, new int[] {0, 0, 0, 0}}
    };
  }

  @DataProvider(name = "Index")
  public Object[][] indexData() {
    // size, k, i, result
    return new Object[][] {
      {0, 0, 0, 0}, {1, 1, 0, 0}, {1, 5, 0, 0}, {2, 1, 0, 1}, {2, 2, 0, 0}, {3, 4, 1, 2}
    };
  }

  @Test(dataProvider = "CyclicRotation")
  public void myTest(int[] array, int k, int[] result) {
    Assert.assertEquals(result, solution(array, k));
  }

  @Test(dataProvider = "Index")
  public void testIndex(int size, int k, int i, int result) {
    Assert.assertEquals(result, getRotateIndex(size, k, i));
  }

  public int[] solution(int[] array, int k) {
    int[] copiedArray = Arrays.copyOf(array, array.length);
    for (int i = 0; i < array.length; i++) {
      copiedArray[getRotateIndex(array.length, k, i)] = array[i];
    }
    return copiedArray;
  }

  private int getRotateIndex(int size, int k, int i) {
    return size == 0 ? 0 : (i + k) % size;
  }
}
