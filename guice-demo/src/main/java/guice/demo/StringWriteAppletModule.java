package guice.demo;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;

import java.io.PrintStream;

public class StringWriteAppletModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWriteApplet.class);
        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
        bind(String.class).annotatedWith(Output.class).toInstance("Hello World");
//        bind(String.class).toProvider(new Provider<String>() {
//            @Override
//            public String get() {
//                return "Hello World";
//            }
//        });
    }

//    @Provides
//    private String getString(){
//        return "Hello World";
//    }
}
