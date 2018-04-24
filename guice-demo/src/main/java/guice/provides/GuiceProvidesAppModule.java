package guice.provides;

import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Provides;

import javax.inject.Singleton;

public class GuiceProvidesAppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GuiceProvidesInject.class)
                .toProvider(new GuiceProvidesProvider()).in(Singleton.class);
    }

//    @Provides
//    public GuiceProvidesInject getGuiceProvidesInject(){
//        return new GuiceProvidesInject();
//    }



}
