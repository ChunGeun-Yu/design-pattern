package com.developery.designpattern.strategy;

import com.developery.designpattern.templatemethod.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

//@Component
@Slf4j
public class App {


    @EventListener(ApplicationReadyEvent.class)
    public void ready() {

        MyErrorHandler handler = new AlarmMyErrorHandler();
        MyHttpClient client = new MyHttpClient(handler);
        ResultDto resultDto = client.request("https://jsonplaceholder.typicode.com/tod1111111os/1");

        log.info("resultDto: {}", resultDto);



//        MyHttpClient client = new AlarmMyHttpClient();
//        ResultDto resultDto = client.request("https://jsonplaceholder.typicode.com/tod1111111os/1");
//
//        log.info("resultDto: {}", resultDto);
    }
}
