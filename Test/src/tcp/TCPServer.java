package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP
 */
public class TCPServer {
    // 端口号
    private static final int port = 9002;

    public static void main(String[] args) throws IOException {
        // 1.创建 TCP 服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器启动成功！");

        // 2.登录客户端的连接
        Socket client = serverSocket.accept();

        System.out.println(String.format("有客户端连接了，客户端IP：%s,端口：%d",
                client.getInetAddress().getHostAddress(), client.getPort()));

//        BufferedReader bufferedReader = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            // 拿到读取对象
//            bufferedReader = new BufferedReader(
//                    new InputStreamReader(client.getInputStream()));
//            // 接收服务器端的信息
//            String msg = bufferedReader.readLine();
//            // 拿到写入对象
//            bufferedWriter = new BufferedWriter(
//                    new OutputStreamWriter(client.getOutputStream()));
//            String serMsg = "我收到了";
//            bufferedWriter.write(serMsg + "\n"); // 写入消息必须加 \n
//            // 刷新缓冲区
//            bufferedWriter.flush();
//        } finally {
//            if (bufferedReader != null) {
//                bufferedReader.close();
//            }
//            if (bufferedWriter != null) {
//                bufferedWriter.close();
//            }
//        }

        // try-resouce
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream()));
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(client.getInputStream()))
        ) {
            while (true) {
                // 3.接收客户端的消息
                String msg = bufferedReader.readLine();
                if (msg != null && !msg.equals("")) {
                    System.out.println("收到客户端信息：" + msg);
                    // 4.返回给客户端响应信息
                    String serMsg = "我收到了";
                    bufferedWriter.write(serMsg + "\n");
                    // 刷新缓冲区
                    bufferedWriter.flush();
                }
            }
        }
    }
}