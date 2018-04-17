package guice.scope;

import com.google.common.cache.Cache;
import com.google.inject.Inject;

public class GuiceDemoCachePriceServcieImpl implements GuiceDemoCachePriceServcie {

    private final Cache<String, String> cache ;

    @Inject
    public GuiceDemoCachePriceServcieImpl(Cache<String, String> cache) {
        super();
        this.cache = cache;
    }

    @Override
    public long price() {
        return 0;
    }

    String getCacheValue(String key){
        return cache.getIfPresent(key);
    }
}
