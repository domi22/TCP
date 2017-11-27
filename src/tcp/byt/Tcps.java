package tcp.byt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcps {       // 服务端
	
	public static void main(String[] args) throws IOException {
		//1创建套接字，到指定的端口接受信息
		ServerSocket serversocket = new ServerSocket(8808);
		//2监听客户端的消息
		Socket socket = serversocket.accept();
		//3.打开输入输出的流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		//4封装一个行读取的流	
		BufferedReader br = new BufferedReader(new InputStreamReader(is));		
		String lin = br.readLine();
		while(lin!=null){
			System.out.println(lin);
			lin = br.readLine();
		}		
		socket.shutdownInput();
		
	
		//5给客户端一反馈
		String replay="我是服务端，允许登录！";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));	
		bw.write(replay);
		bw.newLine();
		bw.flush();

		//6关闭资源

		socket.shutdownOutput();

	   }
	}
