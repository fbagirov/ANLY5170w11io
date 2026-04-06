import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started...");

            Socket client = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(
                    client.getOutputStream(), true);

            BufferedWriter fileWriter = new BufferedWriter(
                    new FileWriter("log.txt", true)); // append mode

            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Write to file
                fileWriter.write(message);
                fileWriter.newLine();
                fileWriter.flush();

                // Send response
                out.println("Message received");
            }

            fileWriter.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}