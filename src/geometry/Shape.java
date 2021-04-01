package geometry;
import java.awt.Graphics;
import java.awt.Point;
public abstract class Shape {
    protected int x;
    protected int y;
    public void draw(Graphics g){};
    public void setPoint(Point p) {
        this.x = (int) p.getX();
        this.y = (int) p.getY();
    }
    public void setPoint(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }
    public void resetLocation(Point previous, Point now) {
        
    }
    public void resetLocation(){
        
    };
}
