package com.flux.gradle.frame.response;


import com.flux.gradle.frame.steward.Steward;
import com.flux.gradle.frame.util.LocalDT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @Author G
 * @Description 返回结果$
 * @Date 2018/10/12 9:34
 **/
@Slf4j
public class ResResult {
    public static final String RES_INFO = ResInfo.ResInfoBuilder.class.getName();
    public static final String UN_SAFE_VALID = "unSafeValid";
    public static final String ILLEGAL_PARAM = "illegal parameter";

    public static <T> T attribute(ServerRequest req, String attributeKey){
        return (T) req.attribute(attributeKey).get();
    }

    public  static ResInfo resInfo(ServerRequest req){
        ResInfo resInfo = attribute(req, ResResult.RES_INFO);
        return resInfo;
    }

    public static Map<String, Object> resDetail(ServerRequest req) {
        return ResResult.resInfo(req).getDetail();
    }

    public static boolean hasResErr(ServerRequest req) {
        log.info(ResResult.class.getSimpleName());
        return resDetail(req).keySet().stream().filter(key -> !key.equals(ResResult.class.getSimpleName())).count() > 0;
    }

    public static Mono<ServerResponse> success(ServerRequest req, ResInfo source){
        source.setMessage("success");
        source.setCode(HttpStatus.OK.value());
        return resMono(req,source,ok());
    }

    public static Mono<ServerResponse> fail(ServerRequest req, ResInfo source){
        source.setMessage("fail");
        source.setCode(HttpStatus.BAD_REQUEST.value());
        return resMono(req, source, badRequest());
    }

    public static Mono<ServerResponse> error(ServerRequest req, ResInfo source){
        source.setMessage("error");
        source.setCode(HttpStatus.BAD_REQUEST.value());
        return resMono(req,source,badRequest());
    }

    private static Mono<ServerResponse> resMono(ServerRequest req, ResInfo source, ServerResponse.BodyBuilder bodyBuilder) {
        ResInfo target = resInfo(req);
        Steward.merge(source, target);
        ResInfoResResultDetail detail = ((ResInfoResResultDetail) target.getDetail().get(ResResult.class.getSimpleName()));
        detail.setResTimestamp(System.currentTimeMillis());
        detail.setDuration(detail.getResTimestamp() - detail.getReqTimestamp());
        target.setTimestamp(LocalDT.getDateTimeOfTimestamp(detail.getResTimestamp()).toString());
        return bodyBuilder.contentType(APPLICATION_JSON_UTF8)
                .body(fromPublisher(Mono.just(target), ResInfo.class));
    }
}
