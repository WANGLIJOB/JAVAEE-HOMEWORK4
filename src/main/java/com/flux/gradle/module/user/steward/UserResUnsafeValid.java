package com.flux.gradle.module.user.steward;

import com.flux.gradle.frame.request.ReqInfo;
import com.flux.gradle.frame.response.ResResult;
import org.springframework.web.reactive.function.server.ServerRequest;

/**
 * @Author G
 * @Description 处理验证$
 * @Date 2018/10/12 10:40
 **/
public class UserResUnsafeValid {

    public static boolean user$getUser(ServerRequest req, ReqInfo reqInfo) {
        return ResResult.hasResErr(req);
    }
}
