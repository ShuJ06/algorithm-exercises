package org.yuyuan.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SortedTopology {
    public static List<Node> sortedTopology(Graph graph) {
        // key: 某个Node
        // value: 剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();

        // 入度为0的Node，进入此队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        // 拓扑排序的结果，依次加入result
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node curr = zeroInQueue.poll();
            result.add(curr);
            for (Node next : curr.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }

            }
        }
        return result;
    }
}
