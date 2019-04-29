package com.mmz.es.JavaHighLevelRESTClient;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: mamingze
 * @date: 2019-04-28 18:12
 * @description:
 */

public class TestUpdate {
    RestHighLevelClient client;

    @Before
    public void init() {
        client = Client.getClient();
    }
    @Test
    public void update1() throws Exception {

        UpdateRequest request = new UpdateRequest("posts", "2");
        String jsonString = "{" +
                "\"updated\":\"2017-01-01\"," +
                "\"reason\":\"daily update\"" +
                "}";
        request.doc(jsonString, XContentType.JSON);
        UpdateResponse updateResponse = client.update(
                request, RequestOptions.DEFAULT);
    }
    @Test
    public void update2() throws Exception {
        UpdateRequest request = new UpdateRequest("posts", "2")
                .doc("message", "update!!!");
        UpdateResponse updateResponse = client.update(
                request, RequestOptions.DEFAULT);
    }

}
