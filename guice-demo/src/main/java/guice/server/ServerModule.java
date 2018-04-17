package guice.server;

import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.matcher.Matchers;
import guice.server.annotations.Logged;
import guice.server.annotations.SessionId;
import guice.server.interceptors.LoggingMethodInterceptor;
import guice.server.service.OrderService;
import guice.server.service.PaymentService;
import guice.server.service.PriceService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.inject.Singleton;
import java.lang.reflect.Method;

public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);

        //bind(new TypeLiteral<Cache<String, String>>(){}).to(GuiceDemoCache.class).in(Singleton.class);

        /*bindInterceptor(Matchers.any(), Matchers.annotatedWith(Logged.class), new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Method method = invocation.getMethod();
                System.out.println(String.format("Calling %s#%s(%s)",
                        method.getDeclaringClass().getName(),
                        method.getName(),
                        Joiner.on(",").join(invocation.getArguments())));
                return invocation.proceed();
            }
        });*/

        LoggingMethodInterceptor loggingMethodInterceptor = new LoggingMethodInterceptor();
        // 注入 SessionID
        requestInjection(loggingMethodInterceptor);
        bindInterceptor(Matchers.any(),Matchers.annotatedWith(Logged.class),loggingMethodInterceptor);
    }

    @Provides
    @Singleton
    public Cache<String, String> getCache(){
        return new GuiceDemoCache();
    }

    @Provides
    @SessionId
    public Long generateSessionId(){
        return System.currentTimeMillis();
    }
}
