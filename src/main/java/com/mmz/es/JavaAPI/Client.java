package com.mmz.es.JavaAPI;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

/**
 * @author: mamingze
 * @date: 2019-04-28 18:38
 * @description: TransportClient将在elasticsearch8中移除，不写这种方法了。
 */

public class Client {
    public static TransportClient getClient() {
        Settings settings = Settings.builder()
                .put("cluster.name", " my-elasticsearch").build();

        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9301))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9302))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9303));



        return client;
    }
}
