package com.flux.gradle.module.user.steward;

import com.flux.gradle.frame.request.ReqInfo;
import com.flux.gradle.frame.response.ResInfo;
import com.flux.gradle.frame.response.ResResult;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author G
 * @Description 控制层处理数据验证$
 * @Date 2018/10/12 10:29
 **/
public class UserResController {

    public static Mono<? extends ServerResponse> user$getUser(ServerRequest req, ReqInfo reqInfo) {
        if (UserResUnsafeValid.user$getUser(req, reqInfo)) {
            return ResResult.error(req, ResInfo.builder().theme(ResResult.UN_SAFE_VALID).description(ResResult.ILLEGAL_PARAM).build());
        } else {
            return UserResExecutor.user$getUser(req, reqInfo);
        }
    }

}
