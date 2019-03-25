package nju.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
        // 起socket服务 单聊socket
        MonitorSocketServer server1 = new MonitorSocketServer();
        server1.startSocketServer(8888);

        // 起socket服务 群聊socket
        GroupSocketServer server2 = new GroupSocketServer();
        server2.startSocketServer(9999);
    }
}
