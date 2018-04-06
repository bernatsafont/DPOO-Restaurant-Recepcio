import controller.ButtonController;
import controller.KeyController;
import model.ConnectivityData;
import view.MainView;

public class Main {

    public static void main(String[] args) {
        // crate the view
        MainView mView = new MainView();

        // create the model
        ConnectivityData mData = new ConnectivityData();

        // create the controllers
        ButtonController bController = new ButtonController(mView) ;
        KeyController kController = new KeyController();



        // make the connections with the view
        mView.registerControllers(bController,kController);


        // show view
        mView.setVisible(true);


    }
}
