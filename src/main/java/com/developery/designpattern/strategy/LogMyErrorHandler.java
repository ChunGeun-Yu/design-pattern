package com.developery.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogMyErrorHandler implements MyErrorHandler {
    @Override
    public boolean errorHandle(Exception e) {
        log.error("error message: " + e.getMessage());
        return false;
    }
}
