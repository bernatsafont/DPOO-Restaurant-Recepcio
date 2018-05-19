// package where it belongs
package controller;

// import our classes
import view.MainView;

// import java classes
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * This class manages the middle mouse wheel movement on comensals field
 */
public class MouseComensalsController implements MouseWheelListener {

    // instance attributes
    private MainView mView;

    /**
     * Constructor with parameters of the class
     * @param mView MainView instance
     */
    public MouseComensalsController(MainView mView) {
        this.mView = mView;
    }

    /**
     * Override method that handles the wheel movement
     * @param e
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        // if the rotation is positive and it's below the limit increase one unit
        if (e.getWheelRotation() < 0) {
            if(mView.getComensals()< (mView.getMaxComensals())){
                mView.addComensals(1);
            }

            // if the wheel moves down and it's above 1 decrease one unit
        } else {
            if(mView.getComensals()>1){
                mView.addComensals(-1);
            }
        }
    }
}
