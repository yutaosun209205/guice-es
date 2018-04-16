package guice.server.service;

public interface OrderService {
    void sendToPayment(long orderId);
}

