package geometry;
import java.awt.Graphics;
import java.awt.Point;
public abstract class Shape {
    protected int x;
    protected int y;
    public abstract void draw(Graphics g);
    Shape(Point vertex) {
        this.x = (int) vertex.getX();
        this.y = (int) vertex.getY();
    }
}
