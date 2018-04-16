package guice.demo;

import com.google.inject.Provider;

public class Configuration {
    public static MyApplet getMainApplet() {
        return new StringWriteApplet(new PrintStreamWriter(System.out), /* new StringProvider(){}*/ new Provider() {
            @Override
            public String get() {
                return "Hello World";
            }
        });
    }
}
