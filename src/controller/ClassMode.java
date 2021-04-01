package controller;

import view.UMLCanvas;
import geometry.ObjectFrame;
import geometry.ClassShape;
import java.awt.event.MouseEvent;
public class ClassMode extends ModeCore{
    ClassMode(UMLCanvas canvas) {
        this.canvas = canvas;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        ObjectFrame obj = new ClassShape(e.getPoint());
        obj.setPorts();
        this.canvas.addObject(obj);
        this.canvas.repaint();
    }
}
