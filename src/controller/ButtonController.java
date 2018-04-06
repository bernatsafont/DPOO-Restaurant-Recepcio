// package where it belongs
package controller;

// import local classes
import view.MainView;

// import java classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * Class to control all the button actions
 */
public class ButtonController implements ActionListener{

    // create a instance of the view
    private MainView mView;

    /***
     * Createor that sets the view and the network
     * @param mView MainView instance to get the view
     */
    public ButtonController(MainView mView) {
        this.mView = mView;
    }

    /***
     * Method that manages actions performed by the view it's listening
     * @param e Event that is triggered
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // look which button is pressed
        switch(e.getActionCommand()){
            // if ask, select ask and disable the date table and actualize it
            case "Ask":
                if(!mView.getStateAsk()){
                    mView.setSelectedAsk(true);
                }
                mView.setSelectedOrder(false);
                mView.setEnableDate(false);
                mView.resetCounter();
                break;

            // if order, select the order checkbox, enable the date item and actualize the date
            case "Order":
                if(!mView.getStateOrder()){
                    mView.setSelectedOrder(true);
                }
                mView.setSelectedAsk(false);
                mView.setEnableDate(true);
                mView.resetCounter();
                break;

            // if reservation, check if all filled and send to the server
            case "Reservation":
                String s = checkEntry();
                if(!s.equals("OK")){
                    mView.popWindow(mView, s, "Entry Warning", "Warning");
                }else{
                    try{
                        // connection with server, send client petition
                    }catch (Exception e1){
                        mView.popWindow(mView, e1.getMessage(), "Server Error", "Error");
                    }
                }
                break;
        }
    }

    /***
     * Method that looks if all the items are filled
     * @return String with the result
     */
    private String checkEntry(){
        StringBuilder sb = new StringBuilder();
        if(mView.getReservationName().equals("")){
            sb.append("The name is not filled. ");
        }else{
            sb.append("OK");
        }

        return sb.toString();
    }
}
