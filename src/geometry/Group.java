package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Group extends Shape {
    private List<Shape> ShapesContain = new ArrayList<Shape>();

    public Group(Point head, Point tail) {
        this.head = head;
        this.tail = tail;
    }

    public List<Shape> getShapesContain() {
        return this.ShapesContain;
    }

    public Boolean include(Shape s) {
        Boolean result = false;
        if (((this.head.getX() <= s.head.getX()) && (this.head.getY() <= s.head.getY()))
                && (((this.tail.getX() >= s.tail.getX()) &&( this.tail.getY() >= s.tail.getY())))) {
            result = true;
        }
        return result;
    }

    public Boolean duplicate(ObjectFrame oFrame){
        Boolean result = false;
        for(Shape s:ShapesContain) {
            if(((Group) s).getShapesContain().contains(oFrame)){
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void draw(Graphics g) {
        int alpha = 80;
        Color c = g.getColor();
        g.setColor(new Color(255, 140, 100, alpha));
        g.fillRect((int) head.getX(), (int) head.getY(), (int) (tail.getX() - head.getX()), (int) (tail.getY() - head.getY()));
        g.setColor(new Color(255, 140, 100));
        g.drawRect((int) head.getX(), (int) head.getY(), (int) (tail.getX() - head.getX()), (int) (tail.getY() - head.getY()));
        g.setColor(c);
    }

    @Override
    public void resetLocation(Point clickedPoint, Point now) {
        int dx = (int) (now.getX() - clickedPoint.getX());
        int dy = (int) (now.getY() - clickedPoint.getY());
        this.head.translate(dx, dy);
        this.tail.translate(dx, dy);
        for (Shape s : ShapesContain) {
            s.resetLocation(clickedPoint, now);
        }
    }

    @Override
    public void showPorts(Graphics g) {
        for (Shape s : ShapesContain) {
            s.showPorts(g);
        }
    }
}
