package tcp.chr;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Tcpc {      //�ͻ���
	 
	   public static void main(String[] args) throws Exception {
		//1.�����׽���ָ�������Ͷ˿�
		Socket socket = new Socket(InetAddress.getLocalHost(),8808);
		//2�����������
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		System.out.println("�ͻ��˿�ʼ������Ϣ...");
		//׼��Ҫ���͵�����        
        String send = "���ǿͻ��ˣ������¼��";
			
		os.write(send.getBytes());	
		System.out.println("�ͻ��˷�����Ϣ���...");
		
		socket.shutdownOutput();

		//4.׼�����ܷ��ص���Ϣ�������ж�ȡ
		System.out.println("�ͻ��˿�ʼ������Ϣ...");
		byte[] by = new byte[1024];
		is.read(by);
		System.out.println(new String(by,0,by.length));
		
		System.out.println("�ͻ��˽�����Ϣ���...");
        //5�ر���Դ	
		socket.shutdownInput();

		}
	   }