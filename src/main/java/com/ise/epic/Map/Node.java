package com.ise.epic.Map;
import com.ise.epic.DataStructures.ArrayListImplementation;
import java.util.HashSet;

public class Node {
    private String name;
    private int x;
    private int y;
    private ArrayListImplementation<Vertex> connections;

    public Node(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.connections = new ArrayListImplementation<>();
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addConnection(Node target) {
        this.connections.add(new Vertex(this, target));
    }

    public double distanceFrom(Node target) {
        int xDiff = Math.abs(this.x - target.x);
        int yDiff = Math.abs(this.y - target.y);

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public ArrayListImplementation<Node> reachableLocations() {
        ArrayListImplementation<Node> reachableNodes = new ArrayListImplementation<>();

        for (Vertex v : this.connections) {
            reachableNodes.add(v.getTarget());
        }
        return reachableNodes;
    }

    public Vertex[] getVertices() {
        return new Vertex[0];
    }

    public guru.nidi.graphviz.model.Node name() {
        return null;
    }
}
