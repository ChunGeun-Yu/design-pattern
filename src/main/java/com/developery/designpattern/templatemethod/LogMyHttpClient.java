package com.developery.designpattern.templatemethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogMyHttpClient extends MyHttpClient {
    @Override
    boolean errorHandle(Exception e) {
        log.error("error message: " + e.getMessage());
        return false;
    }
}
