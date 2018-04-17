package guice.scope;

import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;

import javax.inject.Singleton;

public class GuiceDemoCacheModule extends AbstractModule {
    @Override
    protected void configure() {
        //bind(new TypeLiteral<Cache<String, String>>(){}).to(GuiceDemoCache.class);
        //不需要在GuiceDemoCache类中声明 @Singleton
        //bind(new TypeLiteral<Cache<String, String>>(){}).to(GuiceDemoCache.class).in(Singleton.class);
    }

    @Provides
    @Singleton   //同样实现 cache 单例，全局唯一
    public Cache<String, String> getCache(){
        return new GuiceDemoCache();
    }
}
