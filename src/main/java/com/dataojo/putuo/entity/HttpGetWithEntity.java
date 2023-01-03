package com.dataojo.putuo.entity;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

/**
 * @program: putuo
 * @description: 定义一个带body的GET请求 继承 HttpEntityEnclosingRequestBase
 * @author: hui
 * @create: 2022-12-26 18:11
 **/

public class HttpGetWithEntity extends HttpEntityEnclosingRequestBase {
    private final static String METHOD_NAME = "GET";

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }
    public HttpGetWithEntity() {
        super();
    }
    public HttpGetWithEntity(final URI uri) {
        super();
        setURI(uri);
    }
    public HttpGetWithEntity(final String uri) {
        super();
        setURI(URI.create(uri));
        addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyVHlwZSI6MSwiand0VHlwZSI6InVzZXIiLCJ1c2VySWQiOiI0MyIsInRlbmFudElkIjoiMSIsInVzZXJuYW1lIjoieGlhbmdzaHUiLCJzZXNzaW9uVG9rZW4iOiJhNTI4NmM0ZDI4ZGI0YTAyODVjNGFkZmE3YWU4MmQ0ZCIsImlzcyI6ImRyaWdodCIsInN1YiI6ImFjY2Vzc1Rva2VuIiwiaWF0IjoxNjcyMDQwMzUzLCJuYmYiOjE2NzIwNDAyOTN9.potNjH2teHyTjFHIZWTXh7MBSScgUbZwmcvSqmPPsRs");
    }
}

