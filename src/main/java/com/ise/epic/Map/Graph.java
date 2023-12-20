package com.ise.epic.Map;

import com.ise.epic.Taxi.Taxi;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Graph {
    private Map<String, Node> nodes;
    private Map<Taxi, Node> taxiNodes; // Map to associate taxis with nodes

    public Graph() {
        this.nodes = new HashMap<>();
        this.taxiNodes = new HashMap<>();
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

    public void associateTaxiWithNode(Taxi taxi, Node node) {
        taxiNodes.put(taxi, node);
    }

    public Set<Node> getNodes() {
        return new HashSet<>(nodes.values());
    }

    public Set<Taxi> getAvailableTaxis(Node node) {
        Set<Taxi> availableTaxis = new HashSet<>();
        for (Taxi taxi : taxiNodes.keySet()) {
            if (isTaxiAvailable(taxi, node)) {
                availableTaxis.add(taxi);
            }
        }
        return availableTaxis;
    }

    private boolean isTaxiAvailable(Taxi taxi, Node node) {
        // Add logic to check if the taxi is available based on your criteria
        // For example, you may check the distance between the taxi and the user's pickup node
        return true; // Placeholder, modify as needed
    }

    // Implement this method to load your graph
    public static Graph loadGraphFromJson(String jsonFilePath) {
        Graph graph = new Graph();

        try (Reader reader = new FileReader(jsonFilePath)) {
            Gson gson = new Gson();
            JsonElement jsonElement = JsonParser.parseReader(reader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonObject nodesObject = jsonObject.getAsJsonObject("nodes");
            for (Map.Entry<String, JsonElement> entry : nodesObject.entrySet()) {
                String nodeName = entry.getKey();
                JsonObject nodeData = entry.getValue().getAsJsonObject();

                int x = nodeData.getAsJsonPrimitive("x").getAsInt();
                int y = nodeData.getAsJsonPrimitive("y").getAsInt();

                Node node = new Node(nodeName, x, y);
                graph.addNode(node);

                JsonArray connectionsArray = nodeData.getAsJsonArray("connections");
                for (JsonElement connectionElement : connectionsArray) {
                    String connectionName = connectionElement.getAsString();
                    Node connectedNode = graph.getNode(connectionName);
                    if (connectedNode != null) {
                        graph.addEdge(node, connectedNode);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
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
