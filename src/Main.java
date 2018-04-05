import controller.ButtonController;
import controller.KeyController;
import view.MainView;

public class Main {

    public static void main(String[] args) {
        // crate the view
        MainView mView = new MainView();

        // create the controllers
        ButtonController bController = new ButtonController() ;
        KeyController kController = new KeyController();

        // create the model

        // make the connections with the view
        mView.registerControllers(bController,kController);


        // show view
        mView.setVisible(true);


    }
}
