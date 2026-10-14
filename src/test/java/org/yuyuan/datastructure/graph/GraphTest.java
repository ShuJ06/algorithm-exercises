package org.yuyuan.datastructure.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphTest {

    @Test
    @DisplayName("测试 addNode 去重：相同 value 复用同一节点")
    void addNodeReuse() {
        Graph graph = new Graph();
        Node first = graph.addNode(1);
        Node second = graph.addNode(1);
        assertSame(first, second);
        assertEquals(1, graph.nodes.size());
    }

    @Test
    @DisplayName("测试 addEdge 维护出入度与邻接关系")
    void addEdgeUpdatesDegree() {
        Graph graph = new Graph();
        graph.addEdge(1, 2, 5);

        Node from = graph.nodes.get(1);
        Node to = graph.nodes.get(2);
        assertEquals(1, from.out);
        assertEquals(0, from.in);
        assertEquals(0, to.out);
        assertEquals(1, to.in);
        // from 的邻接表包含 to，且记录了对应边
        assertTrue(from.nexts.contains(to));
        assertEquals(1, from.edges.size());
        assertEquals(5, from.edges.get(0).weight);
        assertEquals(1, graph.edges.size());
    }

    @Test
    @DisplayName("测试自动补齐缺失端点")
    void addEdgeCreatesNodes() {
        Graph graph = new Graph();
        graph.addEdge(7, 8, 1);
        // 端点不存在时应自动创建
        assertTrue(graph.nodes.containsKey(7));
        assertTrue(graph.nodes.containsKey(8));
        assertEquals(2, graph.nodes.size());
    }
}
