package geometry;

import java.awt.Graphics;
import java.awt.Point;

public class ClassShape extends ObjectFrame {

    public ClassShape(Point vertex) {
        this.height = 120;
        this.width = 100;
        this.x = (int) vertex.getX();
        this.y = (int) vertex.getY();
    }

    public void draw(Graphics g) {
        g.drawRect(this.x, this.y, this.width, this.height);
        g.drawLine(this.x, this.y + this.height / 3, this.x + this.width, this.y + this.height / 3);
        g.drawLine(this.x, this.y + this.height * 2 / 3, this.x + this.width, this.y + this.height * 2 / 3);
        if(this.getName()!=null) {
            g.drawString(this.getName(), this.x+2, this.y+this.height/6);
        }
    }
}
