package ServerDatagram;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public class Server {
    //private ServerSocket servSoc = null;
    //private InetAddress addr;
    private int port;
    private DatagramSocket socket;
    private Thread serverRun, manage, receive;
    private boolean running = false;

    Server(int port) {
        this.port = port;

/*        try {
            servSoc = new ServerSocket(port);

            System.out.println("Port: " + port);
            addr = InetAddress.getLocalHost();
            System.out.println("Host Name: " + addr.getHostName());
            System.out.println("Host Address: " + addr.getHostAddress());
            servSoc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        serverRun = new Thread(new Runnable() {
            @Override
            public void run() {
                running = true;
                manage();
                receive();
            }
        }, "serverRun");
        }

        private void manage() {
        manage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    //TODO(maksim): manage the client
                }
            }
        });
        manage.start();
        }

    private void receive() {
        receive = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    //TODO(maksim): manage the client
                }
            }
        });
        receive.start();
    }
}
