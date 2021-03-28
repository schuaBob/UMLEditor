package controller;

import java.awt.event.MouseEvent;

import geometry.ClassShape;
import geometry.Shape;
import view.UMLCanvas;

public class ModeMenu{
    private UMLCanvas canvas;
    public ModeMenu() {
        this.canvas = UMLCanvas.getInstance();
    }
    public ModeCore getMode(String s){
        ModeCore mode = null;
        switch (s) {
            case "class":
                mode = new ClassMode();
                break;
            default:
                break;
        }
        return mode;
    }


    private class ClassMode extends ModeCore{
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            Shape obj = new ClassShape(e.getPoint());
            canvas.addShape(obj);
            canvas.repaint();
        }
    }
    
}
