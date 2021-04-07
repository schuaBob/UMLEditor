package geometry;

public class Link extends Shape {
    protected Port headPort;
    protected Port tailPort;

    public void setHeadPort(Port hPort) {
        hPort.getConnectList().add(this);
        this.headPort = hPort;
        this.setHead(hPort.getVertex());
    }

    public void setTailPort(Port tPort) {
        tPort.getConnectList().add(this);
        this.tailPort = tPort;
        this.setTail(tPort.getVertex());
    }

    @Override
    public void resetLocation() {
        this.head = this.headPort.getVertex();
        this.tail = this.tailPort.getVertex();
    }
}
