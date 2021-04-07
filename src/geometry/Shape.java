package geometry;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public abstract class Shape {
    protected Point head;
    protected Point tail;
    protected int depth;

    public void draw(Graphics g) {
    };

    public Point getHead() {
        return this.head;
    }

    public Point getTail() {
        return this.tail;
    }

    public void setHead(Point head) {
        this.head = head;
    }

    public void setTail(Point tail) {
        this.tail = tail;
    }

    public void setDepth(List<ObjectFrame> shapeL, List<Group> groupL) {
        if (shapeL.size() == 0 && groupL.size() == 0) {
            this.depth = 0;
        } else if (groupL.size() == 0) {
            this.depth = shapeL.get(shapeL.size() - 1).depth + 1;
        } else if (shapeL.size() == 0) {
            this.depth = groupL.get(groupL.size() - 1).depth + 1;
        } else {
            this.depth = Math.max(groupL.get(groupL.size() - 1).depth, shapeL.get(shapeL.size() - 1).depth) + 1;
        }
    }

    public int getDepth() {
        return this.depth;
    }

    public void resetLocation(Point previous, Point now) {

    }

    public void resetLocation() {

    };

    public Boolean include(Point p) {
        Boolean result = false;
        if (((this.head.getX() <= p.getX()) && (p.getX() <= this.tail.getX()))
                && ((this.head.getY() <= p.getY()) && (p.getY() <= this.tail.getY()))) {
            result = true;
        }
        return result;
    }

    public void showPorts(Graphics g) {
    };
}
