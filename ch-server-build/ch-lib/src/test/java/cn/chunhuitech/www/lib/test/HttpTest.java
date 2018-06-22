package cn.chunhuitech.www.lib.test;

import cn.chunhuitech.www.lib.httpclient.HttpClientWrap;
import cn.chunhuitech.www.lib.httpclient.HttpResponseWrap;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 18-6-14.
 */
public class HttpTest {
    private static Logger logger = LoggerFactory.getLogger(HttpTest.class);
    int timeout = Integer.MAX_VALUE;
    //使用httpclient执行get请求
    @Test
    public void doGet()throws Exception {
//创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
//创建一个GET对象
        HttpGet get =new HttpGet("http://www.sogou.com");
//执行请求
        CloseableHttpResponse response =httpClient.execute(get);
//取响应的结果
        int statusCode =response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        HttpEntity entity =response.getEntity();
        String string = EntityUtils.toString(entity,"utf-8");
        System.out.println(string);
//关闭httpclient
        response.close();
        httpClient.close();
    }

    @Test
    public void doGetByHttpClientWrap()throws Exception {
        String url = "http://www.sogou.com";
        HttpResponseWrap<String> response = HttpClientWrap.doGet(url);
        output(response);
    }

    private void output(HttpResponseWrap<String> response){
        logger.info("statusCode:" + response.getStatusCode() + " content:" + response.getContent());
    }

    //使用httpclient执行get请求带参数
    @Test
    public void doGetWithParam()throws Exception{
//创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
//创建一个uri对象
        URIBuilder uriBuilder = new URIBuilder("http://www.sogou.com/web");
        uriBuilder.addParameter("query","花千骨");
        HttpGet get = new HttpGet(uriBuilder.build());
//执行请求
        CloseableHttpResponse response =httpClient.execute(get);
//取响应的结果
        int statusCode =response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        HttpEntity entity =response.getEntity();
        String string = EntityUtils.toString(entity,"utf-8");
        System.out.println(string);
//关闭httpclient
        response.close();
        httpClient.close();
    }

    @Test
    public void doGetWithParamByHttpClientWrap()throws Exception {
        String url = "http://www.sogou.com";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("query","花千骨");
        HttpResponseWrap<String> response = HttpClientWrap.doGet(paramMap, url);
        output(response);
    }

    //使用httpclient执行post请求
    @Test
    public void doPost()throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
//创建一个post对象
        HttpPost post =new HttpPost("http://localhost:8082/httpclient/post.html");
//执行post请求
        CloseableHttpResponse response =httpClient.execute(post);
        String string = EntityUtils.toString(response.getEntity());
        System.out.println(string);
        response.close();
        httpClient.close();
    }

    //使用httpclient执行带参数post请求
    @Test
    public void doPostWithParam()throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
//创建一个post对象
        HttpPost post =new HttpPost("http://localhost:8082/httpclient/post.html");
//创建一个Entity。模拟一个表单
        List<NameValuePair> kvList = new ArrayList<>();
        kvList.add(new BasicNameValuePair("username","zhangsan"));
        kvList.add(new BasicNameValuePair("password","123"));
//包装成一个Entity对象
        StringEntity entity = new UrlEncodedFormEntity(kvList,"utf-8");
//设置请求的内容
        post.setEntity(entity);
//执行post请求
        CloseableHttpResponse response =httpClient.execute(post);
        String string = EntityUtils.toString(response.getEntity());
        System.out.println(string);
        response.close();
        httpClient.close();
    }
}
