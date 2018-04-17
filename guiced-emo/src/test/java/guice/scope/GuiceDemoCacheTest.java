package guice.scope;

import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuiceDemoCacheTest {

    @Inject
    private GuiceDemoCacheServiceImpl guiceDemoCacheService;
    @Inject
    private GuiceDemoCachePriceServcieImpl guiceDemoCachePriceServcie;
    @Before
    public void setUp(){
        Guice.createInjector(new GuiceDemoCacheModule()).injectMembers(this);
    }

    @Test
    public void testGuiceDemoCache(){
        guiceDemoCacheService.putCache("testKey","testValue");
        String cacheValue = guiceDemoCachePriceServcie.getCacheValue("testKey");
        assertEquals("testValue", cacheValue);
    }
}
