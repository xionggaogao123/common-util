package com.common.utils.http;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author keven
 * @date 2018-04-30 下午10:05
 * @Description http 工具类，发送get, post 请求，在这里封装好，下次直接用
 */
@Slf4j
public class HttpUtil {


    private static final CloseableHttpClient httpClient;

    static {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }


    /**
     * @param url      请求URL
     * @param paramMap header参数
     * @return 返回数据
     */
    public static String doGetRequest(String url, Map<String, String> paramMap) {
        try {
            Request request = Request.Get(url);
            request.connectTimeout(1000);
            request.connectTimeout(3000);
            request.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
            request.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));
            if (paramMap != null) {
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    request.addHeader(entry.getKey(), entry.getValue());
                }
            }
            Response response = request.execute();
            Content content = response.returnContent();
            return content.asString();
        } catch (Exception e) {
            return null;
        }
    }



    /**
     * 发送 get 请求
     *
     * @param url    请求url
     * @param params 请求参数
     * @return 响应内容
     */
    public static String doGet(String url, Map<String, String> params) {

        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<>(params.size());
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, "utf-8"));
            }
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            log.error("fail send get request cause={}", Throwables.getStackTraceAsString(e));
        }
        return null;
    }


    /**
     * @param url      请求URL
     * @param paramMap header参数
     * @return 返回数据
     */
    public static String doPostRequest(String url, Map<String, String> paramMap) {
        try {
            Request request = Request.Post(url);
            request.connectTimeout(1000);
            request.connectTimeout(3000);
            if (paramMap != null) {
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    request.addHeader(entry.getKey(), entry.getValue());
                }
            }
            Response response = request.execute();
            Content content = response.returnContent();
            return content.asString();
        } catch (Exception e) {
            return null;
        }
    }




}
