// package where it belongs
package view;

// create local classes imports
import controller.ButtonController;
import controller.KeyController;

// create java core imports
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/***
 * This class generates the main view of Recepcio program
 */
public class MainView extends JFrame{

    // create constants
    private static final int MAX_COMENSALS = 100;

    // create swing items
    private JTextField jtfUser;
    private SpinnerNumberModel smComensals;
    private SpinnerDateModel sdmDate;
    private JButton jbReservation;
    private JCheckBox jcbOrder;
    private JCheckBox jcbAsk;
    private JSpinner spinnerDate;


    /***
     * Constructor of the class that generates the items on the view
     */
    public MainView(){

        // method to populate the view
        populateView();

        // general settings of the window
        setSize(400,400);
        setTitle("Recepcio");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


    }

    /***
     * Private method that populates the view
     */
    private void populateView(){
        // create the utility panels and its gridbag layout
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
        smComensals = new SpinnerNumberModel(1,1,MAX_COMENSALS,1);
        JSpinner spinner = new JSpinner(smComensals);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        tf.setEditable(false);
        tf.setBackground(Color.WHITE);
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
        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.MINUTE, -1);
        Date startDate = calendar.getTime();
        sdmDate = new SpinnerDateModel(initDate,startDate,null,Calendar.HOUR_OF_DAY);
        spinnerDate = new JSpinner(sdmDate);
        c.gridx = 1;
        c.weightx = 0.5;
        c.insets = new Insets(10,0,10,20);
        c.gridwidth = 2;
        spinnerDate.setEnabled(false);
        JFormattedTextField tfDate = ((JSpinner.DefaultEditor) spinnerDate.getEditor()).getTextField();
        tfDate.setEditable(false);
        tfDate.setBackground(Color.WHITE);
        jpTotal.add(spinnerDate,c);

        // reservation button
        jbReservation = new JButton("Reservation");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10,20,10,10);
        c.gridwidth = 2;
        jpTotal.add(jbReservation, c);


        // add the utility panel to the main window panel
        getContentPane().add(jpTotal);
    }

    /***
     * Function that makes the connection between the controllers and the view
     * @param b ButtonController instance parameter
     * @param k KeyController instance parameter
     */
    public void registerControllers(ButtonController b, KeyController k){
        // register the button
        jbReservation.setActionCommand("Reservation");
        jbReservation.addActionListener(b);

        // register the checkbox
        jcbAsk.setActionCommand("Ask");
        jcbAsk.addActionListener(b);
        jcbOrder.setActionCommand("Order");
        jcbOrder.addActionListener(b);
    }

    /***
     * Getter of the value of Ask checkbox selection
     * @return Boolean with the selection value
     */
    public boolean getStateAsk(){
        return jcbOrder.isSelected();
    }

    /***
     * Getter of the value of Order checkbox selection
     * @return Boolean with the selection value
     */
    public boolean getStateOrder(){
        return jcbOrder.isSelected();
    }

    /***
     * Method to select or deselect the Ask checkbox
     * @param b Boolean with the new state
     */
    public void setSelectedAsk(boolean b){
        jcbAsk.setSelected(b);
    }

    /***
     * Method to select or deselect the Order checkbox
     * @param b Boolean with the new state
     */
    public void setSelectedOrder(boolean b){
        jcbOrder.setSelected(b);
    }

    /***
     * Method to enable or disable the date field
     * @param b Boolean with the new state
     */
    public void setEnableDate(boolean b){
        spinnerDate.setEnabled(b);
    }

    /***
     * Getter of the reservation name
     * @return String with the name of the reservation name
     */
    public String getReservationName(){
        return jtfUser.getText();
    }

    /***
     * Getter of comensals
     * @return integer with the number of comensals
     */
    public int getComensals(){
        return (int) smComensals.getNumber();
    }

    /***
     * Getter that returns the actual date
     * @return Date the actual date
     */
    public Date getDate(){
        return sdmDate.getDate();
    }


    /***
     * Method to generate message dialog
     * @param view the view where show message
     * @param message String with the message
     * @param title String with the title
     * @param type String with the type of error
     */
    public void popWindow(MainView view, String message, String title, String type){
        // compare the type of error that has to be launch
        switch (type) {
            case "Error":
                JOptionPane.showMessageDialog(view, message, title, JOptionPane.ERROR_MESSAGE);
                break;
            case "Warning":
                JOptionPane.showMessageDialog(view, message, title, JOptionPane.WARNING_MESSAGE);
                break;
            case "Info":
                JOptionPane.showMessageDialog(view, message, title, JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }


    /***
     * Method that resets the time on the date counter
     */
    public void resetCounter(){
        // create a instance of calendar
        Calendar calendar = Calendar.getInstance();

        // get actual date
        Date initDate = calendar.getTime();

        // get actual date minus a minute, used to prevent a broke on the spinner
        calendar.add(Calendar.MINUTE, -1);
        Date startDate = calendar.getTime();

        // set values to the spinner
        sdmDate.setStart(startDate);
        sdmDate.setValue(initDate);
    }
}
