package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.*;


public class ConnectivityData {

    private String IP;
    private int PORT;
    private final String PATH = "../DPOO-Restaurant-Servidor/resources";

    public ConnectivityData() {
        JSONObject obj = new JSONObject(getFileContent("config.json"));
        this.IP = obj.getString("db_ip");
        this.PORT = Integer.parseInt(obj.getString("port_server"));
    }


    public String getIP() {
        return IP;
    }

    public int getPORT() {
        return PORT;
    }

    /**
     * MÃ©tode que a partir d'un nom d'arxiu retorna un string en format Json
     * @param file nom del arxiu que es vol convertir en format .json
     * @return String convertit en format .json
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
