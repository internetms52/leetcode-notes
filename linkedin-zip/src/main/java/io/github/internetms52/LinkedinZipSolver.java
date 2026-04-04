package io.github.internetms52;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LinkedinZipSolver {

    private final LinkedinZipPathTreeGenerator pathTreeGenerator = new LinkedinZipPathTreeGenerator();

    public LinkedList<Node> gen(LinkedinZipGame game) {
        List<ZipNode> nodes = game.getNodes();
        int segmentCount = nodes.size() - 1;

        List<List<LinkedList<Node>>> segments = new ArrayList<>();

        for (int i = 0; i < segmentCount; i++) {
            int fromOrder = i + 1;
            int toOrder = i + 2;
            segments.add(pathTreeGenerator.genPathTree(fromOrder, toOrder, game));
        }

        return backtrack(0, segments, new LinkedList<>(), new HashSet<>(), game);
    }

    private LinkedList<Node> backtrack(int segmentIndex, List<List<LinkedList<Node>>> segments,
                                       LinkedList<Node> current, Set<String> visited, LinkedinZipGame game) {
        if (segmentIndex == segments.size()) {
            if (current.size() == game.getWidth() * game.getHeight()) {
                return new LinkedList<>(current);
            }
            return null;
        }

        for (LinkedList<Node> path : segments.get(segmentIndex)) {
            // 第一段保留完整路徑，後續段跳過第一個節點（與前段末端重複）
            List<Node> nodesToAdd = segmentIndex == 0 ? path : path.subList(1, path.size());

            if (hasCollision(nodesToAdd, visited)) {
                continue;
            }

            for (Node node : nodesToAdd) {
                current.add(node);
                visited.add(node.getX() + "," + node.getY());
            }

            LinkedList<Node> result = backtrack(segmentIndex + 1, segments, current, visited, game);
            if (result != null) {
                return result;
            }

            for (int i = 0; i < nodesToAdd.size(); i++) {
                Node removed = current.removeLast();
                visited.remove(removed.getX() + "," + removed.getY());
            }
        }

        return null;
    }

    // ---- Single DFS version ----

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public LinkedList<Node> genDfs(LinkedinZipGame game) {
        Map<String, Integer> zipNodeMap = new HashMap<>();
        for (ZipNode node : game.getNodes()) {
            zipNodeMap.put(node.getX() + "," + node.getY(), node.getOrder());
        }

        ZipNode start = game.getNodes().stream()
                .filter(n -> n.getOrder() == 1)
                .findFirst()
                .orElseThrow();

        boolean[][] visited = new boolean[game.getWidth()][game.getHeight()];
        visited[start.getX()][start.getY()] = true;

        LinkedList<Node> path = new LinkedList<>();
        path.add(new Node(start.getX(), start.getY()));

        int totalCells = game.getWidth() * game.getHeight();
        int maxOrder = game.getNodes().size();

        dfs(start.getX(), start.getY(), visited, path, 2, maxOrder, zipNodeMap, game, totalCells);

        return path.size() == totalCells ? path : null;
    }

    private boolean dfs(int cx, int cy, boolean[][] visited, LinkedList<Node> path,
                        int nextOrder, int maxOrder, Map<String, Integer> zipNodeMap,
                        LinkedinZipGame game, int totalCells) {
        if (path.size() == totalCells) {
            return nextOrder > maxOrder;
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

            Integer nodeOrder = zipNodeMap.get(nx + "," + ny);
            if (nodeOrder != null && nodeOrder != nextOrder) {
                continue;
            }

            int newNextOrder = (nodeOrder != null) ? nextOrder + 1 : nextOrder;

            visited[nx][ny] = true;
            path.add(new Node(nx, ny));

            if (dfs(nx, ny, visited, path, newNextOrder, maxOrder, zipNodeMap, game, totalCells)) {
                return true;
            }

            path.removeLast();
            visited[nx][ny] = false;
        }

        return false;
    }

    // ---- Two-phase backtracking version ----

    private boolean hasCollision(List<Node> nodesToAdd, Set<String> visited) {
        for (Node node : nodesToAdd) {
            if (visited.contains(node.getX() + "," + node.getY())) {
                return true;
            }
        }
        return false;
    }
}
