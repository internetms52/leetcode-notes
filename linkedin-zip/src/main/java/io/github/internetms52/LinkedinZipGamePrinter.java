package io.github.internetms52;

import java.util.LinkedList;
import java.util.List;

public class LinkedinZipGamePrinter {

    public void print(LinkedinZipGame game) {
        int[][] board = new int[game.getWidth()][game.getHeight()];

        for (ZipNode node : game.getNodes()) {
            board[node.getX()][node.getY()] = node.getOrder();
        }

        for (int y = 0; y < game.getHeight(); y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < game.getWidth(); x++) {
                if (x > 0) row.append(" ");
                int val = board[x][y];
                row.append(val == 0 ? "." : String.valueOf(val));
            }
            System.out.println(row);
        }
    }

    public void printSolution(LinkedinZipGame game, LinkedList<Node> solution) {
        String[][] board = new String[game.getWidth()][game.getHeight()];

        for (ZipNode node : game.getNodes()) {
            board[node.getX()][node.getY()] = String.valueOf(node.getOrder());
        }

        List<Node> path = new java.util.ArrayList<>(solution);
        for (int i = 0; i < path.size(); i++) {
            Node current = path.get(i);
            int x = current.getX();
            int y = current.getY();

            if (board[x][y] != null) {
                continue;
            }

            Node next = path.get(i + 1);
            int dx = next.getX() - x;
            int dy = next.getY() - y;

            if (dx == 1)       board[x][y] = "→";
            else if (dx == -1) board[x][y] = "←";
            else if (dy == 1)  board[x][y] = "↓";
            else if (dy == -1) board[x][y] = "↑";
        }

        for (int y = 0; y < game.getHeight(); y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < game.getWidth(); x++) {
                if (x > 0) row.append(" ");
                row.append(board[x][y] == null ? "." : board[x][y]);
            }
            System.out.println(row);
        }
    }
}
