package com.mmz.es.JavaHighLevelRESTClient;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author: mamingze
 * @date: 2019-04-28 17:38
 * @description:
 */

public class TestGet {
    RestHighLevelClient client;

    @Before
    public void init() {
        client = Client.getClient();
    }

    @Test
    public void get1() throws Exception {
        GetRequest getRequest = new GetRequest(
                "posts",
                "1");

        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);

        String index = getResponse.getIndex();
        String id = getResponse.getId();
        if (getResponse.isExists()) {
            long version = getResponse.getVersion();
            String sourceAsString = getResponse.getSourceAsString();
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
            byte[] sourceAsBytes = getResponse.getSourceAsBytes();
            System.out.println(sourceAsString);
            System.out.println(sourceAsMap);
            System.out.println(sourceAsBytes);
        } else {
            System.out.println("不存在指定id");
        }

    }
}
