package com.assignment.hypertest.app.PostApplication.agent;

import net.bytebuddy.asm.Advice;

public class DatabaseCallInterceptor {
    @Advice.OnMethodEnter
    static void invokeBeforeEnterMethod(
            @Advice.Origin String method, @Advice.Argument(0) String argument) {
        System.out.println("Method invoked before enter method by: " + method);
        System.out.println("Method invoked before enter method with paramater : " + argument);
    }

    @Advice.OnMethodExit
    static void invokeAfterExitMethod(
            @Advice.Origin String method,
            @Advice.Return Object returned
    ) {
        System.out.println("Method " + method + " returned " + returned);
    }
}
