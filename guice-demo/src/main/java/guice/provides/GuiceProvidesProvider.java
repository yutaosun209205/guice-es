package guice.provides;

import javax.inject.Provider;

public class GuiceProvidesProvider implements Provider {
    @Override
    public Object get() {
        return new GuiceProvidesInject();
    }
}
