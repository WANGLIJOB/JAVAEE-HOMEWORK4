package com.flux.gradle.module;

import com.flux.gradle.module.user.steward.UserResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author G
 * @Description 对应方法$
 * @Date 2018/10/11 16:47
 **/
@Component
@Order(0)
public class UserHandler {

    public Mono<ServerResponse> getUser(ServerRequest req){
        return UserResponse.user(req);
    }
}
