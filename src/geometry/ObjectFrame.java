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
    private List<Port> portList = new ArrayList<Port>(Arrays.asList(new Port(), new Port(), new Port(), new Port()));
    // private List<Shape> connected = new ArrayList<Shape>();

    public Boolean include(Point p) {
        Boolean result = false;
        if ((this.x <= p.getX() && p.getX() <= this.x + this.width)
                && (this.y <= p.getY() && p.getY() <= this.y + this.height)) {
            result = true;
        }
        return result;
    }
    public void setPorts() {
        // List<Port> tempList = new ArrayList<Port>();
        // tempList.add(new Port(this.x + this.width / 2 , this.y, - this.offset / 2, - this.offset));
        // tempList.add(new Port(this.x + this.width, this.y + this.height / 2 ,0,- this.offset / 2));
        // tempList.add(new Port(this.x + this.width / 2 , this.y + this.height, - this.offset / 2,0));
        // tempList.add(new Port(this.x, this.y + this.height / 2,  - this.offset,  - this.offset / 2));
        this.portList.get(0).setPoint(this.x + this.width / 2 , this.y, - this.offset / 2, - this.offset);
        this.portList.get(1).setPoint(this.x + this.width, this.y + this.height / 2 ,0,- this.offset / 2);
        this.portList.get(2).setPoint(this.x + this.width / 2 , this.y + this.height, - this.offset / 2,0);
        this.portList.get(3).setPoint(this.x, this.y + this.height / 2,  - this.offset,  - this.offset / 2);
        // for(int i=0;i<portList.size();i++) {
        //     tempList.get(i).setConnectList(this.portList.get(i).getConnectList());
        // }
        // portList.clear();
    }
    public void showPorts(Graphics g) {
        for(Port p: portList) {
            g.fillRect((int) p.getDrawingPoint().getX(), (int) p.getDrawingPoint().getY(), this.offset, this.offset);
        }
    }
    @Override
    public void resetLocation(Point previous, Point now) {
        double x = now.getX() - previous.getX();
        double y = now.getY() - previous.getY();
        this.setPoint(this.x+x, this.y+y);
        this.setPorts();
        for(Port p:portList) {
            p.reConnectLines();
        }
    }
    public Port getPort(int i) {
        return this.portList.get(i);
    }
    public int getQuadrant(Point p) {
        // X
        double m = (double) this.height/this.width;
        // x, y
        // x+width, y+height
        double num1 = (m * (p.getX() - x)) + (y - p.getY());
        // x, y+height
        // x+width, y
        double num2 = -m * (p.getX() - x) + this.height + y - p.getY();
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
