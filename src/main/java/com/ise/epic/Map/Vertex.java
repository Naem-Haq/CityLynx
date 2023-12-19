package com.ise.epic.Map;

class Vertex {
    private Node from;
    private Node target;

    public Vertex(Node from, Node target) {
        this.from = from;
        this.target = target;
    }

    public Node getTarget() {
        return this.target;
    }

    public Node getFrom() {
        return this.from;
    }
}
