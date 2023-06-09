package com.developery.designpattern.templatecallback;

import com.developery.designpattern.strategy.AlarmMyErrorHandler;
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

        MyErrorHandler defaultHandler = new LogMyErrorHandler();
        MyErrorHandler alarmHandler = new AlarmMyErrorHandler();

        MyHttpClient client = new MyHttpClient(defaultHandler);
        ResultDto resultDto = client.request("https://jsonplaceholder.typicode.com/tod1111111os/1");
        log.info("resultDto: {}", resultDto);

        ResultDto resultDto2 = client.request("https://jsonplaceholder.typicode.com/tod1111111os/1");
        log.info("resultDto2: {}", resultDto2);


//        MyErrorHandler handler = new AlarmMyErrorHandler();
//        com.developery.designpattern.strategy.MyHttpClient client = new MyHttpClient(handler);
//        ResultDto resultDto = client.request("https://jsonplaceholder.typicode.com/tod1111111os/1");
//
//        log.info("resultDto: {}", resultDto);



//        MyHttpClient client = new AlarmMyHttpClient();
//        ResultDto resultDto = client.request("https://jsonplaceholder.typicode.com/tod1111111os/1");
//
//        log.info("resultDto: {}", resultDto);
    }
}
