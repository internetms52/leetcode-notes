package io.github.internetms52;

import java.util.List;

public class LinkedinZipGame {
    private int width;
    private int height;
    private List<ZipNode> nodes;

    public LinkedinZipGame(int width, int height, List<ZipNode> nodes) {
        this.width = width;
        this.height = height;
        this.nodes = nodes;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<ZipNode> getNodes() {
        return nodes;
    }
}
