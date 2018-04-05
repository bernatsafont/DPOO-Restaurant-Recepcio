package view;

import controller.ButtonController;
import controller.KeyController;

import javax.swing.*;
import java.awt.*;
import java.util.Date;


public class MainView extends JFrame{

    // create constants


    // create swing items
    private JTextField jtfUser;
    private SpinnerNumberModel smComensals;
    private SpinnerDateModel sdmDate;
    private JButton jbReservation;
    private JCheckBox jcbOrder;
    private JCheckBox jcbAsk;
    private JSpinner spinnerDate;


    public MainView(){

        // create the utility panels
        JPanel jpTotal = new JPanel();


        jpTotal.setLayout(new GridBagLayout());

        // set main to everything
        jpTotal.setBorder(BorderFactory.createTitledBorder("Agafar taula"));

        // set components to the bag
        GridBagConstraints c = new GridBagConstraints();

        // label with the username
        JLabel jlUsername = new JLabel("Client name:    ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,20,10,0);
        c.gridwidth = 1;
        jpTotal.add(jlUsername, c);

        // space for the user to write the name
        jtfUser = new JTextField();
        c.gridx = 1;
        c.weightx = 0.5;
        c.insets = new Insets(10,0,10,20);
        c.gridwidth = 2;
        jpTotal.add(jtfUser, c);

        // label with the number of comensals
        JLabel jlComensals = new JLabel("Number of comensals:    ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10,20,10,0);
        c.gridwidth = 1;
        jpTotal.add(jlComensals, c);

        // space for the user to write the name
        smComensals = new SpinnerNumberModel(0,0,100,1);
        JSpinner spinner = new JSpinner(smComensals);
        c.gridx = 1;
        c.weightx = 0.5;
        c.insets = new Insets(10,0,10,20);
        c.gridwidth = 2;
        jpTotal.add(spinner,c);

        // ask or order
        jcbAsk = new JCheckBox("Demanar");
        jcbAsk.setSelected(true);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10,20,10,0);
        c.gridwidth = 1;
        jpTotal.add(jcbAsk, c);

        jcbOrder = new JCheckBox("Reservar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(10,20,10,0);
        c.gridwidth = 1;
        jpTotal.add(jcbOrder, c);



        // label with the number of reservation date
        JLabel jlReservation = new JLabel("Reservation Date:    ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10,20,10,0);
        c.gridwidth = 1;
        jpTotal.add(jlReservation, c);

        // place the date
        sdmDate = new SpinnerDateModel();
        spinnerDate = new JSpinner(sdmDate);
        c.gridx = 1;
        c.weightx = 0.5;
        c.insets = new Insets(10,0,10,20);
        c.gridwidth = 2;
        spinnerDate.setEnabled(false);
        jpTotal.add(spinnerDate,c);

        // reservation button
        jbReservation = new JButton("Reservation");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10,20,10,0);
        c.gridwidth = 2;
        jpTotal.add(jbReservation, c);

        getContentPane().add(jpTotal);

        setSize(400,400);
        setTitle("Recepcio");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void registerControllers(ButtonController b, KeyController k){
        jbReservation.setActionCommand("Reservation");
        jbReservation.addActionListener(b);

        jcbAsk.setActionCommand("Ask");
        jcbAsk.addActionListener(b);
        jcbOrder.setActionCommand("Order");
        jcbOrder.addActionListener(b);


    }
    public boolean getStateAsk(){
        return jcbAsk.isSelected();
    }

    public boolean getStateOrder(){
        return jcbOrder.isSelected();
    }

    public void setSelectedAsk(boolean b){
        jcbAsk.setSelected(b);
    }

    public void setSelectedOrder(boolean b){
        jcbOrder.setSelected(b);
    }

    public void setEnableDate(boolean b){
        spinnerDate.setEnabled(b);
    }

    public String getReservationName(){
        return jtfUser.getName();
    }

}
