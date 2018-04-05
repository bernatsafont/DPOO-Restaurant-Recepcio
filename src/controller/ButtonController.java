package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {

        switch(e.getActionCommand()){
            case "Ask":
                System.out.println("Ask");
                break;
            case "Order":
                System.out.println("order");
                break;
            case "Reservation":
                System.out.println("reserv");
                break;
        }
    }
}
