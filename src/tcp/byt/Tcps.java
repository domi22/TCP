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

public class Tcps {       // �����
	
	public static void main(String[] args) throws IOException {
		//1�����׽��֣���ָ���Ķ˿ڽ�����Ϣ
		ServerSocket serversocket = new ServerSocket(8808);
		//2�����ͻ��˵���Ϣ
		Socket socket = serversocket.accept();
		//3.�������������
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		//4��װһ���ж�ȡ����	
		BufferedReader br = new BufferedReader(new InputStreamReader(is));		
		String lin = br.readLine();
		while(lin!=null){
			System.out.println(lin);
			lin = br.readLine();
		}		
		socket.shutdownInput();
		
	
		//5���ͻ���һ����
		String replay="���Ƿ���ˣ������¼��";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));	
		bw.write(replay);
		bw.newLine();
		bw.flush();

		//6�ر���Դ

		socket.shutdownOutput();

	   }
	}
