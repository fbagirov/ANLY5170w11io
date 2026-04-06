import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(host, port)) {

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            String message;

            System.out.println("Enter message (type 'exit' to quit):");

            while ((message = userInput.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) break;

                out.println(message);

                String response = in.readLine();
                System.out.println("Server: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}