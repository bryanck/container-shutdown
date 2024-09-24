package org.bck.misc;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

// for Spring 2.7...
import javax.annotation.PreDestroy;
// for Spring 3.3...
//import jakarta.annotation.PreDestroy;

@Component
public class RedisDao {

  private final RedisTemplate<String, String> redis;

  @Autowired
  public RedisDao(RedisTemplate<String, String> redis) {
    this.redis = redis;
  }

  public void doIt() {
    redis.opsForValue().set("key", "value");
  }

  @PreDestroy
  @SneakyThrows
  public void destroy() {
    Thread.sleep(1000);
    redis.delete("key");
  }
}
