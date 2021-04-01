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
    private Queue<ObjectFrame> ofQ = new LinkedList<ObjectFrame>();
    private List<Link> linkL = new ArrayList<Link>();
    private List<Group> groupL = new ArrayList<Group>();
    private Shape selectedShape = null;
    private ModeCore currentMode = null;
    private Group selectedGroup = null;

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

    public void addObject(ObjectFrame of) {
        this.ofQ.add(of);
    }

    public Queue<ObjectFrame> getAllObjects() {
        return this.ofQ;
    }

    public void setCurrentShape(Shape s) {
        this.selectedShape = s;
    }

    public Shape getCurrentShape() {
        return this.selectedShape;
    }

    public void addLink(Link l) {
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
    public void addGroup(Group g) {
        this.groupL.add(g);
    }
    public void setSelectedGroup(Group selectedGroup) {
        this.selectedGroup = selectedGroup;
    }
    public Group getSelectedGroup() {
        return selectedGroup;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Iterator<ObjectFrame> sqIt = ofQ.iterator();
        while (sqIt.hasNext()) {
            Shape s = sqIt.next();
            s.draw(g);
        }
        Iterator<Link> lIt = linkL.iterator();
        while (lIt.hasNext()) {
            Link l = lIt.next();
            l.draw(g);
        }

        // show ports if select
        if (this.selectedShape != null) {
            ((ObjectFrame) this.selectedShape).showPorts(g);
        }
    }

}
