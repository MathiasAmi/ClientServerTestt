import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(1);

            System.out.println("Serveren virker fint");

            Socket socket = server.accept();

            System.out.println("Serveren har modtaget en forbindelse fra " + socket.getRemoteSocketAddress().toString());

            while (true) {

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                double aNumber = in.readDouble();
                System.out.println(aNumber);
                double areal = aNumber * aNumber * Math.PI;
                out.writeDouble(areal);

                if (aNumber == 0.0){break;}
            }


        } catch (IOException e) {
            System.out.println("Serveren fejler");


            e.printStackTrace();
        }

    }

}
