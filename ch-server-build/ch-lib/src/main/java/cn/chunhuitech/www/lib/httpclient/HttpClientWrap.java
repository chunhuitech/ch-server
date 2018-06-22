package cn.chunhuitech.www.lib.httpclient;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 18-6-14.
 */
public class HttpClientWrap {
    private final static Logger logger = LoggerFactory.getLogger(HttpClientWrap.class);
    private static final int DEFAULT_TIMEOUT_VALUE = -1;

    private static final HttpClientWrapFactory httpClientFactory = new HttpClientWrapFactory();

    private static CloseableHttpClient getHttpClient() {
        return httpClientFactory.getDefaultHttpClient();
    }

    private static RequestConfig buildRequestConfig(int soTimeout, int connectTimeout) {
        return RequestConfig.custom()
                .setSocketTimeout(soTimeout)
                .setConnectTimeout(connectTimeout).build();
    }

    public static HttpResponseWrap<String> doGet(String url, Map<String, String> headers, int soTimeout, int connectTimeout) {
        HttpGet httpGet = new HttpGet(url);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
        }
        if (soTimeout > 0 || connectTimeout > 0) {
            httpGet.setConfig(buildRequestConfig(soTimeout, connectTimeout));
        }
        return executeToString(httpGet);
    }

    public static HttpResponseWrap<String> doGet(String url, int soTimeout, int connectTimeout) {
        return doGet(url, null, soTimeout, connectTimeout);
    }

    public static HttpResponseWrap<String> doGet(Map<String, String> paramMap, String url) throws Exception{
        url = url + "?" + buildUrlParam(paramMap);
        return doGet(url, null, DEFAULT_TIMEOUT_VALUE, DEFAULT_TIMEOUT_VALUE);
    }

    public static HttpResponseWrap<String> doGet(String url, Map<String, String> headers) {
        return doGet(url, headers, DEFAULT_TIMEOUT_VALUE, DEFAULT_TIMEOUT_VALUE);
    }

    public static HttpResponseWrap<String> doGet(String url) {
        return doGet(url, null);
    }

    public static HttpResponseWrap<byte[]> doPost(String url, Map<String, String> headers, byte[] postContent) {
        return doPost(url, headers, postContent, DEFAULT_TIMEOUT_VALUE, DEFAULT_TIMEOUT_VALUE);

    }

    public static HttpResponseWrap<byte[]> doPost(String url, Map<String, String> headers, byte[] postContent, int soTimeout, int connectTimeout) {
        HttpPost post = new HttpPost(url);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                post.setHeader(entry.getKey(), entry.getValue());
            }
        }
        if (soTimeout > 0 || connectTimeout > 0) {
            post.setConfig(buildRequestConfig(soTimeout, connectTimeout));
        }
        post.setEntity(new ByteArrayEntity(postContent));
        return executeToByte(post);

    }

    public static HttpResponseWrap<String> doPost(String url, String postContent, int soTimeout, int connectTimeout) {
        return doPost(url, null, postContent, soTimeout, connectTimeout);
    }

    public static HttpResponseWrap<String> doPost(String url, Map<String, String> headers, String postContent) {
        return doPost(url, headers, postContent, DEFAULT_TIMEOUT_VALUE, DEFAULT_TIMEOUT_VALUE);
    }

    public static HttpResponseWrap<String> doPost(String url, Map<String, String> headers, String postContent, int soTimeout, int connectTimeout) {
        HttpPost post = new HttpPost(url);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                post.setHeader(entry.getKey(), entry.getValue());
            }
        }
        if (soTimeout > 0 || connectTimeout > 0) {
            post.setConfig(buildRequestConfig(soTimeout, connectTimeout));
        }
        post.setEntity(new StringEntity(postContent, Consts.UTF_8));
        return executeToString(post);

    }

    public static HttpResponseWrap<String> doPost(String url, String postContent) {
        return doPost(url, postContent, DEFAULT_TIMEOUT_VALUE, DEFAULT_TIMEOUT_VALUE);
    }

    public static HttpResponseWrap<String> doPost(String url, Map<String, String> headers
            , Map<String, String> params, int soTimeout, int connectTimeout) {
        HttpPost httpPost = new HttpPost(url);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        List<NameValuePair> formParams = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        if (soTimeout > 0 || connectTimeout > 0) {
            httpPost.setConfig(buildRequestConfig(soTimeout, connectTimeout));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));
        return executeToString(httpPost);
    }

    public static HttpResponseWrap<String> doPost(String url, Map<String, String> headers, Map<String, String> params) {
        return doPost(url, headers, params, DEFAULT_TIMEOUT_VALUE, DEFAULT_TIMEOUT_VALUE);
    }

    public static HttpResponseWrap<String> doPost(String url, Map<String, String> params) {
        return doPost(url, null, params);
    }

    public static HttpResponseWrap<String> doPost(String url, Map<String, String> params, int soTimeout, int connectTimeout) {
        return doPost(url, null, params, soTimeout, connectTimeout);
    }


    private static HttpResponseWrap<String> executeToString(HttpRequestBase request) {
        HttpResponseWrap<String> responseContent = null;
        CloseableHttpResponse response = null;
        try {
            response = getHttpClient().execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String content = EntityUtils.toString(entity, Consts.UTF_8);
                responseContent = new HttpResponseWrap<>(response.getStatusLine().getStatusCode(), response.getAllHeaders(), content);
            }
        } catch (IOException e) {
            logger.error("http execute IOException [" + e.getMessage() + "]", e);
        } catch (ParseException e) {
            logger.error("http execute ParseException [" + e.getMessage() + "]", e);
        } catch (Exception e) {
            logger.error("http execute Exception [" + e.getMessage() + "]", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
            if (request != null) {
                request.releaseConnection();
            }
        }
        return responseContent;
    }

    private static HttpResponseWrap<byte[]> executeToByte(HttpRequestBase request) {
        HttpResponseWrap<byte[]> responseContent = null;
        CloseableHttpResponse response = null;
        try {
            response = getHttpClient().execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                byte[] content = EntityUtils.toByteArray(entity);
                responseContent = new HttpResponseWrap<>(response.getStatusLine().getStatusCode(), response.getAllHeaders(), content);
            }
        } catch (IOException e) {
            logger.error("http execute IOException [" + e.getMessage() + "]", e);
        } catch (ParseException e) {
            logger.error("http execute ParseException [" + e.getMessage() + "]", e);
        } catch (Exception e) {
            logger.error("http execute Exception [" + e.getMessage() + "]", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
            if (request != null) {
                request.releaseConnection();
            }
        }
        return responseContent;
    }

    public static <T> boolean checkResponseSuccess(HttpResponseWrap<T> response) {
        return response != null && response.success() && response.getContent() != null;
    }
    protected static String buildUrlParam(Map<String, String> paramMap) throws IOException {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            formParams.add(new BasicNameValuePair(entry.getKey(), (entry.getValue())));
        }

        return URLEncodedUtils.format(formParams, Charset.forName("UTF-8"));
    }
}
