package org.yuyuan.datastructure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {

    /**
     * 单源最短路径（Dijkstra）
     * 适用于：带权【有向/无向】图，且所有权必须为非负数。
     *
     * @param start 起点
     * @return key 为可达节点，value 为从 start 到该节点的最短距离
     */
    public static Map<Node, Integer> dijkstra(Node start) {
        // distanceMap：记录从起点到各节点的「当前已知最短距离」，同时充当待处理集合
        Map<Node, Integer> distanceMap = new HashMap<>();
        // selectedNodes：记录距离已最终确定、不再参与松弛的节点（即「黑盒」集合）
        HashSet<Node> selectedNodes = new HashSet<>();

        // 起点为空时，没有任何可达节点，直接返回空结果
        if (start == null) {
            return distanceMap;
        }
        // 起点到自身的距离为 0，作为松弛的初始源
        distanceMap.put(start, 0);

        // 取出「未确定且距离最小」的节点，作为本轮松弛的中心
        Node minNode = getMinAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            // minNode 的当前最短距离，一旦选出即视为最终确定
            int distance = distanceMap.get(minNode);
            // 松弛 minNode 的所有出边：尝试通过 minNode 抵达 toNode 是否能更短
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    // toNode 首次被发现，直接用经由 minNode 的距离初始化
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    // toNode 已在集合中，保留更小的距离（松弛更新）
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            // minNode 的距离已确定，标记为已选，后续不再重复处理
            selectedNodes.add(minNode);
            // 继续挑选下一个「未确定且距离最小」的节点，直到全部处理完毕
            minNode = getMinAndUnselectedNode(distanceMap, selectedNodes);
        }
        // 所有可达节点的最短距离均已确定
        return distanceMap;
    }

    /**
     * 在 distanceMap 中选出「未被 selected 且距离最小」的节点。
     * 采用线性扫描实现，每次调用复杂度为 O(V)，因此整体为 O(V^2)；
     * 若改用优先队列（最小堆）可将选点优化为 O(log V)。
     *
     * @param distanceMap   当前已知最短距离表
     * @param selectedNodes 已确定最短距离的节点集合
     * @return 未确定节点中距离最小者；若全部已确定则返回 null
     */
    private static Node getMinAndUnselectedNode(Map<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        Node minNode = null;
        // 用最大值作为哨兵，保证任何有效距离都能将其替换
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            // 只在「未确定」的节点中比较，保留距离最小者
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}