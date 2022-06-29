package com.example.trainingproject.Configrations;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MultiMapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfigrations {

    @Bean
    public Config testCacheConfig(){

        return  new Config()
                .setInstanceName("hazel-instance")
                .addMapConfig(new MapConfig().setName("test-cache").setTimeToLiveSeconds(600)
                );
    }
    @Bean
    public Config devCacheConfig(){

        return  new Config()
                .setInstanceName("hazel-instance")
                .addMapConfig(new MapConfig().setName("dev-cache").setTimeToLiveSeconds(3600)
                );
    }

}

