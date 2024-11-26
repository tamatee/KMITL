import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        // Define the port number for the server
        int port = 12345;

        try {
            // Create a DatagramSocket object
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Server started on port " + port);

            // Create a byte array to store incoming data
            byte[] buffer = new byte[1024];

            while (true) {
                // Create a DatagramPacket object to receive incoming data
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Receive the data from the client
                socket.receive(packet);

                // Convert the received data to a string
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);

                // Process the received message (e.g., perform some calculations)

                // Prepare the response message
                String response = "Hello from the server";

                // Convert the response message to bytes
                byte[] responseData = response.getBytes();

                // Create a DatagramPacket object to send the response
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                        packet.getAddress(), packet.getPort());

                // Send the response to the client
                socket.send(responsePacket);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
