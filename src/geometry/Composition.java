package geometry;
import java.awt.Graphics;

public class Composition extends Link{
    private final int barb = 8;
    private final double phi = Math.toRadians(40);
    public Composition(Port startP, Port endP) {
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
        double rho = theta + phi;
        double x = x2 - barb * Math.cos(rho);
        double y = y2 - barb * Math.sin(rho);
        g.drawLine(x2, y2, (int) x, (int) y);
        x = x2 - barb * Math.cos(theta-phi);
        y = y2 - barb * Math.sin(theta-phi);
        g.drawLine((int) x, (int) y,(int) (x - barb * Math.cos(rho)),(int) (y - barb * Math.sin(rho)));
        rho = theta - phi;
        x = x2 - barb * Math.cos(rho);
        y = y2 - barb * Math.sin(rho);
        g.drawLine(x2, y2, (int) x, (int) y);
        x = x2 - barb * Math.cos(theta+phi);
        y = y2 - barb * Math.sin(theta+phi);
        g.drawLine((int) x, (int) y,(int) (x - barb * Math.cos(rho)),(int) (y - barb * Math.sin(rho)));

    }
}
