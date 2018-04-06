// create local imports from our clases
import controller.ButtonController;
import controller.KeyController;
import model.ConnectivityData;
import view.MainView;


/***
 * This class is used to generate the core of the Recepcio program and initiate its constructors
 */
public class Main {

    /***
     * Main method that has the core of the program
     * @param args a String array to read parameters given by a cmd execution
     */
    public static void main(String[] args) {
        // crate the view
        MainView mView = new MainView();

        // create the model
        ConnectivityData mData = new ConnectivityData();

        // create the controllers
        ButtonController bController = new ButtonController(mView, mData);
        KeyController kController = new KeyController();

        // make the connections with the view
        mView.registerControllers(bController,kController);

        // show view
        mView.setVisible(true);


    }
}
