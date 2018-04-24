package guice.provides;

import com.google.inject.BindingAnnotation;

import javax.inject.Singleton;

@Singleton
public class GuiceProvidesInject {
    public GuiceProvidesInject() {
        System.out.println("Hello Guice..");
    }
}
