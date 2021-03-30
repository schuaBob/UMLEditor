package geometry;

import java.awt.Graphics;
import java.awt.Point;

public class UseCaseShape extends ObjectFrame {
    public UseCaseShape(Point vertex) {
        this.height = 80;
        this.width = 100;
        this.x = (int) vertex.getX();
        this.y = (int) vertex.getY();
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(this.x, this.y, this.width, this.height);
    }
}
