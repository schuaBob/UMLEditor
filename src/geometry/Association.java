package geometry;
import java.awt.Graphics;

public class Association extends Link{
    private final int barb = 8;
    private final double phi = Math.toRadians(40);
    public Association(Port startP, Port endP) {
        this.setStartP(startP);
        this.setEndP(endP);
    }
    @Override
    public void draw(Graphics g) {
        int x1 = this.getStartX();
        int y1 = this.getStartY();
        int x2 = this.getEndX();
        int y2 = this.getEndY();
        g.drawLine(x1, y1, x2, y2);
        double theta = Math.atan2((y2 - y1), (x2 - x1));
        double x, y, rho = theta + phi;
        for (int j = 0; j < 2; j++) {
            x = x2 - barb * Math.cos(rho);
            y = y2 - barb * Math.sin(rho);
            g.drawLine(x2, y2, (int) x, (int) y);
            rho = theta - phi;
        }
    }
}
