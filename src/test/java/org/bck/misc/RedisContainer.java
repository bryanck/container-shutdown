package org.bck.misc;

import org.testcontainers.containers.GenericContainer;

public class RedisContainer {

  private static final int REDIS_CONTAINER_PORT = 6379;
  private static final GenericContainer REDIS_CONTAINER =
      new GenericContainer("redis").withExposedPorts(REDIS_CONTAINER_PORT);

  public static synchronized void start() {
    if (!REDIS_CONTAINER.isRunning()) {
      REDIS_CONTAINER.start();
      String redisHost = REDIS_CONTAINER.getHost();
      String redisPort = String.valueOf(REDIS_CONTAINER.getMappedPort(REDIS_CONTAINER_PORT));
      // Spring 3.3
      System.setProperty("spring.data.redis.host", redisHost);
      System.setProperty("spring.data.redis.port", redisPort);
      // Spring 2.7
      System.setProperty("spring.redis.host", redisHost);
      System.setProperty("spring.redis.port", redisPort);
    }
  }
}
