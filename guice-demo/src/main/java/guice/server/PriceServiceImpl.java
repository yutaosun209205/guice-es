package guice.server;

import com.google.common.cache.Cache;
import guice.server.service.PriceService;

import javax.inject.Inject;

public class PriceServiceImpl implements PriceService {

    private final Cache<String, String> cache;

    @Inject
    public PriceServiceImpl(Cache<String, String> cache) {
        super();
        this.cache = cache;
    }

    @Override
    public long getPrice() {
        return 456l;
    }

    String getCacheValue(String key){
        return cache.getIfPresent(key);
    }
}
