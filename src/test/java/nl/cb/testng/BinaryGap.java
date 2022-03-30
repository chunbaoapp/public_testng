package nl.cb.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BinaryGap {
  @DataProvider(name = "BinaryGap")
  public Object[][] solutionData() {
    // x,y,d steps
    return new Object[][] {{9, 2}, {529, 4}, {20, 1}, {15, 0}, {32, 0}, {1041, 5}};
  }

  @Test(dataProvider = "BinaryGap")
  public void myTest(int x, int gap) {
    Assert.assertEquals(gap, solution(x));
  }
  // 1001000100
  public int solution(int x) {
    String binaryString = Integer.toBinaryString(x);
    int gap = 0;
    int startPosition = 0;
    for (int i = 0; i < binaryString.length(); i++) {
      if (binaryString.charAt(i) == '1') {
        int tempGap = i - startPosition - 1;
        gap = Math.max(tempGap, gap);
        startPosition = i;
      }
    }
    return gap;
  }
}
