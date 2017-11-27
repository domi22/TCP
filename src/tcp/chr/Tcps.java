package tcp.chr;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcps {    //服务端 
	
	public static void main(String[] args) throws IOException {
		//1创建套接字，到指定的端口接受信息
		ServerSocket serversocket = new ServerSocket(8808);
		//2监听客户端的消息
		Socket socket = serversocket.accept();
		//3.打开输入输出的流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		//4封装一个行读取的流	

		System.out.println("服务端开始接收信息...");				
		byte[] by = new byte[1024];
		is.read(by);
		System.out.println(new String(by,0,by.length));
		
		socket.shutdownInput();		
	
		//5给客户端一反馈
		String replay="我是服务端，允许登录！";

		System.out.println("服务端反馈信息完毕....");
		os.write(replay.getBytes());
		//6关闭资源

		socket.shutdownOutput();

		}
	}
