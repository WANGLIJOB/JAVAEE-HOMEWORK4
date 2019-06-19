package com.flux.gradle.module.user.steward;


import com.flux.gradle.frame.request.ReqInfo;
import com.flux.gradle.frame.response.ResInfo;
import com.flux.gradle.frame.response.ResResult;
import com.flux.gradle.frame.steward.Steward;
import com.flux.gradle.module.user.domain.UserCondition;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author G
 * @Description 分发不同的方法处理业务$
 * @Date 2018/10/11 18:10
 **/
public class UserResponse {

    public static Mono<ServerResponse> user(ServerRequest req){
        return req.bodyToMono(UserCondition.class).flatMap(condition -> {
            ReqInfo reqInfo = Steward.reqInfo(condition.getData());
            String method = reqInfo.getMethod();
            switch (method){
                case "getUser" :
                    return UserResController.user$getUser(req,reqInfo);
            }
            return ResResult.error(req, ResInfo.builder().theme(ResResult.UN_SAFE_VALID).description(ResResult.ILLEGAL_PARAM).build());
        });
    }
}
