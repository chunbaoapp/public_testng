package nl.cb.testng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OddOccurrencesInArray {

  @DataProvider(name = "OddOccurrencesInArray")
  public Object[][] solutionData() {
    // x,y,d steps
    return new Object[][] {
      {new int[] {9}, 9},
      {new int[] {9, 7, 7}, 9},
      {new int[] {9, 9, 7}, 7},
      {new int[] {3, 9, 3, 9, 7}, 7},
      {new int[] {3, 9, 1, 1, 444, 444, 234, 234, 3, 9, 7}, 7}
    };
  }

  @Test(dataProvider = "OddOccurrencesInArray")
  public void myTest(int[] a, int odd) {
    Assert.assertEquals(odd, solution(a));
  }

  public int solution(int[] a) {
    List<Integer> list = new ArrayList<>(a.length);
    for (int i : a) {
      list.add(i);
    }
    // sort it
    Collections.sort(list);
    //
    int i = 0;
    while (i < list.size()) {
      // last is the answer
      if (i == list.size() - 1) {
        return list.get(i);
      }
      if (list.get(i).intValue() != list.get(i + 1).intValue()) {
        return list.get(i);
      }
      i = i + 2;
    }
    return -1;
  }
}
