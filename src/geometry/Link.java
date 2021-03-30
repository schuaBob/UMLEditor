package geometry;
import java.awt.Point;
public abstract class Link extends Shape{
    protected Port startP;
    protected Port endP;
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    public void setStartP(Port startP) {
        startP.getConnectList().add(this);
        this.startP = startP;
        this.x1 = (int) startP.getVertex().getX();
        this.y1 = (int) startP.getVertex().getY();
    }
    public void setEndP(Port endP) {
        endP.getConnectList().add(this);
        this.endP = endP;
        this.x2 = (int) endP.getVertex().getX();
        this.y2 = (int) endP.getVertex().getY();
    }
    public Point getStartP() {
        return this.startP.getVertex();
    }
    public Point getEndP() {
        return this.endP.getVertex();
    }
    public int getStartX() {
        return this.x1;
    }
    public int getStartY() {
        return this.y1;
    }
    public int getEndX() {
        return this.x2;
    }
    public int getEndY() {
        return this.y2;
    }
    public void resetPoints(Point p1, Point p2) {
        this.x1 = (int) p1.getX();
        this.y1 = (int) p1.getY();
        this.x2 = (int) p2.getX();
        this.y2 = (int) p2.getY();
    }
    @Override
    public void resetLocation() {
        this.x1 = (int) startP.getVertex().getX();
        this.y1 = (int) startP.getVertex().getY();
        this.x2 = (int) endP.getVertex().getX();
        this.y2 = (int) endP.getVertex().getY();
    }
}
