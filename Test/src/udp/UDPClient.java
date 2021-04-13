package udp;


import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 客户端
 */
public class UDPClient {
    private static final String ip = "47.101.51.29";

    private static final int port = 9001;

    private static final int bleng = 1024;

    public static void main(String[] args) throws IOException {
        //1.创建客户端
        DatagramSocket socket = new DatagramSocket();
        //2.让用户来输入发送的消息
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("->");
            //接收到用户输入的信息
            String msg = scanner.nextLine();
            DatagramPacket datagramPacket= new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            //3.发送消息
            socket.send(datagramPacket);
            DatagramPacket serPacket = new DatagramPacket(
                    new byte[bleng], bleng
            );
            socket.receive(serPacket);
            System.out.println("收到服务器消息：" +
                    new String(serPacket.getData()));
        }

    }
}
