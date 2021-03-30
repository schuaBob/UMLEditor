package controller;

import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import geometry.*;
import view.UMLCanvas;
import java.awt.Point;

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
            case "select":
                mode = new SelectMode();
                break;
            case "association":
                mode = new AssociationMode();
                break;
            case "generalization":
                mode = new GeneralizationMode();
                break;
            case "composition":
                mode = new CompositionMode();
                break;
            default:
                break;
        }
        return mode;
    }


    private class ClassMode extends ModeCore{
        @Override
        public void mousePressed(MouseEvent e) {
            ObjectFrame obj = new ClassShape(e.getPoint());
            obj.setPorts();
            canvas.addObject(obj);
            canvas.repaint();
        }
    }

    private class UseCaseMode extends ModeCore {
        @Override
        public void mousePressed(MouseEvent e) {
            ObjectFrame obj = new UseCaseShape(e.getPoint());
            obj.setPorts();
            canvas.addObject(obj);
            canvas.repaint();
        }
    }
    private class SelectMode extends ModeCore {
        private Point clickedP;
        private Queue<ObjectFrame> shapeQ = new LinkedList<ObjectFrame>();
        @Override
        public void mousePressed(MouseEvent e) {
            this.clickedP = e.getPoint();
            this.shapeQ = canvas.getAllObjects();
            Boolean selected = false;
            Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
            while(sqIt.hasNext()) {
                ObjectFrame of = (ObjectFrame) sqIt.next();
                if(of.include(this.clickedP)) {
                    canvas.setCurrentShape(of);   
                    selected = true;               
                    break;
                }
            }
            if(!selected) {
                canvas.setCurrentShape(null);
            }
            canvas.repaint();
            
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            Shape obj = canvas.getCurrentShape();
            if(obj!= null) {
                ((ObjectFrame) obj).resetLocation(this.clickedP, e.getPoint());
            }
            canvas.repaint();
            this.clickedP = e.getPoint();
        }
    }
    
    private class AssociationMode extends ModeCore{
        private Link tempLink = null;
        private Queue<ObjectFrame> shapeQ = new LinkedList<ObjectFrame>();
        @Override
        public void mousePressed(MouseEvent e) {
            this.shapeQ = canvas.getAllObjects();
            Point currentP = e.getPoint();
            Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
            while(sqIt.hasNext()) {
                ObjectFrame of = sqIt.next();
                if(of.include(currentP)) {
                    int q = of.getQuadrant(currentP);
                    Link aLink = new Association(of.getPort(q), of.getPort(q));
                    canvas.addLink(aLink);
                    tempLink = aLink;
                    canvas.repaint();
                    break;
                }
            }
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            this.shapeQ = canvas.getAllObjects();
            Point currentP = e.getPoint();
            Link l = canvas.getLink(-1);
            l.resetPoints(l.getStartP(), currentP);;
            canvas.repaint();
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            if(this.tempLink!=null) {
                this.shapeQ = canvas.getAllObjects();
                Point currentP = e.getPoint();
                Boolean inBound = false;
                Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
                while(sqIt.hasNext()) {
                    ObjectFrame of = sqIt.next();
                    if(of.include(currentP)) {
                        int q = of.getQuadrant(currentP);
                        Link l = canvas.getLink(-1);
                        Boolean sameObj =false;
                        for(int i=0;i<4;i++) {
                            if(of.getPort(i).getConnectList().contains(l)) {
                                sameObj = true;
                                break;
                            }
                        }
                        if(!sameObj) {
                            l.setEndP(of.getPort(q));
                            inBound = true;
                        }
                        break;
                    }
                }
                if (!inBound) {
                    canvas.removeLink(-1);
                }
                this.tempLink = null;
                canvas.repaint();
            }
        }
    }

    private class GeneralizationMode extends ModeCore{
        private Link tempLink = null;
        private Queue<ObjectFrame> shapeQ = new LinkedList<ObjectFrame>();
        @Override
        public void mousePressed(MouseEvent e) {
            this.shapeQ = canvas.getAllObjects();
            Point currentP = e.getPoint();
            Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
            while(sqIt.hasNext()) {
                ObjectFrame of = sqIt.next();
                if(of.include(currentP)) {
                    int q = of.getQuadrant(currentP);
                    Link aLink = new Generalization(of.getPort(q), of.getPort(q));
                    canvas.addLink(aLink);
                    tempLink = aLink;
                    canvas.repaint();
                    break;
                }
            }
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            this.shapeQ = canvas.getAllObjects();
            Point currentP = e.getPoint();
            Link l = canvas.getLink(-1);
            l.resetPoints(l.getStartP(), currentP);;
            canvas.repaint();
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            if(this.tempLink!=null) {
                this.shapeQ = canvas.getAllObjects();
                Point currentP = e.getPoint();
                Boolean inBound = false;
                Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
                while(sqIt.hasNext()) {
                    ObjectFrame of = sqIt.next();
                    if(of.include(currentP)) {
                        int q = of.getQuadrant(currentP);
                        Link l = canvas.getLink(-1);
                        Boolean sameObj =false;
                        for(int i=0;i<4;i++) {
                            if(of.getPort(i).getConnectList().contains(l)) {
                                sameObj = true;
                                break;
                            }
                        }
                        if(!sameObj) {
                            l.setEndP(of.getPort(q));
                            inBound = true;
                        }
                        break;
                    }
                }
                if (!inBound) {
                    canvas.removeLink(-1);
                }
                this.tempLink = null;
                canvas.repaint();
            }
        }
    }
    private class CompositionMode extends ModeCore{
        private Link tempLink = null;
        private Queue<ObjectFrame> shapeQ = new LinkedList<ObjectFrame>();
        @Override
        public void mousePressed(MouseEvent e) {
            this.shapeQ = canvas.getAllObjects();
            Point currentP = e.getPoint();
            Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
            while(sqIt.hasNext()) {
                ObjectFrame of = sqIt.next();
                if(of.include(currentP)) {
                    int q = of.getQuadrant(currentP);
                    Link aLink = new Composition(of.getPort(q), of.getPort(q));
                    canvas.addLink(aLink);
                    tempLink = aLink;
                    canvas.repaint();
                    break;
                }
            }
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            this.shapeQ = canvas.getAllObjects();
            Point currentP = e.getPoint();
            Link l = canvas.getLink(-1);
            l.resetPoints(l.getStartP(), currentP);;
            canvas.repaint();
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            if(this.tempLink!=null) {
                this.shapeQ = canvas.getAllObjects();
                Point currentP = e.getPoint();
                Boolean inBound = false;
                Iterator<ObjectFrame> sqIt = this.shapeQ.iterator();
                while(sqIt.hasNext()) {
                    ObjectFrame of = sqIt.next();
                    if(of.include(currentP)) {
                        int q = of.getQuadrant(currentP);
                        Link l = canvas.getLink(-1);
                        Boolean sameObj =false;
                        for(int i=0;i<4;i++) {
                            if(of.getPort(i).getConnectList().contains(l)) {
                                sameObj = true;
                                break;
                            }
                        }
                        if(!sameObj) {
                            l.setEndP(of.getPort(q));
                            inBound = true;
                        }
                        break;
                    }
                }
                if (!inBound) {
                    canvas.removeLink(-1);
                }
                this.tempLink = null;
                canvas.repaint();
            }
        }
    }
    
}
