package com.developery.designpattern.chain;

import com.developery.designpattern.strategy.MyErrorHandler;
import com.developery.designpattern.templatemethod.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class MyHttpClient implements HttpClient {

    private final MyErrorHandler handler;

    public MyHttpClient(MyErrorHandler handler) {
        this.handler = handler;
    }
//    abstract boolean errorHandle(Exception e);

    @Override
    public ResultDto request(String url) {
        log.info("request. url: {}", url);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

            String body = responseEntity.getBody();


            ResultDto resultDto = new ResultDto();
            resultDto.setSuccess(true);
            resultDto.setBody(body);
            return resultDto;

        } catch (Exception e) {
            boolean throwException = handler.errorHandle(e);
            if (throwException)
                throw e;


            ResultDto resultDto = new ResultDto();
            resultDto.setSuccess(false);
            resultDto.setBody(null);
            return resultDto;
        }
    }
}
