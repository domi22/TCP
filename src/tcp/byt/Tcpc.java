package tcp.byt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Tcpc{    // 客户端

    public static void main(String[] args) throws Exception{
		//1.创建套接字指定主机和端口
		Socket socket = new Socket(InetAddress.getLocalHost(),8808);
		
        //2打开输入输出流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
        //准备要撒送的数据        
        String send = "我是客户端，请求登录！";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		bw.write(send);
		bw.newLine();
    	        bw.flush();	
		socket.shutdownOutput();

		//4.准备接受返回的信息，并用行读取
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String lin =br.readLine();
		System.out.println("客户端开始接受信息！");
		while(lin!=null){
			System.out.println(lin);
			lin=br.readLine();
		  }
            //5关闭资源
            socket.shutdownInput();

		}
	   }


