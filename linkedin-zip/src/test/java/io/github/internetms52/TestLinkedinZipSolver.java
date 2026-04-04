package io.github.internetms52;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedinZipSolver {
    public LinkedinZipGame givenGame() {
        List<ZipNode> zipNodes = new ArrayList<>();
        zipNodes.add(new ZipNode(1, 0, 0));
        zipNodes.add(new ZipNode(2, 5, 5));
        zipNodes.add(new ZipNode(3, 4, 1));
        zipNodes.add(new ZipNode(4, 1, 1));
        zipNodes.add(new ZipNode(5, 3, 2));
        zipNodes.add(new ZipNode(6, 2, 2));
        zipNodes.add(new ZipNode(7, 1, 4));
        zipNodes.add(new ZipNode(8, 4, 4));
        zipNodes.add(new ZipNode(9, 3, 3));
        zipNodes.add(new ZipNode(10, 2, 3));

        return new LinkedinZipGame(
                6, 6, zipNodes
        );
    }

    @Test
    public void case1() {
        LinkedinZipGamePrinter printer = new LinkedinZipGamePrinter();
        printer.print(givenGame());
        LinkedinZipSolver linkedinZipSolver = new LinkedinZipSolver();
        LinkedList<Node> result = linkedinZipSolver.gen(givenGame());
        printer.printSolution(givenGame(), result);
    }

    @Test
    public void case2(){
        LinkedinZipGamePrinter printer = new LinkedinZipGamePrinter();
        printer.print(givenGame());
        LinkedinZipSolver linkedinZipSolver = new LinkedinZipSolver();
        LinkedList<Node> result = linkedinZipSolver.genDfs(givenGame());
        printer.printSolution(givenGame(), result);
    }
}
