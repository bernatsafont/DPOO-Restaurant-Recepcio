// package where it belongs
package network;

// import java classes
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

/**
 * Class that manages the connection between the client Recepcio and the server
 */
public class ReceptionNetwork {

    // create utilities for talk with the server
    private Socket socket;
    private DataOutputStream dos;
    private ObjectOutputStream oos;
    private DataInputStream dis;

    /**
     * Constructor that inits the server connection with a given port and ip
     * @param port integer with the port value
     */
    public ReceptionNetwork(int port) throws IOException{

        // init the values with the connection
        InetAddress iAddress = InetAddress.getLocalHost();
        String IP = iAddress.getHostAddress();
        socket = new Socket(String.valueOf(IP), port);
        dos = new DataOutputStream(socket.getOutputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());
    }

    /**
     * Method that waits for a answer of the server
     * @return String with the received value
     * @throws IOException possible exception to found about the input and output connection
     */
    public boolean getAnswer() throws IOException {
        return dis.readBoolean();
    }

    /**
     * Method that closes the connection of the streams and the sockets
     * @throws IOException possible exception to found about the input and output connection
     */
    public void closeConnetion() throws IOException {
        dis.close();
        dos.close();
        oos.close();
        socket.close();
    }

    /**
     * Method that waits for a answer of the server
     * @return String with the received value
     * @throws IOException possible exception to found about the input and output connection
     */
    public String getCode() throws IOException {
        return dis.readUTF();
    }

    /**
     * This method sends the reservation to the server
     * @param reservationName String with the reservation name
     * @param comensals integer with the number of comensalls
     * @param date Date with the date order
     * @throws IOException possible exception to found about the input and output connection
     */
    public void sendReservation(String reservationName, int comensals, Date date) throws IOException {

        dos.writeUTF("RESERVATION");
        dos.writeUTF(reservationName);
        dos.writeInt(comensals);
        oos.writeObject(date);
    }
}
