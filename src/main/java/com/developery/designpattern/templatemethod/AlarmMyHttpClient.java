package com.developery.designpattern.templatemethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlarmMyHttpClient extends MyHttpClient {
    @Override
    boolean errorHandle(Exception e) {
        // TODO: send kakao message
        log.error("카카오로 에러 메시지 보냈다고 가정");
        return true;
    }
}
