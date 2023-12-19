package com.ise.epic.Map;

import com.ise.epic.DataStructures.HashMapImplementation;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<String, Node> nodes;

    public Graph() {
        this.nodes = new HashMapImplementation<>();
    }

    public void addNode(Node node) {
        nodes.put(node.getName(), node);
    }

    public Node getNode(String nodeName) {
        return nodes.get(nodeName);
    }

    public void addEdge(Node source, Node target) {
        source.addConnection(target);
        // Add logic for directed or undirected edges based on your requirements
    }

    public Set<Node> getNodes() {
        return new HashSet<>(nodes.values());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes.values()) {
            sb.append(node.getName()).append(": ");
            for (Node neighbor : node.reachableLocations()) {
                sb.append(neighbor.getName()).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}