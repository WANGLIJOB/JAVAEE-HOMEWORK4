package com.flux.gradle.module;

import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * @Author G
 * @Description 模块路由$
 * @Date 2018/10/11 17:26
 **/
public class UserRouter {

    private static RequestPredicate APPLICATION_JSON_UTF8 = accept(MediaType.APPLICATION_JSON_UTF8);

    public static RouterFunction<ServerResponse> funs(UserHandler handler){
        return RouterFunctions.route(POST("/user!request.action").and(APPLICATION_JSON_UTF8),handler::getUser);
    }
}
