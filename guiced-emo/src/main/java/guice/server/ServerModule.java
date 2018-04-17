package guice.server;

import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import guice.server.service.OrderService;
import guice.server.service.PaymentService;
import guice.server.service.PriceService;

import javax.inject.Singleton;

public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);

        //bind(new TypeLiteral<Cache<String, String>>(){}).to(GuiceDemoCache.class).in(Singleton.class);

        bindInterceptor(Matchers.any(),);
    }

    @Provides
    @Singleton
    public Cache<String, String> getCache(){
        return new GuiceDemoCache();
    }
}
