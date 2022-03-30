package nl.cb.testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class StackBracketsSolutionA {
  @Test
  public void testMe() {
    assertEquals(1, solution("{[(())]}"));
  }

  public int solution(String S) {
    if (S == null && S.length() % 2 != 0) {
      return 0;
    }

    while (hasPair(S)) {
      S = S.replaceAll("\\(\\)", "").replaceAll("\\{\\}", "").replaceAll("\\[\\]", "");
    }

    return S.length() > 0 ? 0 : 1;
  }

  private boolean hasPair(String s) {
    return s.indexOf("()") != -1 || s.indexOf("{}") != -1 || s.indexOf("[]") != -1;
  }
}
