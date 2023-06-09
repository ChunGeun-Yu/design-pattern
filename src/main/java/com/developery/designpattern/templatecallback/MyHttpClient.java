package com.developery.designpattern.templatecallback;

import com.developery.designpattern.strategy.MyErrorHandler;
import com.developery.designpattern.templatemethod.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class MyHttpClient {

    private final MyErrorHandler defaultHandler;

    public MyHttpClient(MyErrorHandler defaultHandler) {
        this.defaultHandler = defaultHandler;
    }

    public ResultDto request(String url) {
        return this.request(url, defaultHandler);
    }

    public ResultDto request(String url, MyErrorHandler handler) {
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
