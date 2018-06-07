package StreamExample;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

/**
 *
 * Сервер на потоках(stream)
 *
 * */

public class Server {
    private Socket soc;
    private ServerSocket srsoc;
    private DatagramSocket detsoc;
    private DatagramPacket datpac;
    private InetAddress host;
    private String name, hostname;
    private int port;
    private String hostaddr;

    Server(String name, int port) throws UnknownHostException {
        this.port = port;
        this.name = name;
        host = InetAddress.getLocalHost();
        hostname = host.getHostName();
        hostaddr = host.getHostAddress();

        byte[] buf = new byte[1024];

        PrintStream ps = null;
        soc = null;

        getName();
        try {

            srsoc = new ServerSocket(port);
            //srsoc.bind(srsoc.getLocalSocketAddress());

            boolean binds = srsoc.isBound();
            System.out.println("Binds: " +binds);

            // ждем подключения клиента
           soc =  srsoc.accept();

            ps = new PrintStream(soc.getOutputStream());
            //  помущение строки в буфер
            ps.println("привет!");
            // отправка содержимого буфера клиента
            ps.flush();
            ps.close();

            // принять Datagram  пакета
            datpac =  new DatagramPacket(buf, buf.length);
            datpac.getData();

            /*detsoc = new DatagramSocket();
            System.out.printf("Dp: " + detsoc.getLocalPort() );
            detsoc.close();*/

            srsoc.close();
            //srsoc = new ServerSocket(port, hostname);
        } catch (UnknownServiceException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getName() {
        System.out.println(name);
        System.out.println("Host name: "+ hostname);
        System.out.println("host addr: " + hostaddr);
        System.out.println("Port: " + port);
    }

    public static void main(String[] args) throws UnknownHostException {
       Server s = new Server("MyHxostname", 8035);
        //s.getName();
    }
}
