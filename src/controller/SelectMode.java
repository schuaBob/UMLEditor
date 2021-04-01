package controller;

import geometry.*;
import geometry.Shape;
import view.UMLCanvas;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SelectMode extends ModeCore {
    private Point clickedP;
    private Queue<ObjectFrame> shapeQ = new LinkedList<ObjectFrame>();

    SelectMode(UMLCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.clickedP = e.getPoint();
        this.shapeQ = this.canvas.getAllObjects();
        Boolean selected = false;
        Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
        while (sqIt.hasNext()) {
            ObjectFrame of = (ObjectFrame) sqIt.next();
            if (of.include(this.clickedP)) {
                this.canvas.setCurrentShape(of);
                selected = true;
                break;
            }
        }
        if (!selected) {
            this.canvas.setCurrentShape(null);
            Group gp = new Group(e.getPoint(), e.getPoint());
            this.canvas.setSelectedGroup(gp);;
        }
        this.canvas.repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Shape obj = this.canvas.getCurrentShape();
        Group g = this.canvas.getSelectedGroup();
        if (obj != null) {
            ((ObjectFrame) obj).resetLocation(this.clickedP, e.getPoint());
        }
        if(g!=null) {
            g.setP2(e.getPoint());
        }
        this.canvas.repaint();
        this.clickedP = e.getPoint();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
}
