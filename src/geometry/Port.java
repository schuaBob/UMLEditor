package geometry;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
public class Port {
    private Point vertex;
    private Point drawingPoint;
    private List<Link> connectList = new ArrayList<Link>();


    public void setPoint(double x, double y, double offsetX, double offsetY) {
        this.vertex = new Point((int) x, (int) y);
        this.drawingPoint = new Point((int) (x + offsetX), (int) (y + offsetY));
    }
    public List<Link> getConnectList() {
        return connectList;
    }
    public void setConnectList(List<Link> connectList) {
        this.connectList = connectList;
    }
    public Point getDrawingPoint() {
        return drawingPoint;
    }

    public Point getVertex() {
        return vertex;
    }

    public void reConnectLines() {
        for (Link l : this.connectList) {
            l.resetLocation();
        }
    }
}
