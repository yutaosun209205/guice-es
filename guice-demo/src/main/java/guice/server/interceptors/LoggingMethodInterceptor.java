package guice.server.interceptors;

import com.google.common.base.Joiner;
import guice.server.annotations.SessionId;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.inject.Inject;
import javax.inject.Provider;
import java.lang.reflect.Method;

public class LoggingMethodInterceptor implements MethodInterceptor {

    @Inject
    @SessionId
    private Provider<Long> sessionIdProvider ;
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        System.out.println(String.format("In Session %d : Calling %s#%s(%s)",
                sessionIdProvider.get(),
                method.getDeclaringClass().getName(),
                method.getName(),
                Joiner.on(",").join(invocation.getArguments())));
        return invocation.proceed();
    }
}
