package guice.bind;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public class BindServiceImpl implements BindService {

    private final OutPutService outPutService;
    private final List<String> supportedCurrencies;

    @Inject
    @Named("number")
    private long number;

    @Inject
    public BindServiceImpl(OutPutService outPutService, @Currencies List<String> supportedCurrencies) {
        this.outPutService = outPutService;
        this.supportedCurrencies = supportedCurrencies;
    }

    @Override
    public void bind() {
        outPutService.write();
        System.out.println(supportedCurrencies.toString());
        System.out.println(number);
    }
}
