package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Group extends Shape {
    protected Point p1;
    protected Point p2;
    private List<Shape> ShapesContain = new ArrayList<Shape>();

    public Group(Point p1, Point p2) {
        setP1(p1);
        setP2(p2);
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public List<Shape> getShapesContain() {
        return this.ShapesContain;
    }

    public Boolean include(ObjectFrame of) {
        Boolean result = false;
        if (((this.p1.getX() <= of.x) && (this.p1.getY() <= of.y))
                && ((this.p2.getX() >= of.x + of.width) && (this.p2.getY() >= of.y + of.height))) {
            result = true;
        }
        return result;
    }

    public Boolean include(Point p) {
        Boolean result = false;
        if ((this.p1.getX() <= p.getX() && p.getX() <= this.p2.getX())
                && (this.p1.getY() <= p.getY() && p.getY() <= this.p2.getY())) {
            result = true;
        }
        return result;
    }

    @Override
    public void draw(Graphics g) {
        int alpha = 80;
        Color c = g.getColor();
        g.setColor(new Color(255, 140, 100, alpha));
        g.fillRect((int) p1.getX(), (int) p1.getY(), (int) (p2.getX() - p1.getX()), (int) (p2.getY() - p1.getY()));
        g.setColor(new Color(255, 140, 100));
        g.drawRect((int) p1.getX(), (int) p1.getY(), (int) (p2.getX() - p1.getX()), (int) (p2.getY() - p1.getY()));
        g.setColor(c);
    }

    @Override
    public void resetLocation(Point previous, Point now) {
        int dx = (int) (now.getX() - previous.getX());
        int dy = (int) (now.getY() - previous.getY());
        this.p1.translate(dx, dy);
        this.p2.translate(dx, dy);
        for (Shape s : ShapesContain) {
            s.resetLocation(previous, now);
        }
    }

    @Override
    public void showPorts(Graphics g) {
        for (Shape s : ShapesContain) {
            s.showPorts(g);
        }
    }
}
