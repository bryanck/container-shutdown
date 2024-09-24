package org.bck.misc;

import lombok.SneakyThrows;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Import(MainTestConfig.class)
@SpringBootTest
public class MainTest {

  @Autowired private RedisDao scheduleJobs;

  @BeforeClass
  public static void beforeAll() {
    RedisContainer.start();
  }

  @Test
  @SneakyThrows
  public void testShutdown() {
    scheduleJobs.doIt();
  }
}
