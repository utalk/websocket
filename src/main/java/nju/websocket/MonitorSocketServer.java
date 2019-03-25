package nju.websocket;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Set;

/**
 * nio socket服务端
 */
public class MonitorSocketServer {
    private final DatagramSocket socket;
    private final Thread serverThread;

    //解码buffer
    private Charset cs = Charset.forName("UTF-8");
    //接受数据缓冲区
    private static ByteBuffer sBuffer = ByteBuffer.allocate(1024);
    //发送数据缓冲区
    private static ByteBuffer rBuffer = ByteBuffer.allocate(1024);
    //选择器（叫监听器更准确些吧应该）
    private static Selector selector;

    public MonitorSocketServer() throws SocketException {
        this.socket = new DatagramSocket(8888);
        this.serverThread = new Thread(() -> {
            try {
                byte[] receiveData = new byte[1024];
                while(true) {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);
                    String msg = new String(receiveData, 0, receivePacket.getLength(), "utf-8");

                    System.out.println(msg + "jjjj");

                    MonitorWebSocket.sendInfo(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
    }
}


