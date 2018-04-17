package guice.scope;

import com.google.common.cache.Cache;
import com.google.inject.Inject;

public class GuiceDemoCacheServiceImpl implements GuiceDemoCacheService {

    private final Cache<String, String> cache ;

    @Inject
    public GuiceDemoCacheServiceImpl(Cache<String, String> cache) {
        super();
        this.cache = cache;
    }

    @Override
    public void pay(long orderId) {

    }

    void putCache(String key, String value){
        cache.put(key, value);
    }
}
