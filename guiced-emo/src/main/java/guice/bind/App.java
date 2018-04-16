package guice.bind;

import com.google.inject.Guice;

public class App {
    public static void main(String[] args) {
        Guice.createInjector(new BindModule()).getInstance(BindService.class).bind();
    }
}
