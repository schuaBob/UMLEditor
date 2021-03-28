package controller;

import java.awt.event.MouseEvent;

import geometry.*;
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
            case "use-case":
                mode = new UseCaseMode();
                break;
            default:
                break;
        }
        return mode;
    }


    private class ClassMode extends ModeCore{
        @Override
        public void mouseClicked(MouseEvent e) {
            Shape obj = new ClassShape(e.getPoint());
            canvas.addShape(obj);
            canvas.repaint();
        }
    }

    private class UseCaseMode extends ModeCore {
        @Override
        public void mouseClicked(MouseEvent e) {
            Shape obj = new UseCaseShape(e.getPoint());
            canvas.addShape(obj);
            canvas.repaint();
        }
    }
    
}
