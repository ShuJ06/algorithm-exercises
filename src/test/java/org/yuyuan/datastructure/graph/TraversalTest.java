package org.yuyuan.datastructure.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TraversalTest {

    /**
     * 构造测试图：1->2, 1->3, 2->4, 3->4。
     * nexts 按插入顺序保存，因此遍历次序确定。
     */
    private Graph buildGraph() {
        Graph graph = new Graph();
        graph.addEdge(1, 2, 0);
        graph.addEdge(1, 3, 0);
        graph.addEdge(2, 4, 0);
        graph.addEdge(3, 4, 0);
        return graph;
    }

    /**
     * 捕获指定遍历过程打印到标准输出的节点序列，逐行解析为整数列表。
     */
    private List<Integer> capture(Runnable runnable) {
        PrintStream origin = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            runnable.run();
        } finally {
            System.setOut(origin);
        }
        List<Integer> visited = new ArrayList<>();
        for (String line : buffer.toString(StandardCharsets.UTF_8).split("\\R")) {
            if (!line.isBlank()) {
                visited.add(Integer.parseInt(line.trim()));
            }
        }
        return visited;
    }

    @Test
    @DisplayName("测试 BFS 按层访问顺序")
    void bfsOrder() {
        Graph graph = buildGraph();
        List<Integer> visited = capture(() -> BFS.bfs(graph.nodes.get(1)));
        // 层序：1 -> (2,3) -> 4
        assertEquals(List.of(1, 2, 3, 4), visited);
    }

    @Test
    @DisplayName("测试 DFS 按深度优先访问顺序")
    void dfsOrder() {
        Graph graph = buildGraph();
        DFS dfs = new DFS();
        List<Integer> visited = capture(() -> dfs.dfs(graph.nodes.get(1)));
        // 深度优先：1 -> 2 -> 4，回溯后再访问 3
        assertEquals(List.of(1, 2, 4, 3), visited);
    }

    @Test
    @DisplayName("测试起点为 null 时不访问任何节点")
    void nullStart() {
        DFS dfs = new DFS();
        assertTrue(capture(() -> BFS.bfs(null)).isEmpty());
        assertTrue(capture(() -> dfs.dfs(null)).isEmpty());
    }
}
