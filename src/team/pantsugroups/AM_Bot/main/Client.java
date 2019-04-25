package team.pantsugroups.AM_Bot.main;

import org.java_websocket.client.WebSocketClient;

public class Client{
    public static void main(String[] args) throws Exception {
            WebSocketClient lemocWebSocketClient = LemocWebSocketClientFactory.getLemocWebSocketClient();
             lemocWebSocketClient.connect();
        }
}