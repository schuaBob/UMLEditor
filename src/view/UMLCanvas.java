package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controller.ModeCore;
import geometry.*;
import java.util.*;

public class UMLCanvas extends JPanel {

    private static final long serialVersionUID = 6555233771629347251L;
    private static List<UMLCanvas> canvasList = new ArrayList<UMLCanvas>();
    private List<ObjectFrame> shapeL = new LinkedList<ObjectFrame>();
    private List<Link> linkL = new ArrayList<Link>();
    private List<Group> groupL = new ArrayList<Group>();
    private Shape selectedShape = null;
    private ModeCore currentMode = null;
    private final int maxDepth = 99;

    private UMLCanvas() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }

    public static UMLCanvas getInstance() {
        if (canvasList.isEmpty()) {
            canvasList.add(new UMLCanvas());
        }
        return canvasList.get(0);
    }

    public void setMode(ModeCore mode) {
        this.removeMouseListener(this.currentMode);
        this.removeMouseMotionListener(this.currentMode);
        this.currentMode = mode;
        if (mode != null) {
            this.addMouseListener(this.currentMode);
            this.addMouseMotionListener(this.currentMode);
        }
    }
    public void addShape(ObjectFrame oFrame){
        oFrame.setDepth(shapeL, groupL);
        if(oFrame.getDepth()<=this.maxDepth) {
            this.shapeL.add(oFrame);
        }
    }

    public List<ObjectFrame> getAllObjects() {
        return this.shapeL;
    }

    public void setCurrentShape(Shape s) {
        this.selectedShape = s;
    }

    public List<Group> getGroupL() {
        return this.groupL;
    }

    public Shape getCurrentShape() {
        return this.selectedShape;
    }

    public void addShape(Link l) {
        this.linkL.add(l);
    }

    public Link getLink(int i) {
        while (i < 0) {
            i = this.linkL.size() + i;
        }
        return this.linkL.get(i);
    }

    public void removeLink(int i) {
        while (i < 0) {
            i = this.linkL.size() + i;
        }
        this.linkL.remove(i);
    }

    public void addShape(Group g) {
        g.setDepth(this.shapeL, this.groupL);
        if(g.getDepth()<=this.maxDepth){
            this.groupL.add(g);
        }
    }

    public Boolean containShape(Shape s){
        return this.groupL.contains(s)||this.shapeL.contains(s);
    }

    public void removeShape(Group g) {
        this.groupL.remove(g);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Iterator<ObjectFrame> sqIt = shapeL.iterator();
        while (sqIt.hasNext()) {
            Shape s = sqIt.next();
            s.draw(g);
        }
        Iterator<Link> lIt = linkL.iterator();
        while (lIt.hasNext()) {
            Link l = lIt.next();
            l.draw(g);
        }
        Iterator<Group> gIt = groupL.iterator();
        while (gIt.hasNext()) {
            Group gp = gIt.next();
            gp.draw(g);
        }
        // show ports if select
        if (this.selectedShape != null) {
            this.selectedShape.draw(g);
            this.selectedShape.showPorts(g);
        }
    }

}
