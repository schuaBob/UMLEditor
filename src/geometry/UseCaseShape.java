package geometry;

import java.awt.Graphics;
import java.awt.Point;

public class UseCaseShape extends ObjectFrame {
    public UseCaseShape(Point vertex) {
        this.height = 80;
        this.width = 100;
        this.head = vertex;
        this.tail = new Point((int) (vertex.getX()+this.width), (int) (vertex.getY()+this.height));
    }

    @Override
    public void draw(Graphics g) {
        // draw shape
        int x = (int) this.head.getX();
        int y = (int) this.head.getY();
        g.drawOval(x, y, this.width, this.height);

        // draw name
        if (this.getName() != null) {
            g.drawString(this.getName(), x + 2, y + this.height / 2);
        }
    }
}
