package StreamExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/*
*
*  слиент на потоках
*
* */
public class Client {
    private Socket soc ;
    private InetAddress addr;
    private String host, ip;
    private int port;

    Client( String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
       // addr = InetAddress.getByName(host);
        addr = InetAddress.getLocalHost();
        host = addr.getHostAddress();

        System.out.println(addr);
        System.out.println(host + " : " + port);
        System.out.println("Ip  : " + ip);

        //soc = new Socket(this.host, this.port);
        soc = new Socket(this.ip, this.port);

       // soc.connect(addr.getHostAddress() );

        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String messge = br.readLine();
        System.out.println(messge);
        br.close();
        soc.close();
    }

    public static void main(String[] args) throws IOException {
        //new StreamExample.Client( 8035);
        new Client( "192.168.100.11",8080);
    }
}
