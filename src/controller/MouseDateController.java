// package where it belongs
package controller;

// import our packages
import view.MainView;

// import java packages
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Calendar;

/**
 * This class manages the middle mouse wheel movement on comensals field
 */
public class MouseDateController implements MouseWheelListener {

    // instance attributes
    private MainView mView;

    /**
     * Constructor with parameters of the class
     * @param mView MainView instance variable
     */
    public MouseDateController(MainView mView) {
        this.mView = mView;
    }

    /**
     * Override method, manages the mouse events
     * @param e
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        // if the rotation is positive increase one day
        if (e.getWheelRotation() < 0) {
            if(mView.getStateOrder()){
                mView.increaseDay();
            }

            // if the wheel moves down and it's above the minimum decrease one day
        } else {
            if(mView.getStateOrder()){
                Calendar c1 = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();
                c2.setTime(mView.getDate());
                if (!(c1.get(Calendar.YEAR) < c2.get(Calendar.YEAR))){
                    if(c1.get(Calendar.DAY_OF_YEAR) < c2.get(Calendar.DAY_OF_YEAR)){
                        mView.decreaseDay();
                    }
                }else{
                    mView.decreaseDay();
                }
            }
        }
    }
}
