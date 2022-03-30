package nl.cb.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Log4jFailTest {

  private static final Logger LOG = LogManager.getLogger(Log4jFailTest.class);

  @Test
  public void testLog() {
    String str = "${jndi:http://localhost/AAAA/BBBB}";
    LOG.error("test me:{}", str);
  }

  @Test
  public void testFormat() {
    Assert.assertEquals("ZZZ00123", byPaddingZeros(123, 5));
    Assert.assertEquals("ZZZ01234", byPaddingZeros(1234, 5));
    Assert.assertEquals("ZZZ12345", byPaddingZeros(12345, 5));
    Assert.assertEquals("ZZZ123456", byPaddingZeros(123456, 5));
  }

  private String byPaddingZeros(int value, int paddingLength) {
    return String.format("ZZZ%0" + paddingLength + "d", value);
  }
}
