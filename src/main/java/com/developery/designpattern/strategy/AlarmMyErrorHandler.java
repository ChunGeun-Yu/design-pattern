package com.developery.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlarmMyErrorHandler implements MyErrorHandler {
    @Override
    public boolean errorHandle(Exception e) {
        // TODO: send kakao message
        log.error("카카오로 에러 메시지 보냈다고 가정");
        return true;
    }
}
