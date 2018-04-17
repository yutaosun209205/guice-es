package guice.server;

import com.google.inject.Guice;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

public class GuiceDemoCacheTest {
    @Inject
    private PaymentServiceImpl paymentService;
    @Inject
    private PriceServiceImpl priceService;

    @Before
    public void setUp(){
        Guice.createInjector(new ServerModule()).injectMembers(this);
    }

    @Test
    public void testGuiceCacheScope(){
        paymentService.putCache("testKey","testValue");
        String cacheValue = priceService.getCacheValue("testKey");
        assertEquals("testValue",cacheValue);
    }
}
