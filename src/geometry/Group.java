package geometry;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public class Group extends Shape {
    protected Point p1;
    protected Point p2;
    private List<Shape> ShapesContain = new ArrayList<Shape>();
    public Group(Point p1, Point p2) {
        this.x = (int) p1.getX();
        this.y = (int) p1.getY();
        setP1(p1);
        setP2(p2);

    }
    public void setP1(Point p1) {
        this.p1 = p1;
    }
    public void setP2(Point p2) {
        this.p2 = p2;
    }
    @Override
    public void draw(Graphics g) {
        g.drawRect((int) p1.getX(), (int) p1.getY(), (int) (p2.getX()-p1.getX()), (int) (p2.getY()-p1.getY()));
    }
}
