package com.mmz.es.JavaHighLevelRESTClient;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author: mamingze
 * @date: 2019-04-28 15:01
 * @description:
 */

public class Client {

    public static RestHighLevelClient getClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9201, "http"),
                        new HttpHost("localhost", 9202, "http"),
                        new HttpHost("localhost", 9203, "http")));

        return client;
    }

}
