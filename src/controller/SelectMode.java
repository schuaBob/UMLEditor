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

    SelectMode(UMLCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.canvas.setCurrentShape(null);
        this.clickedP = e.getPoint();
        Iterator<Shape> shapeIt = this.getShapeIt();
        while (shapeIt != null && shapeIt.hasNext()) {
            Shape shape = shapeIt.next();
            if (shape.include(this.clickedP)) {
                this.canvas.setCurrentShape(shape);
                break;
            }
        }
        this.canvas.repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Shape obj = this.canvas.getCurrentShape();
        if (obj == null) {
            Group gp = new Group(this.clickedP, this.clickedP);
            this.canvas.setCurrentShape(gp);
        } else if (this.canvas.containShape(obj)) {
            // group or shape is already added to canvas, resetLocation
            obj.resetLocation(this.clickedP, e.getPoint());
        } else {
            // currentShape isn't added to canvas, which is a group, resize
            obj.setTail(e.getPoint());
        }
        this.clickedP = e.getPoint();
        this.canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Shape obj = this.canvas.getCurrentShape();
        if (obj != null && !this.canvas.containShape(obj)) {
            Group gObj = ((Group) obj);
            Iterator<Group> groupIt = this.canvas.getGroupL().iterator();
            List<Shape> sc = ((Group) obj).getShapesContain();
            while (groupIt.hasNext()) {
                Group g = groupIt.next();
                if (gObj.include(g)) {
                    sc.add(g);
                }
            }
            Iterator<ObjectFrame> shapeIt = this.canvas.getAllObjects().iterator();
            List<Shape> sL = new LinkedList<Shape>();
            while (shapeIt.hasNext()) {
                ObjectFrame oFrame = shapeIt.next();
                if(gObj.include(oFrame)){
                    if (sc.size() == 0 || !gObj.duplicate(oFrame)) {
                        sL.add(oFrame);
                    }
                }
            }
            sc.addAll(sL);
            if (sc.size() <= 1) {
                this.canvas.setCurrentShape(null);
            }
        }
        canvas.repaint();
    }

    private Iterator<Shape> getShapeIt() {
        return Stream.concat(this.canvas.getGroupL().stream(), this.canvas.getAllObjects().stream())
                .sorted(Comparator.comparingInt(Shape::getDepth).reversed()).collect(Collectors.toList()).iterator();
    }
}
