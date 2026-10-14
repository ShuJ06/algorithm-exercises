package org.yuyuan.datastructure.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DijkstraTest {

    /**
     * 将「节点 -> 最短距离」的结果表转换为「value -> 距离」，便于按数值断言。
     */
    private Map<Integer, Integer> toValueMap(Map<Node, Integer> dist) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Node, Integer> entry : dist.entrySet()) {
            result.put(entry.getKey().value, entry.getValue());
        }
        return result;
    }

    @Test
    @DisplayName("测试单源最短路径松弛")
    void shortestPath() {
        Graph graph = new Graph();
        // 1->2(1), 1->3(5), 1->4(9), 2->3(2)：到 3 的最短路应为 1->2->3 = 3
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 5);
        graph.addEdge(1, 4, 9);
        graph.addEdge(2, 3, 2);

        Map<Integer, Integer> dist = toValueMap(Dijkstra.dijkstra(graph.nodes.get(1)));
        assertEquals(0, dist.get(1));
        assertEquals(1, dist.get(2));
        assertEquals(3, dist.get(3));
        assertEquals(9, dist.get(4));
    }

    @Test
    @DisplayName("测试起点为 null 返回空结果")
    void nullStart() {
        assertTrue(Dijkstra.dijkstra(null).isEmpty());
    }
}
