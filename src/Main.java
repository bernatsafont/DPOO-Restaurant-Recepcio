// create local imports from our clases
import controller.ButtonController;
import controller.MailController;
import controller.MouseComensalsController;
import controller.MouseDateController;
import model.ConnectivityData;
import model.MailData;
import view.MailView;
import view.MainView;

import javax.swing.*;


/***
 * This class is used to generate the core of the Recepcio program and initiate its constructors
 */
public class Main {

    /***
     * Main method that has the core of the program
     * @param args a String array to read parameters given by a cmd execution
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // crate the view
                MainView mView = new MainView();
                MailView mailView = new MailView();

                // create the model
                ConnectivityData mData = new ConnectivityData();
                MailData mailData = new MailData();


                // create the controllers
                MouseComensalsController mcController = new MouseComensalsController(mView);
                MouseDateController mdController = new MouseDateController(mView);
                MailController mailController = new MailController(mailData,mailView);
                ButtonController bController = new ButtonController(mView, mData, mailController);

                // make the connections with the view
                mView.registerControllers(bController,mcController, mdController);
                mailView.registerController(mailController);


                // show view
                mView.setVisible(true);
            }
        });
        
    }
}
