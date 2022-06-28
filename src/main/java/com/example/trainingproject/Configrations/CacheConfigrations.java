package com.example.trainingproject.Configrations;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfigrations {

    @Bean
    public Config customerCacheConfig(){

         return  new Config()
                 .setInstanceName("hazel-instance")
                 .addMapConfig(new MapConfig().setName("customer-cache")
                         .setTimeToLiveSeconds(600)
                         // 10 mins
                 );
    }
    @Bean
    public Config carCacheConfig(){

        return  new Config()
                .setInstanceName("hazel-instance")
                .addMapConfig(new MapConfig().setName("car-cache")
                                .setTimeToLiveSeconds(600)
                        // 10 mins
                );
    }
    @Bean
    public Config driverCacheConfig(){

        return  new Config()
                .setInstanceName("hazel-instance")
                .addMapConfig(new MapConfig().setName("driver-cache")
                                .setTimeToLiveSeconds(600)
                        // 10 mins
                );
    }
    @Bean
    public Config packageCacheConfig(){

        return  new Config()
                .setInstanceName("hazel-instance")
                .addMapConfig(new MapConfig().setName("package-cache")
                                .setTimeToLiveSeconds(600)
                        // 10 mins
                );
    }
    @Bean
    public Config productCacheConfig(){

        return  new Config()
                .setInstanceName("hazel-instance")
                .addMapConfig(new MapConfig().setName("product-cache")
                                .setTimeToLiveSeconds(600)
                        // 10 mins
                );
    }

}

