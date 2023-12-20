package com.ise.epic.Map;

import java.util.HashSet;
import java.util.Set;

public class WeightedNode implements Comparable<WeightedNode> {
    private Node node;
    private double travelDistance;
    private WeightedNode predecessor;

    public WeightedNode(Node node, double traversedDistance, WeightedNode pred) {
        this.node = node;
        this.travelDistance = traversedDistance;
        this.predecessor = pred;
    }

    public double approximateDistance() {
        return this.travelDistance;
    }

    @Override
    public int compareTo(WeightedNode weightedNode) {
        return Double.compare(this.approximateDistance(), weightedNode.approximateDistance());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        WeightedNode that = (WeightedNode) other;
        return Double.compare(that.approximateDistance(), this.approximateDistance()) == 0 &&
                this.node.equals(that.node);
    }

    public double totalDistance() {

        return this.travelDistance;
    }

    public Set<Node> nodes() {
        Set<Node> nodeSet = new HashSet<>();
        WeightedNode current = this;

        while (current != null) {
            nodeSet.add(current.node);
            current = current.predecessor;
        }

        return nodeSet;
    }

    public Node getNode() {
        return this.node;
    }
}
