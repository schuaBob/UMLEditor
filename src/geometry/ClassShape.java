package geometry;

import java.awt.Graphics;
import java.awt.Point;
public class ClassShape extends Shape {
    private Point vertex;
    private final int height = 120;
    private final int width = 100;

    public ClassShape(Point vertex) {
        this.vertex = vertex;
    }

    public void draw(Graphics g) {
        int x = (int) this.vertex.getX();
        int y = (int) this.vertex.getY();
        g.drawRect(x, y, this.width, this.height);
        g.drawLine(x, y + this.height/3, x + this.width, y + this.height/3);
        g.drawLine(x, y + this.height*2/3, x + this.width, y + this.height*2/3);
    }
}
