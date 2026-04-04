package io.github.internetms52;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LinkedinZipPathTreeGenerator {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<LinkedList<Node>> genPathTree(int fromOrder, int toOrder, LinkedinZipGame game) {
        if (Math.abs(fromOrder - toOrder) != 1) {
            throw new IllegalArgumentException("fromOrder and toOrder must be adjacent: " + fromOrder + ", " + toOrder);
        }

        ZipNode from = findNodeByOrder(fromOrder, game);
        ZipNode to = findNodeByOrder(toOrder, game);

        List<LinkedList<Node>> result = new ArrayList<>();
        boolean[][] visited = new boolean[game.getWidth()][game.getHeight()];

        Set<String> blockedPositions = game.getNodes().stream()
                .filter(n -> n.getOrder() != fromOrder && n.getOrder() != toOrder)
                .map(n -> n.getX() + "," + n.getY())
                .collect(Collectors.toSet());

        LinkedList<Node> path = new LinkedList<>();
        path.add(new Node(from.getX(), from.getY()));
        visited[from.getX()][from.getY()] = true;

        dfs(from.getX(), from.getY(), to.getX(), to.getY(), visited, path, result, game, blockedPositions);

        return result;
    }

    private void dfs(int cx, int cy, int tx, int ty,
                     boolean[][] visited, LinkedList<Node> path,
                     List<LinkedList<Node>> result, LinkedinZipGame game,
                     Set<String> blockedPositions) {
        if (cx == tx && cy == ty) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int[] dir : DIRECTIONS) {
            int nx = cx + dir[0];
            int ny = cy + dir[1];

            if (nx < 0 || nx >= game.getWidth() || ny < 0 || ny >= game.getHeight()) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            if (blockedPositions.contains(nx + "," + ny)) {
                continue;
            }

            visited[nx][ny] = true;
            path.add(new Node(nx, ny));

            dfs(nx, ny, tx, ty, visited, path, result, game, blockedPositions);

            path.removeLast();
            visited[nx][ny] = false;
        }
    }

    private ZipNode findNodeByOrder(int order, LinkedinZipGame game) {
        return game.getNodes().stream()
                .filter(n -> n.getOrder() == order)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Node with order " + order + " not found"));
    }
}
