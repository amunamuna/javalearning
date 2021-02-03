package com.nadou.netty;

import com.nadou.netty.client.NettyClient;
import com.nadou.netty.server.NettyServer;

public class Main {
    public static void main(String[] args) {
        try {
            String host = "127.0.0.1";
            int port = 12345;
            NettyServer server = new NettyServer(port);
            server.run();
            Thread.sleep(1000);
            NettyClient client = new NettyClient(host, port);
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
