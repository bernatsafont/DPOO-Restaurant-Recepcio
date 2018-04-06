// package where it belongs
package model;

// import java classes
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// import extra java classes
import org.json.*;

/***
 * Class that manages the model information related with the connectivity
 */
public class ConnectivityData {

    // generate constant values
    private String IP;
    private int PORT;
    private final String PATH = "../DPOO-Restaurant-Servidor/resources";

    /***
     * Constructor of the class, sets the constants value
     */
    public ConnectivityData() {
        JSONObject obj = new JSONObject(getFileContent("config.json"));
        this.IP = obj.getString("db_ip");
        this.PORT = Integer.parseInt(obj.getString("port_server"));
    }

    /***
     * Getter of IP fied
     * @return String with the ip name
     */
    public String getIP() {
        return IP;
    }

    /***
     * Getter of PORT field
     * @return integer with the port number
     */
    public int getPORT() {
        return PORT;
    }

    /***
     * Method that from a file name returns a String in JSON format
     * @param file name of the file that we want to convert to .json
     * @return String converted in .json format
     */
    private String getFileContent(String file){
        //creem un scanner per al arxiu
        Scanner sc = null;
        try {
            sc = new Scanner(new File(PATH + "/" + file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //creem una string d'una sola linia
        StringBuilder str = new StringBuilder();
        while (sc.hasNext()){
            String c = sc.next();
            str.append(c);
        }

        //passem la string a un objecte json
        JSONObject jsonObj = new JSONObject(str.toString());

        //retornem la llista en format correcte
        return jsonObj.toString(4);

    }



}
