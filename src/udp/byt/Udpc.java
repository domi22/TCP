package udp.byt;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Udpc {      //���Ͷ�
	
	public static void main(String[] args) throws IOException {
		//1׼��Ҫ���͵���������
		String send = "���ǿͻ��ˣ��������¼��";
		
        //2����װ���
		DatagramPacket dp = new DatagramPacket(send.getBytes(),send.getBytes().length,InetAddress.getLocalHost(),8803);		
                
        //3�����׽��ֶ˿ڷ������ݱ�
		DatagramSocket ds = new DatagramSocket();
		
        //4.��������
		ds.send(dp);
		
        //5׼�����ܷ��ص���Ϣ
		byte[] by = new byte[1024];
		
        //6.׼�����ܵ�װ��İ�
		DatagramPacket dpr  =new DatagramPacket(by,by.length);

		//7������Ϣ
		ds.receive(dpr);

		//8������ܵ�����Ϣ4����
		System.out.println(new String(dpr.getData(),0,dpr.getLength())+dpr.getPort()+dpr.getSocketAddress());	
	
		//�ر��׽���
		ds.close();
		}
	}
