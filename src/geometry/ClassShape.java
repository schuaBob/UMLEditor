package geometry;

import java.awt.Graphics;
import java.awt.Point;

public class ClassShape extends ObjectFrame {

    public ClassShape(Point vertex) {
        this.height = 120;
        this.width = 100;
        this.head = vertex;
        this.tail = new Point((int) (vertex.getX()+this.width), (int) (vertex.getY()+this.height));
    }

    public void draw(Graphics g) {
        // draw shape
        int x = (int) this.head.getX();
        int y = (int) this.head.getY();
        g.drawRect(x, y, this.width, this.height);
        g.drawLine(x, y + this.height / 3, x + this.width, y + this.height / 3);
        g.drawLine(x, y + this.height * 2 / 3, x + this.width, y + this.height * 2 / 3);

        // draw name
        if (this.getName() != null) {
            g.drawString(this.getName(), x + 2, y + this.height / 6);
        }
    }
}
