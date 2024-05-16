package com.assignment.hypertest.agent;


import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.lang.instrument.Instrumentation;

public class DatabaseCallInterceptorAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) throws Exception {
        System.out.println("Configuring ByteBuddy for apache http client");
        new ByteBuddy()
                .subclass(SimpleJpaRepository.class)
                .method(ElementMatchers.named("save"))
                .intercept(Advice.to(DatabaseCallInterceptor.class))
                .make()
                .load(SimpleJpaRepository.class.getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println("Configured ByteBuddy for apache http client");
    }
}
