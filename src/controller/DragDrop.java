package controller;
import geometry.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Point;
import java.lang.reflect.*;
public abstract class DragDrop extends ModeCore {
    private Link tempLink = null;
    private List<ObjectFrame> shapeQ = new LinkedList<ObjectFrame>();
    private Constructor<?> cLink;
    DragDrop(String className){
        try {
            this.cLink = Class.forName(className).getConstructor(Port.class, Port.class);
        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        this.shapeQ = this.canvas.getAllObjects();
        Point currentP = e.getPoint();
        Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
        while (sqIt.hasNext()) {
            ObjectFrame of = sqIt.next();
            if (of.include(currentP)) {
                int q = of.getQuadrant(currentP);
                Link aLink;
                try {
                    aLink = (Link) this.cLink.newInstance(of.getPort(q), of.getPort(q));
                    this.canvas.addShape(aLink);
                    tempLink = aLink;
                    this.canvas.repaint();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.shapeQ = this.canvas.getAllObjects();
        Link l = this.canvas.getLink(-1);
        l.setTail(e.getPoint());
        this.canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.tempLink != null) {
            this.shapeQ = this.canvas.getAllObjects();
            Point currentP = e.getPoint();
            Boolean inBound = false;
            Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
            while (sqIt.hasNext()) {
                ObjectFrame of = sqIt.next();
                if (of.include(currentP)) {
                    int q = of.getQuadrant(currentP);
                    Link l = this.canvas.getLink(-1);
                    Boolean sameObj = false;
                    for (int i = 0; i < 4; i++) {
                        if (of.getPort(i).getConnectList().contains(l)) {
                            sameObj = true;
                            break;
                        }
                    }
                    if (!sameObj) {
                        l.setTailPort(of.getPort(q));
                        inBound = true;
                    }
                    break;
                }
            }
            if (!inBound) {
                this.canvas.removeLink(-1);
            }
            this.tempLink = null;
            this.canvas.repaint();
        }
    }
}
