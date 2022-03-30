package nl.cb.testng;

import static org.testng.Assert.assertEquals;

import java.util.Stack;
import org.testng.annotations.Test;

public class StackBrackets {
  @Test
  public void testMe() {
    assertEquals(1, solution("[{}(())()({})]"));
  }

  public int solution(String S) {
    if (S.length() % 2 != 0) return 0; // all odd numbered strings can't be properly nested

    Stack charStack = new Stack();

    for (int i = 0; i < S.length(); i++) {
      char currentChar = S.charAt(i);
      if (isOpeningBracket(currentChar)) {
        charStack.push(currentChar);
      } else {
        // adding closing bracket to empty stack will never become properly nested
        if (charStack.size() == 0) {
          return 0;
        }
        char poppedChar = (char) charStack.pop();
        if (isBracketMatch(poppedChar, currentChar)) {
          continue;
        } else return 0;
      }
    }
    if (charStack.isEmpty()) return 1;

    return 0;
  }

  boolean isOpeningBracket(char pC) {
    if (pC == '[' || pC == '(' || pC == '{') {
      return true;
    }
    return false;
  }

  boolean isBracketMatch(char pC1, char pC2) {
    if (pC1 == '[' && pC2 == ']') return true;
    if (pC1 == '(' && pC2 == ')') return true;
    if (pC1 == '{' && pC2 == '}') return true;

    return false;
  }
}
