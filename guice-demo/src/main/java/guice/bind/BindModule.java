package guice.bind;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;

import javax.inject.Named;
import java.util.List;

import java.util.Arrays;

public class BindModule extends AbstractModule  {
    @Override
    protected void configure() {
        bind(BindService.class).to(BindServiceImpl.class);
        bind(OutPutService.class).to(OutPutServiceImpl.class);
        bind(new TypeLiteral<List<String>>(){}).toInstance(Arrays.asList("CNY","USD","EUR"));
    }

    @Provides
    @Currencies
    public List<String> getSupportedCurrencies(){
        return Arrays.asList("CNY","USD","EUR");
    }

    @Provides
    @Named("number")
    public long getNumber(){
        return 1000l;
    }
}
