package cn.chunhuitech.www.lib.httpclient;

import org.apache.http.Header;

/**
 * Created by hechengjin on 18-6-15.
 */
public class HttpResponseWrap<T> {

    private final int statusCode;
    private final Header[] headers;
    private final T content;

    public HttpResponseWrap(int statusCode, Header[] headers, T content) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.content = content;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public T getContent() {
        return content;
    }

    public boolean success() {
        return this.statusCode == 200;
    }

}
