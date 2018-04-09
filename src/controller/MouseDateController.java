package controller;

import view.MainView;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Calendar;

public class MouseDateController implements MouseWheelListener {

    private MainView mView;

    public MouseDateController(MainView mView) {
        this.mView = mView;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        if (e.getWheelRotation() < 0) {
            if(mView.getStateOrder()){
                mView.increaseDay();
            }
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
