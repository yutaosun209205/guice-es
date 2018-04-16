package guice.server;

import com.google.inject.AbstractModule;
import guice.server.service.OrderService;
import guice.server.service.PaymentService;
import guice.server.service.PriceService;

public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);
    }
}
