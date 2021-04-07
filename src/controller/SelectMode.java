package controller;

import geometry.*;
import geometry.Shape;
import view.UMLCanvas;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.event.*;

public class SelectMode extends ModeCore {
    private Point clickedP;
    private int groupIndex = -1;
    SelectMode(UMLCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.canvas.setCurrentShape(null);
        this.clickedP = e.getPoint();
        Iterator<Shape> sIt = Stream.concat(this.canvas.getGroupL().stream(),this.canvas.getAllObjects().stream()).collect(Collectors.toList()).iterator();
        // Iterator<Shape> sIt = this.canvas.getAllObjects().iterator();
        while (sIt.hasNext()) {
            Shape shape = sIt.next();
            if (shape.include(this.clickedP)) {
                this.canvas.setCurrentShape(shape);
                break;
            }
        }
        if (this.canvas.getCurrentShape() == null) {
            Group gp = new Group(e.getPoint(), e.getPoint());
            this.canvas.addGroup(gp);
            groupIndex = this.canvas.getGroupIndex(gp);
        }
        this.canvas.repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Shape obj = this.canvas.getCurrentShape();
        Group g = this.canvas.getGroup(groupIndex);
        if (obj != null) {
            obj.resetLocation(this.clickedP, e.getPoint());
        }
        if (obj==null && g != null) {
            g.setP2(e.getPoint());
        }
        this.canvas.repaint();
        this.clickedP = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Group currentGroup = this.canvas.getGroup(groupIndex);
        if (this.canvas.getCurrentShape()==null && currentGroup != null) {
            Iterator<ObjectFrame> it = this.canvas.getAllObjects().iterator();
            List<Shape> sc = currentGroup.getShapesContain();
            while (it.hasNext()) {
                ObjectFrame of = it.next();
                if (currentGroup.include(of)) {
                    sc.add(of);
                }
            }
            if(sc.size()==0) {
                this.canvas.removeGroup(groupIndex);
            }
        }
        canvas.repaint();
    }
}
