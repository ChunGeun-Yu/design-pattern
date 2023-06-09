package com.developery.designpattern.chain;

import com.developery.designpattern.templatemethod.ResultDto;

public class FilterHttpClient implements HttpClient {

    private final HttpClient target;

    public FilterHttpClient(HttpClient target) {
        this.target = target;
    }

    @Override
    public ResultDto request(String url) {
        if (url.contains("https")) {
            return target.request(url);
        }
        else {
            throw new RuntimeException("not supported http. use https instead");
        }
    }
}
