package io.github.internetms52;

public class ZipNode {
    private int order;
    private int x;
    private int y;

    public ZipNode(int order, int x, int y) {
        this.order = order;
        this.x = x;
        this.y = y;
    }

    public int getOrder() {
        return order;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "ZipNode{order=" + order + ", x=" + x + ", y=" + y + "}";
    }
}
