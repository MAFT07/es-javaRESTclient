package com.mmz.es.JavaHighLevelRESTClient;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: mamingze
 * @date: 2019-04-28 18:03
 * @description:
 */

public class TestDelete {
    RestHighLevelClient client;

    @Before
    public void init() {
        client = Client.getClient();
    }
    @Test
    public void delete() throws Exception{
        DeleteRequest request = new DeleteRequest(
                "posts",
                "1");
        DeleteResponse deleteResponse = client.delete(
                request, RequestOptions.DEFAULT);

        String index = deleteResponse.getIndex();
        String id = deleteResponse.getId();
        long version = deleteResponse.getVersion();
        ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
            System.out.println(index);
            System.out.println(id);
            System.out.println(version);
        }
        if (shardInfo.getFailed() > 0) {
            for (ReplicationResponse.ShardInfo.Failure failure :
                    shardInfo.getFailures()) {
                String reason = failure.reason();
            }
        }
    }
}
