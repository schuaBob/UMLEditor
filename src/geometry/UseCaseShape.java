package geometry;
import java.awt.Graphics;
import java.awt.Point;
public class UseCaseShape extends Shape{
    private final int width = 100;
    private final int height = 80;
    public UseCaseShape(Point vertex) {
        super(vertex);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(super.x, super.y, width, height);
    }
}
