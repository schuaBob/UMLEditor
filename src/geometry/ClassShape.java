package geometry;

import java.awt.Graphics;
import java.awt.Point;
public class ClassShape extends Shape {
    private final int height = 120;
    private final int width = 100;

    public ClassShape(Point vertex) {
        super(vertex);
    }

    public void draw(Graphics g) {
        g.drawRect(super.x, super.y, this.width, this.height);
        g.drawLine(super.x, super.y + this.height/3, super.x + this.width, super.y + this.height/3);
        g.drawLine(super.x, super.y + this.height*2/3, super.x + this.width, super.y + this.height*2/3);
    }
}
