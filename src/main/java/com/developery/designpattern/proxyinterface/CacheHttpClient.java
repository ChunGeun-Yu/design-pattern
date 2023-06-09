package com.developery.designpattern.proxyinterface;

import com.developery.designpattern.templatemethod.ResultDto;

import java.util.HashMap;

public class CacheHttpClient implements HttpClient {

    private HashMap<String, ResultDto> cache = new HashMap<>();

    private final HttpClient target;

    public CacheHttpClient(HttpClient target) {
        this.target = target;
    }

    @Override
    public ResultDto request(String url) {
        ResultDto resultDto = cache.get(url);
        if (resultDto != null) {
            return resultDto;
        }
        ResultDto response = target.request(url);
        cache.put(url, response);
        return response;
    }
}
