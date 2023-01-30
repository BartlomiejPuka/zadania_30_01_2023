package socket1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = new Socket(host.getHostName(), 8082);
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            oos.writeObject(line);
            oos.flush();
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
        }


        //close resources
        if (ois != null) {
            ois.close();
        }
        if (oos != null) {
            oos.close();
        }
        Thread.sleep(1000);
    }
}
