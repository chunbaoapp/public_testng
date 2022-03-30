package nl.cb.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FrogJmp {
  @DataProvider(name = "FrogJmp")
  public Object[][] solutionData() {
    // x,y,d steps
    return new Object[][] {
      {1, 1, 1, 0}, {1, 10, 3, 3}, {10, 10, 1, 0}, {10, 11, 10, 1}, {10, 11, 1, 1}
    };
  }

  @Test(dataProvider = "FrogJmp")
  public void myTest(int x, int y, int d, int steps) {
    Assert.assertEquals(steps, solution2(x, y, d));
  }

  public int solution(int x, int y, int d) {
    return ((y - x) / d) + ((y - x) % d == 0 ? 0 : 1);
  }

  public int solution2(int x, int y, int d) {
    int distance = y - x;
    return (distance % d == 0 ? 0 : 1) + distance / d;
  }
}
