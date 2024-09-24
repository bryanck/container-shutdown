package org.bck.misc;

import io.lettuce.core.ClientOptions;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MainTestConfig {

// uncomment this to disable auto reconnect to allow test to complete faster...
//  @Bean
//  public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer() {
//    return builder -> {
//      ClientOptions clientOptions =
//          builder.build().getClientOptions().orElse(ClientOptions.create())
//              .mutate()
//              .autoReconnect(false)
//              .build();
//
//      builder.clientOptions(clientOptions);
//    };
//  }
}
