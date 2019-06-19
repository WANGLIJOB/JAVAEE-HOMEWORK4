package com.flux.gradle;

import com.flux.gradle.module.UserHandler;
import com.flux.gradle.module.UserRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;

/**
 * @Description root路由$
 **/
@Configuration
@Order(1)
public class BusinessRouter {

    private static final String USER = "/user";

    @Bean
   RouterFunction<ServerResponse> userRouter(UserHandler handler){
       return RouterFunctions.nest(path(USER), UserRouter.funs(handler));
   }
}
