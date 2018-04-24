package guice.provides;

import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.inject.Inject;
import javax.inject.Provider;

public class GuiceProvidesApp {

    private final Provider<GuiceProvidesInject> provider;

    @Inject
    public GuiceProvidesApp(Provider<GuiceProvidesInject> provider) {
        this.provider = provider;
    }

    public Provider<GuiceProvidesInject> getProvider(){
        return this.provider;
    }

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new GuiceProvidesAppModule());


        GuiceProvidesApp guiceProvidesApp = injector.getInstance(GuiceProvidesApp.class);

        for(int i = 0; i < 5 ; i++){
            guiceProvidesApp.getProvider().get();
        }
    }
}
