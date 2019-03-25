package nju.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.SocketException;

@SpringBootApplication
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
        // 起socket服务 单聊socket
        try {
            MonitorSocketServer server1 = new MonitorSocketServer();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // 起socket服务 群聊socket
        try {
            GroupSocketServer server2 = new GroupSocketServer();
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}
