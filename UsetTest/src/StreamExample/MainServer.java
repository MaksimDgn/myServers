package StreamExample;

import java.net.UnknownHostException;

public class MainServer {


    public static void main(String[] args) throws UnknownHostException {
        Server s = new Server("MyHxostname", 8000);
        s.getName();
    }
}
