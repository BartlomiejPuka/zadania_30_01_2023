package socket1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MyServerSocket {

    public static void runServer(Socket socket) throws IOException, ClassNotFoundException {
        System.out.println("Klient przesyla dane...");
        // takes input from the client socket
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        String line = (String) ois.readObject();
        System.out.println(line);
        Long sum = Arrays.stream(line.split(", "))
                .map(Long::parseLong)
                .reduce(Long::sum)
                .orElse(null);
        System.out.printf("obliczylem suma liczb %s to %s.%n",line, sum);

        if (sum != null) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(String.valueOf(sum));
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(8082);
        System.out.println("Server nasluchuje na porcie 8082");
        System.out.println("Oczekiwania na klienta ...");
        Socket socket = server.accept();

        while (true) {
            runServer(socket);
        }
    }
}
