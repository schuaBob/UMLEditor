package geometry;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class ClassShape extends Shape {
    private Point vertex;
    private final int height = 120;
    private final int width = 100;

    ClassShape(Point vertex) {
        this.vertex = vertex;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(this.vertex.getX(), this.vertex.getY(), this.width, this.height);
        g2d.drawLine(this.vertex.getX(), this.vertex.getY() + this.height/3, this.vertex.getX() + this.width, this.vertex.getY() + this.height/3);
        g2d.drawLine(this.vertex.getX(), this.vertex.getY() + this.height*2/3, this.vertex.getX() + this.width, this.vertex.getY() + this.height*2/3);
    }
}
