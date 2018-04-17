package guice.server;

import guice.server.annotations.Logged;
import guice.server.service.OrderService;
import guice.server.service.PaymentService;
import guice.server.service.PriceService;

import javax.inject.Inject;

public class OrderServiceImpl implements OrderService {
    private final PriceService priceService;
    private final PaymentService paymentService;
    private final SessionManger sessionManger;

    private Long ordersPaid = 0L;

    @Inject
    public OrderServiceImpl(PriceService priceService, PaymentService paymentService, SessionManger sessionManger) {
        super();
        this.priceService = priceService;
        this.paymentService = paymentService;
        this.sessionManger = sessionManger;
    }

    @Logged
    public void sendToPayment(long orderId){
        long price = priceService.getPrice();
        paymentService.pay(orderId, price, sessionManger.getSessionId());
        ordersPaid += 1;
    }
}
