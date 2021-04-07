package geometry;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.awt.Graphics;

public abstract class ObjectFrame extends Shape {
    protected int height;
    protected int width;
    private final int offset = 5;
    private String name = null;
    private List<Port> portList = new ArrayList<Port>(Arrays.asList(new Port(), new Port(), new Port(), new Port()));

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPorts() {
        int x = (int) this.head.getX();
        int y = (int) this.head.getY();
        this.portList.get(0).setPoint(x + this.width / 2, y, -this.offset / 2, -this.offset);
        this.portList.get(1).setPoint(x + this.width, y + this.height / 2, 0, -this.offset / 2);
        this.portList.get(2).setPoint(x + this.width / 2, y + this.height, -this.offset / 2, 0);
        this.portList.get(3).setPoint(x, y + this.height / 2, -this.offset, -this.offset / 2);
    }

    @Override
    public void showPorts(Graphics g) {
        for (Port p : portList) {
            g.fillRect((int) p.getDrawingPoint().getX(), (int) p.getDrawingPoint().getY(), this.offset, this.offset);
        }
    }

    @Override
    public void resetLocation(Point clickedPoint, Point now) {
        int dx = (int) (now.getX() - clickedPoint.getX());
        int dy = (int) (now.getY() - clickedPoint.getY());
        this.head.translate(dx, dy);
        this.setPorts();
        for (Port p : portList) {
            p.reConnectLines();
        }
    }

    public Port getPort(int i) {
        return this.portList.get(i);
    }

    public int getQuadrant(Point p) {
        double m = (double) this.height / this.width;
        // x, y
        // x+width, y+height
        double num1 = (m * (p.getX() - this.head.getX())) + (this.head.getY() - p.getY());
        // x, y+height
        // x+width, y
        double num2 = -m * (p.getX() - this.head.getX()) + this.height + this.head.getY() - p.getY();
        int result = 3;
        if (num1 > 0 && num2 > 0) {
            result = 0;
        } else if (num1 > 0 && num2 < 0) {
            result = 1;
        } else if (num1 < 0 && num2 < 0) {
            result = 2;
        } else if (num1 < 0 && num2 > 0) {
            result = 3;
        }
        return result;
    }

}
