package com.developery.designpattern.chain;

import com.developery.designpattern.strategy.LogMyErrorHandler;
import com.developery.designpattern.strategy.MyErrorHandler;
import com.developery.designpattern.templatemethod.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class App {


    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        MyErrorHandler handler = new LogMyErrorHandler();

        HttpClient client = new FilterHttpClient(new LogHttpClient(new CacheHttpClient(new MyHttpClient(handler))));

        //////////////////////////////////////////


        ResultDto resultDto = client.request("http://jsonplaceholder.typicode.com/todos/1");
        log.info("resultDto: {}", resultDto);

        ResultDto resultDto2 = client.request("http://jsonplaceholder.typicode.com/todos/1");
        log.info("resultDto2: {}", resultDto2);

    }
}
