package tcp.chr;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcps {    //����� 
	
	public static void main(String[] args) throws IOException {
		//1�����׽��֣���ָ���Ķ˿ڽ�����Ϣ
		ServerSocket serversocket = new ServerSocket(8808);
		//2�����ͻ��˵���Ϣ
		Socket socket = serversocket.accept();
		//3.�������������
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		//4��װһ���ж�ȡ����	

		System.out.println("����˿�ʼ������Ϣ...");				
		byte[] by = new byte[1024];
		is.read(by);
		System.out.println(new String(by,0,by.length));
		
		socket.shutdownInput();		
	
		//5���ͻ���һ����
		String replay="���Ƿ���ˣ������¼��";

		System.out.println("����˷�����Ϣ���....");
		os.write(replay.getBytes());
		//6�ر���Դ

		socket.shutdownOutput();

		}
	}
