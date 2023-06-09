package com.developery.designpattern.chain;

import com.developery.designpattern.templatemethod.ResultDto;

public interface HttpClient {

    ResultDto request(String url);
}
