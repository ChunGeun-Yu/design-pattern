package com.developery.designpattern.proxyclass;

import com.developery.designpattern.strategy.LogMyErrorHandler;
import com.developery.designpattern.strategy.MyErrorHandler;
import com.developery.designpattern.templatemethod.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

//@Component
@Slf4j
public class App {


    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        MyErrorHandler handler = new LogMyErrorHandler();
//        MyHttpClient client = new MyHttpClient(handler);
        MyHttpClient client = new CacheHttpClient(handler);


        //////////////////////////////////////////


        ResultDto resultDto = client.request("https://jsonplaceholder.typicode.com/todos/1");
        log.info("resultDto: {}", resultDto);

        ResultDto resultDto2 = client.request("https://jsonplaceholder.typicode.com/todos/1");
        log.info("resultDto2: {}", resultDto2);

    }
}
