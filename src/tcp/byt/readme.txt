TCP：用字符流传输信息
[用字符流的要点提示]:
1:
  将套接字关闭之后，字符流自然也就关闭了，所以只需要socket.shutdownOutput();/socket.shutdownInput();
  应为套接字开启的字节流封装在字符流Buffered里面，若果先关闭字符流bw.close()，将会关闭套接字。
  抛出java.net.SocketException: Socket is closed异常,说明已经将套接字关闭。
2:必须要写入换行符bw.newLine();（或者在内容末尾加\n），这样在用BufferedReader的readerLine()
  接收数据包的时候才能读取到一个换行信息，否则会出现读取错误。