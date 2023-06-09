package com.developery.designpattern.proxyclass;

import com.developery.designpattern.strategy.MyErrorHandler;
import com.developery.designpattern.templatemethod.ResultDto;

import java.util.HashMap;

public class CacheHttpClient extends MyHttpClient {

    private HashMap<String, ResultDto> cache = new HashMap<>();
    public CacheHttpClient(MyErrorHandler handler) {
        super(handler);
    }

    @Override
    public ResultDto request(String url) {
        ResultDto resultDto = cache.get(url);
        if (resultDto != null) {
            return resultDto;
        }
        ResultDto response = super.request(url);
        cache.put(url, response);
        return response;
    }


}
