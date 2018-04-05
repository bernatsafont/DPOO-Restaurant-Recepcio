package view;

import javax.swing.*;
import java.awt.*;


public class MainView extends JFrame{

    // create constants


    // create swing items
    private JTextField jtfUser;
    private SpinnerNumberModel smComensals;
    private SpinnerDateModel sdmDate;
    private JButton jbReservation;


    public MainView(){

        // create the utility panels
        JPanel jpTotal = new JPanel();
        //JPanel jpDemanar = new JPanel();
        //JPanel jpReservar = new JPanel();

        // set layouts
        //jpTotal.setLayout(new GridLayout(1,2));
        //jpDemanar.setLayout(new GridBagLayout());
        //jpReservar.setLayout(new GridBagLayout());
        jpTotal.setLayout(new GridBagLayout());

        // set components into demanar window
        //jpDemanar.setBorder(BorderFactory.createTitledBorder("Demanar taula"));
        // set components into reservar window
        //jpReservar.setBorder(BorderFactory.createTitledBorder("Reservar taula"));

        // set main to everything
        jpTotal.setBorder(BorderFactory.createTitledBorder("agafar taula"));

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

        // label with the number of comensals
        JLabel jlReservation = new JLabel("Reservation Date:    ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10,20,10,0);
        c.gridwidth = 1;
        jpTotal.add(jlReservation, c);

        // place the date
        sdmDate = new SpinnerDateModel();
        JSpinner spinnerDate = new JSpinner(sdmDate);
        c.gridx = 1;
        c.weightx = 0.5;
        c.insets = new Insets(10,0,10,20);
        c.gridwidth = 2;
        jpTotal.add(spinnerDate,c);

        // reservation button
        jbReservation = new JButton("Reservation");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10,20,10,0);
        c.gridwidth = 1;
        jpTotal.add(jbReservation, c);

        // place panels to the main panel
        //jpTotal.add(jpDemanar);
        //jpTotal.add(jpReservar);

        getContentPane().add(jpTotal);

        setSize(400,400);
        setTitle("Recepcio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
}
