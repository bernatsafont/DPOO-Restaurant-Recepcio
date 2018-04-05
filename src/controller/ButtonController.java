package controller;

import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener{

    private MainView mView;

    public ButtonController(MainView mView) {
        this.mView = mView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch(e.getActionCommand()){
            case "Ask":
                if(!mView.getStateAsk()){
                    mView.setSelectedAsk(true);
                }
                mView.setSelectedOrder(false);
                mView.setEnableDate(false);
                mView.resetCounter();
                break;
            case "Order":
                if(!mView.getStateOrder()){
                    mView.setSelectedOrder(true);
                }
                mView.setSelectedAsk(false);
                mView.setEnableDate(true);
                break;
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
