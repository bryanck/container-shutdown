package org.bck.misc;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

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
