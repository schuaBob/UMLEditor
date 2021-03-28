package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controller.ModeCore;
import geometry.Shape;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UMLCanvas extends JPanel{

    private static final long serialVersionUID = 6555233771629347251L;
    private static List<UMLCanvas> canvasList = new ArrayList<UMLCanvas>();
    private Queue<Shape> shapeQ = new LinkedList<Shape>();
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

    public void addShape(Shape s) {
        this.shapeQ.add(s);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Iterator<Shape> sqIt = shapeQ.iterator();
        while(sqIt.hasNext()) {
            Shape s = sqIt.next();
            s.draw(g);
        }
    }

}
