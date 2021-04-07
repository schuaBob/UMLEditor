package geometry;

import java.awt.Graphics;

public class Generalization extends Link {
    private final int barb = 8;
    private final double phi = Math.toRadians(40);
    public Generalization(Port hPort, Port tPort) {
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
        double rho = theta + phi;
        int[] xPs = new int[2];
        int[] yPs = new int[2];
        for (int j = 0; j < 2; j++) {
            double x = x2 - barb * Math.cos(rho);
            double y = y2 - barb * Math.sin(rho);
            g.drawLine(x2, y2, (int) x, (int) y);
            xPs[j] = (int) x;
            yPs[j] = (int) y;
            rho = theta - phi;
        }
        g.drawLine(xPs[0], yPs[0], xPs[1], yPs[1]);
    }
}
