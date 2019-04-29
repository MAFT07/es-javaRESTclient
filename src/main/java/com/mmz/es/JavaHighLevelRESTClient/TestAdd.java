package com.mmz.es.JavaHighLevelRESTClient;

//import org.elasticsearch.action.index.IndexRequest;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: mamingze
 * @date: 2019-04-28 15:20
 * @description:
 */

public class TestAdd {
    RestHighLevelClient client;

    @Before
    public void init() {
        client = Client.getClient();
    }

    @Test
    public void create1() throws Exception {

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "test3");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out a3");
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("3").source(jsonMap);

        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

        client.close();
    }

    @Test
    public void create2() throws Exception {

        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.field("user", "kimchy");
            builder.timeField("postDate", new Date());
            builder.field("message", "trying out Elasticsearch");
        }
        builder.endObject();
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("5").source(builder);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        client.close();
    }

    @Test
    public void create3() throws Exception {

        IndexRequest indexRequest = new IndexRequest("posts")
                .id("6")
                .source("user", "kimchy2",
                        "postDate", new Date(),
                        "message", "trying out Elasticsearch3");
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        client.close();
    }
}
