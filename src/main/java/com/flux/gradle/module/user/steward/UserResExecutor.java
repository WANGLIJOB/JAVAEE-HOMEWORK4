package com.flux.gradle.module.user.steward;

import com.flux.gradle.frame.redis.Jedis;
import com.flux.gradle.frame.redis.RedisKey;
import com.flux.gradle.frame.request.ReqInfo;
import com.flux.gradle.frame.steward.Steward;
import com.flux.gradle.frame.util.Constants;
import com.flux.gradle.frame.util.ConverterUtils;
import com.flux.gradle.frame.util.LocalDT;
import com.flux.gradle.module.user.entity.UserEntity;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @Author G
 * @Description $end$
 * @Date 2018/10/12 11:04
 **/
public class UserResExecutor {

    public static Mono<? extends ServerResponse> user$getUser(ServerRequest req, ReqInfo reqInfo) {
        String timePatten = LocalDT.getDateTimeAsString(LocalDateTime.now(),"yyyy-MM-dd");

        String name = ConverterUtils.toString(reqInfo.getParams().get("name"));
        String pass = ConverterUtils.toString(reqInfo.getParams().get("password"));
        Map<String, Object> target = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> status = new HashMap<>();
        Long incrId = Steward.getIncrementId();
        UserEntity vo = new UserEntity();
        vo.setId(incrId);
        vo.setName(name);
        vo.setCreateTime(timePatten);
        vo.setPassword(pass);
        Jedis.db0.set(RedisKey.USER_INFO,vo);
        status.put("code", Constants.CODE_OK);
        status.put("message", Constants.MSG_OK);
        status.put("systemTime", timePatten);
        target.put("result", result);
        target.put("status", status);

        return ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(fromPublisher(Mono.just(target),Map.class));
    }
}
