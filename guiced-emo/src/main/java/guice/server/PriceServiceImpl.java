package guice.server;

import guice.server.service.PriceService;

public class PriceServiceImpl implements PriceService {
    @Override
    public long getPrice() {
        return 456l;
    }
}
