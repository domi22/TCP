package udp.byt;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class Udps {     //接收端

	
	public static void main(String[] args) throws IOException {

		//1.准备接收数据报的箱子
		byte[] by = new byte[1024];
		DatagramPacket dp = new DatagramPacket(by,by.length);

		//2创建套接字，绑定到相应的端口去接收数据报
		DatagramSocket ds = new DatagramSocket(8803);

		//3.接收数据报
		ds.receive(dp);

		//4.处理操作接收到的数据4属性
		System.out.println(new String(dp.getData(),0,dp.getLength())+dp.getPort()+dp.getSocketAddress());

		//5.准备反馈的信息，及基本属性
		String replay = "我是服务器，欢迎登录！";
		SocketAddress ia = dp.getSocketAddress();

		//6将要发送的数据装箱
		DatagramPacket dpr = new DatagramPacket(replay.getBytes(),replay.getBytes().length,ia);

		//7.发送信息
		ds.send(dpr);

		//8.关闭套接字
		ds.close();

	}

}