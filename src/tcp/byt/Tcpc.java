package tcp.byt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Tcpc{    // �ͻ���

    public static void main(String[] args) throws Exception{
		//1.�����׽���ָ�������Ͷ˿�
		Socket socket = new Socket(InetAddress.getLocalHost(),8808);
		
        //2�����������
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
        //׼��Ҫ���͵�����        
        String send = "���ǿͻ��ˣ������¼��";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		bw.write(send);
		bw.newLine();
    	        bw.flush();	
		socket.shutdownOutput();

		//4.׼�����ܷ��ص���Ϣ�������ж�ȡ
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String lin =br.readLine();
		System.out.println("�ͻ��˿�ʼ������Ϣ��");
		while(lin!=null){
			System.out.println(lin);
			lin=br.readLine();
		  }
            //5�ر���Դ
            socket.shutdownInput();

		}
	   }


