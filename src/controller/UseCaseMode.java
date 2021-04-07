package controller;
import geometry.ObjectFrame;
import geometry.UseCaseShape;
import view.UMLCanvas;

import java.awt.event.MouseEvent;
public class UseCaseMode extends ModeCore {
    UseCaseMode(UMLCanvas canvas) {
        this.canvas = canvas;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        ObjectFrame obj = new UseCaseShape(e.getPoint());
        obj.setPorts();
        canvas.addShape(obj);
        canvas.repaint();
    }
}
