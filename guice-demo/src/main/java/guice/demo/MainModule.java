package guice.demo;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;

import java.io.PrintStream;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new StringWriteAppletModule());
    }
}
