package com.developery.designpattern.templatemethod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public abstract class MyHttpClient {

    abstract boolean errorHandle(Exception e);

    public ResultDto request(String url) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

            String body = responseEntity.getBody();


            ResultDto resultDto = new ResultDto();
            resultDto.setSuccess(true);
            resultDto.setBody(body);
            return resultDto;

        } catch (Exception e) {
            boolean throwException = errorHandle(e);
            if (throwException)
                throw e;


            ResultDto resultDto = new ResultDto();
            resultDto.setSuccess(false);
            resultDto.setBody(null);
            return resultDto;
        }
    }
}
