package udp.byt;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class Udps {     //���ն�

	
	public static void main(String[] args) throws IOException {

		//1.׼���������ݱ�������
		byte[] by = new byte[1024];
		DatagramPacket dp = new DatagramPacket(by,by.length);

		//2�����׽��֣��󶨵���Ӧ�Ķ˿�ȥ�������ݱ�
		DatagramSocket ds = new DatagramSocket(8803);

		//3.�������ݱ�
		ds.receive(dp);

		//4.����������յ�������4����
		System.out.println(new String(dp.getData(),0,dp.getLength())+dp.getPort()+dp.getSocketAddress());

		//5.׼����������Ϣ������������
		String replay = "���Ƿ���������ӭ��¼��";
		SocketAddress ia = dp.getSocketAddress();

		//6��Ҫ���͵�����װ��
		DatagramPacket dpr = new DatagramPacket(replay.getBytes(),replay.getBytes().length,ia);

		//7.������Ϣ
		ds.send(dpr);

		//8.�ر��׽���
		ds.close();

	}

}