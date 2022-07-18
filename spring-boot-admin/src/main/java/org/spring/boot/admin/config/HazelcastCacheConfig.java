package org.spring.boot.admin.config;

//@Configuration
//public class HazelcastCacheConfig {
//
//    @Bean
//    public Config hazelcastConfig(){
//       return new Config().setInstanceName("hazelcast-instance")
//                .addMapConfig(new MapConfig().setName("itemCache")
//                .setMaxSizeConfig(new MaxSizeConfig(300,MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
//                .setEvictionPolicy(EvictionPolicy.LRU)
//                .setTimeToLiveSeconds(2000));
//    }
//
//}