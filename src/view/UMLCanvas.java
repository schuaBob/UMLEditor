package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controller.ModeCore;
import geometry.Link;
import geometry.ObjectFrame;
import geometry.Shape;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UMLCanvas extends JPanel{

    private static final long serialVersionUID = 6555233771629347251L;
    private static List<UMLCanvas> canvasList = new ArrayList<UMLCanvas>();
    private Queue<ObjectFrame> ofQ = new LinkedList<ObjectFrame>();
    private List<Link> linkQ = new ArrayList<Link>();
    private Shape selectedShape;
    private ModeCore currentMode;
    private UMLCanvas() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }
    public static UMLCanvas getInstance() {
        if(canvasList.isEmpty()) {
            canvasList.add(new UMLCanvas());
        }
        return canvasList.get(0);
    }

    public void setMode(ModeCore mode) {
        this.removeMouseListener(this.currentMode);
        this.removeMouseMotionListener(this.currentMode);
        this.currentMode = mode;
        if(mode != null) {
            this.addMouseListener(this.currentMode);
            this.addMouseMotionListener(this.currentMode);
        }
    }

    public void addObject(ObjectFrame of) {
        this.ofQ.add(of);
    }
    public Queue<ObjectFrame> getAllObjects() {
        return this.ofQ;
    }
    public void setCurrentShape(Shape s){
        this.selectedShape = s;
    }
    public Shape getCurrentShape() {
        return this.selectedShape;
    }
    public void addLink(Link l) {
        this.linkQ.add(l);
    }
    public Link getLink(int i) {
        while(i<0) {
            i = this.linkQ.size() + i;
        }
        return this.linkQ.get(i);
    }
    public void removeLink(int i) {
        while(i<0) {
            i = this.linkQ.size() + i;
        }
        this.linkQ.remove(i);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Iterator<ObjectFrame> sqIt = ofQ.iterator();
        while(sqIt.hasNext()) {
            Shape s = sqIt.next();
            s.draw(g);
        }
        Iterator<Link> lIt = linkQ.iterator();
        while(lIt.hasNext()) {
            Link l = lIt.next();
            l.draw(g);
        }

        // show ports if select
        if(this.selectedShape!=null) {
            ((ObjectFrame) this.selectedShape).showPorts(g);;
        }
    }

}
