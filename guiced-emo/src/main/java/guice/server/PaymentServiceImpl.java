package guice.server;

import com.google.common.cache.Cache;
import guice.server.service.PaymentService;

import javax.inject.Inject;

public class PaymentServiceImpl implements PaymentService {

    private final Cache<String, String> cache ;

    @Inject
    public PaymentServiceImpl(Cache<String, String> cache) {
        super();
        this.cache = cache;
    }

    @Override
    @Logged
    public void pay(long orderId, long price, Long sessionId) {

    }

    void putCache(String key, String value){
        cache.put(key, value);
    }
}
