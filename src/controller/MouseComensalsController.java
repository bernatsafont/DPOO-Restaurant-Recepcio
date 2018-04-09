package controller;

import view.MainView;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseComensalsController implements MouseWheelListener {

    private MainView mView;

    public MouseComensalsController(MainView mView) {
        this.mView = mView;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            if(mView.getComensals()< (mView.getMaxComensals() -1)){
                mView.addComensals(1);
            }
        } else {
            //down
            if(mView.getComensals()>1){
                mView.addComensals(-1);
            }
        }
    }
}
