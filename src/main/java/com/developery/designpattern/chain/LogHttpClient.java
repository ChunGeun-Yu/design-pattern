package com.developery.designpattern.chain;

import com.developery.designpattern.templatemethod.ResultDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogHttpClient implements HttpClient {

    private final HttpClient target;

    public LogHttpClient(HttpClient target) {
        this.target = target;
    }


    @Override
    public ResultDto request(String url) {
        long startTime = System.currentTimeMillis();
        log.info("1 request url. {}", url);

        /////////////////////
        ResultDto resultDto = target.request(url);
        //////////////////

        long endTime = System.currentTimeMillis();

        log.info("2 request. elapsedTime: {}ms", endTime-startTime);
        return resultDto;
    }
}
