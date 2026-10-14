package org.yuyuan.datastructure.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    public Node addNode(int value) {
        if (nodes.containsKey(value)) {
            return nodes.get(value);
        }
        Node node = new Node(value);
        nodes.put(value, node);
        return node;
    }

    public void addEdge(int fromValue, int toValue, int weight) {
        Node from = addNode(fromValue);
        Node to = addNode(toValue);
        Edge edge = new Edge(from, to, weight);
        edges.add(edge);
        from.out++;
        to.in++;
        from.nexts.add(to);
        from.edges.add(edge);
    }
}