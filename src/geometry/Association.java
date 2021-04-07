package geometry;
import java.awt.Graphics;

public class Association extends Link{
    private final int barb = 8;
    private final double phi = Math.toRadians(40);
    public Association(Port hPort, Port tPort) {
        this.setHeadPort(hPort);
        this.setTailPort(tPort);
    }
    @Override
    public void draw(Graphics g) {
        int x1 = this.getHead().x;
        int y1 = this.getHead().y;
        int x2 = this.getTail().x;
        int y2 = this.getTail().y;
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
