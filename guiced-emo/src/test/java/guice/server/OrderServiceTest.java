package guice.server;

import com.google.inject.Guice;
import com.google.inject.Inject;
import guice.server.service.OrderService;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceTest {

    @Inject
    private OrderService orderService;

    @Before
    public void setUp(){
        Guice.createInjector(new ServerModule()).injectMembers(this);
    }

    @Test
    public void testSendToPayment(){
        //OrderService orderService = Guice.createInjector(new ServerModule()).getInstance(OrderService.class);
        orderService.sendToPayment(789L);
    }
}
