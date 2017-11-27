package udp.byt;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Udpc {      //发送端
	
	public static void main(String[] args) throws IOException {
		//1准备要发送的数据内容
		String send = "我是客户端，我请求登录！";
		
        //2创建装箱包
		DatagramPacket dp = new DatagramPacket(send.getBytes(),send.getBytes().length,InetAddress.getLocalHost(),8803);		
                
        //3创建套接字端口发送数据报
		DatagramSocket ds = new DatagramSocket();
		
        //4.发送数据
		ds.send(dp);
		
        //5准备接受返回的信息
		byte[] by = new byte[1024];
		
        //6.准备接受的装箱的包
		DatagramPacket dpr  =new DatagramPacket(by,by.length);

		//7接受信息
		ds.receive(dpr);

		//8处理接受到的信息4属性
		System.out.println(new String(dpr.getData(),0,dpr.getLength())+dpr.getPort()+dpr.getSocketAddress());	
	
		//关闭套接字
		ds.close();
		}
	}
