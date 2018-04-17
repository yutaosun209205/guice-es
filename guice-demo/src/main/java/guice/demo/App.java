package guice.demo;

import com.google.inject.Guice;

public class App {
    public static void main(String[] args) {
        //MyApplet mainApplet = Configuration.getMainApplet();
        MyApplet mainApplet = Guice.createInjector(new MainModule()).getInstance(MyApplet.class);
        mainApplet.run();
    }
}
