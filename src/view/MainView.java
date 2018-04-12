// package where it belongs
package view;

// create local classes imports
import com.toedter.calendar.JDateChooser;
import controller.ButtonController;
import controller.MouseComensalsController;
import controller.MouseDateController;

// create java core imports
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/***
 * This class generates the main view of Recepcio program
 */
public class MainView extends JFrame{

    // create constants
    private static final int MAX_COMENSALS = 10;

    // create swing items
    private JTextField jtfUser;
    private SpinnerNumberModel smComensals;
    private JButton jbReservation;
    private JCheckBox jcbOrder;
    private JCheckBox jcbAsk;
    private JSpinner spinner;
    private JDateChooser dateChooser;


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
        jpTotal.setBorder(BorderFactory.createTitledBorder("Add table"));

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
        spinner = new JSpinner(smComensals);
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


        // set date to today and yesterday
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.MINUTE, -1);
        Date yesterday = calendar.getTime();
        // place dates reference into jCalendar object
        dateChooser = new JDateChooser();
        dateChooser.setDate(today);
        dateChooser.setMinSelectableDate(yesterday);
        dateChooser.setEnabled(false);
        c.gridx = 1;
        c.weightx = 0.5;
        c.insets = new Insets(10,0,10,20);
        c.gridwidth = 2;
        jpTotal.add(dateChooser,c);


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
     * @param mc MouseComensalsController instance parameter
     * @param md MouseDateController instance parameter
     */
    public void registerControllers(ButtonController b, MouseComensalsController mc, MouseDateController md){
        // register the button
        jbReservation.setActionCommand("Reservation");
        jbReservation.addActionListener(b);

        // register the checkbox
        jcbAsk.setActionCommand("Ask");
        jcbAsk.addActionListener(b);
        jcbOrder.setActionCommand("Order");
        jcbOrder.addActionListener(b);

        // register mouse controller
        spinner.addMouseWheelListener(mc);
        dateChooser.addMouseWheelListener(md);
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
        // set date to today and yesterday
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.MINUTE, -1);
        Date yesterday = calendar.getTime();

        // set values to the jCalendar
        dateChooser.setDate(today);
        dateChooser.setMinSelectableDate(yesterday);
    }

    /***
     * Method that clears all the fiels of the view
     */
    public void clearAllFields(){
        jtfUser.setName("");
        smComensals.setValue(1);
        resetCounter();
    }

    public void addComensals(int i){
        smComensals.setValue((int) smComensals.getValue() + i);
    }


    public int getMaxComensals() {
        return MAX_COMENSALS;
    }

    public void increaseDay() {
        Date d = dateChooser.getDate();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 1);
        dateChooser.setDate(c.getTime());
    }

    public void decreaseDay() {
        Date d = dateChooser.getDate();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, -1);
        dateChooser.setDate(c.getTime());
    }

    public void setEnableDate(boolean state) {
        dateChooser.setEnabled(state);
    }

    public Date getDate() {
        return dateChooser.getDate();
    }
}
