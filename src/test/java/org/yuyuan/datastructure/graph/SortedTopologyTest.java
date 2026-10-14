package org.yuyuan.datastructure.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortedTopologyTest {

    @Test
    @DisplayName("测试 DAG 拓扑排序结果合法")
    void validOrder() {
        Graph graph = new Graph();
        // 1->2, 2->3, 1->3 构成有向无环图
        graph.addEdge(1, 2, 0);
        graph.addEdge(2, 3, 0);
        graph.addEdge(1, 3, 0);

        List<Node> result = SortedTopology.sortedTopology(graph);
        // 所有节点都应被输出
        assertEquals(graph.nodes.size(), result.size());

        // 校验每条边的起点都排在终点之前
        for (Edge edge : graph.edges) {
            int fromIndex = indexOfValue(result, edge.from.value);
            int toIndex = indexOfValue(result, edge.to.value);
            assertTrue(fromIndex < toIndex,
                    "拓扑序中 " + edge.from.value + " 应早于 " + edge.to.value);
        }
    }

    private int indexOfValue(List<Node> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).value == value) {
                return i;
            }
        }
        return -1;
    }
}
