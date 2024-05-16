package com.assignment.hypertest.app.PostApplication.agent;




import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.AgentBuilder.Transformer;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class DatabaseCallInterceptorAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(ElementMatchers.is("org.springframework.data.repository.CrudRepository"))
                .transform((builder, typeDescription, classLoader, javaModule, protectionDomain) -> {
                    System.out.println("Inside premain agent");
                    return builder.method(ElementMatchers.is("save")).intercept(Advice.to(DatabaseCallInterceptor.class));
                })
                .installOn(instrumentation);
    }
}
