package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;
import org.junit.jupiter.api.Test;

public class SwapNodesInPairsTest {
    SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

    @Test
    public void case1(){
        swapNodesInPairs.swapPairs(
                new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))))
        );
    }
}
