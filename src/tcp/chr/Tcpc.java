package tcp.chr;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Tcpc {      //客户端
	 
	   public static void main(String[] args) throws Exception {
		//1.创建套接字指定主机和端口
		Socket socket = new Socket(InetAddress.getLocalHost(),8808);
		//2打开输入输出流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		System.out.println("客户端开始发送信息...");
		//准备要撒送的数据        
        String send = "我是客户端，请求登录！";
			
		os.write(send.getBytes());	
		System.out.println("客户端发送信息完毕...");
		
		socket.shutdownOutput();

		//4.准备接受返回的信息，并用行读取
		System.out.println("客户端开始接收信息...");
		byte[] by = new byte[1024];
		is.read(by);
		System.out.println(new String(by,0,by.length));
		
		System.out.println("客户端接收信息完毕...");
        //5关闭资源	
		socket.shutdownInput();

		}
	   }