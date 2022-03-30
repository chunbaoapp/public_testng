package nl.cb.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jFail {
  private static final Logger LOG = LogManager.getLogger(Log4jFail.class);

  public static void main(String[] args) {
    String str = "${jndi:http://localhost/AAAA/BBBB}";
    LOG.error("test me:{}", str);
  }
}
