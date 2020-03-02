package br.pegz.tvp.security.configuration;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

import static java.util.Arrays.asList;

@EnableCaching
@Configuration
public class CachingConfiguration implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(asList("publicKey", "privateKey"));
        cacheManager.setAllowNullValues(false);
    }

}
