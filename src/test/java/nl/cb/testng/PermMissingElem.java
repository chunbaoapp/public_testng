package nl.cb.testng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PermMissingElem {

  @DataProvider(name = "PermMissingElem")
  public Object[][] solutionData() {
    // x,y,d steps
    return new Object[][] {
      {new int[] {}, 1},
      {new int[] {1}, 2},
      {new int[] {2}, 1},
      {new int[] {1, 3}, 2},
      {new int[] {1, 2, 3, 5}, 4},
      {new int[] {1, 2, 4, 3, 5, 7}, 6}
    };
  }

  @Test(dataProvider = "PermMissingElem")
  public void myTest(int[] a, int missing) {
    Assert.assertEquals(missing, solution(a));
  }

  public int solution(int[] a) {
    if (a.length == 0) {
      return 1;
    }
    List<Integer> list = new ArrayList<>(a.length);
    for (int i : a) {
      list.add(i);
    }
    // sort it
    Collections.sort(list);
    //
    for (int i = 0; i < list.size(); i++) {
      if ((i + 1) != list.get(i).intValue()) {
        return i + 1;
      }
    }
    return a.length + 1;
  }
}
