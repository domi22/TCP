TCP�����ַ���������Ϣ
[���ַ�����Ҫ����ʾ]:
1:
  ���׽��ֹر�֮���ַ�����ȻҲ�͹ر��ˣ�����ֻ��Ҫsocket.shutdownOutput();/socket.shutdownInput();
  ӦΪ�׽��ֿ������ֽ�����װ���ַ���Buffered���棬�����ȹر��ַ���bw.close()������ر��׽��֡�
  �׳�java.net.SocketException: Socket is closed�쳣,˵���Ѿ����׽��ֹرա�
2:����Ҫд�뻻�з�bw.newLine();������������ĩβ��\n������������BufferedReader��readerLine()
  �������ݰ���ʱ����ܶ�ȡ��һ��������Ϣ���������ֶ�ȡ����