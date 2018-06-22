package cn.chunhuitech.www.lib.httpclient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechengjin on 18-6-15.
 */
public class HttpClientWrapFactory {
    private final static int SECOND = 1000;

    private final PoolingHttpClientConnectionManager connManager;

    private final CloseableHttpClient defaultHttpClient;


    public HttpClientWrapFactory() {
        this(1024, 200);
    }

    public HttpClientWrapFactory(int maxTotal, int defaultMaxPerRoute) {

        connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(maxTotal);
        connManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        connManager.setDefaultSocketConfig(SocketConfig.custom().setTcpNoDelay(true).build());

        defaultHttpClient = createHttpClient(5 * SECOND, 10 * SECOND, 5 * SECOND);

    }

    public CloseableHttpClient createHttpClient(int connectTimeout, int soTimeout, int connectionRequestTimeout) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(soTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .build();

        CloseableHttpClient closeableHttpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .setDefaultRequestConfig(requestConfig)
                .evictIdleConnections(120, TimeUnit.SECONDS)
                .evictExpiredConnections()
                .setConnectionManagerShared(false)
                .setConnectionReuseStrategy(DefaultClientConnectionReuseStrategy.INSTANCE)
                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(2, false))
                .build();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    //
                }
            }
        });

        return closeableHttpClient;

    }

    public CloseableHttpClient getDefaultHttpClient() {
        return defaultHttpClient;
    }
}
