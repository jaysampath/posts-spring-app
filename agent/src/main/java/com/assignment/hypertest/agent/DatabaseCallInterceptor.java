package com.assignment.hypertest.agent;

import net.bytebuddy.asm.Advice;

import java.util.Arrays;

public class DatabaseCallInterceptor {
//    @Advice.OnMethodEnter
//    static void invokeBeforeEnterMethod(
//            @Advice.Origin String method, @Advice.Argument(0) Object argument) {
//        System.out.println("Method invoked before enter method by: " + method);
//        System.out.println("Method invoked before enter method with paramater : " + argument);
//    }
//
//    @Advice.OnMethodExit
//    static void invokeAfterExitMethod(
//            @Advice.Origin String method,
//            @Advice.Return Object returned
//    ) {
//        System.out.println("Method " + method + " returned " + returned);
//    }
@Advice.OnMethodExit
public static void getParametrs(@Advice.Origin String method, @Advice.AllArguments Object[] para) throws Exception {

    System.out.println("Inside Advice, method- " + method);
    System.out.println("Inside Advice, para-" + Arrays.toString(para));


}
}
