package com.developery.designpattern.proxyinterface;

import com.developery.designpattern.templatemethod.ResultDto;

public interface HttpClient {

    ResultDto request(String url);
}
