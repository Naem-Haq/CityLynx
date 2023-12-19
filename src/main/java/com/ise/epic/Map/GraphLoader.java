package com.ise.epic.Map;

import com.google.gson.Gson;
import com.ise.epic.DataStructures.HashMapImplementation;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GraphLoader {

    private static class LoadedGraph {
        public HashMapImplementation<String, Node> nodes;
        // Add other necessary fields if needed

        public LoadedGraph(HashMapImplementation<String, Node> nodes) {
            this.nodes = nodes;
        }

        public HashMapImplementation<String, Node> getNodes() {
            return nodes;
        }
    }

    public static Graph loadGraphFromJson(String jsonFilePath) {
        try (Reader reader = new FileReader(jsonFilePath)) {
            Gson gson = new Gson();
            LoadedGraph loadedGraph = gson.fromJson(reader, LoadedGraph.class);
            return convertToGraph(loadedGraph);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Graph convertToGraph(LoadedGraph loadedGraph) {
        if (loadedGraph == null || loadedGraph.getNodes() == null) {
            return null;
        }

        // Assuming you have a method to create a graph from loaded data
        // Modify the method based on your actual graph implementation
        return createGraphFromLoadedData(loadedGraph.getNodes());
    }

    private static Graph createGraphFromLoadedData(HashMapImplementation<String, Node> loadedNodes) {
        // Implement logic to create a Graph instance from loaded data
        // You may need to modify this based on your actual graph implementation
        Graph graph = new Graph();

        for (Node loadedNode : loadedNodes.values()) {
            // Add logic to add nodes and edges to the graph
            // You may need to modify this based on your actual graph implementation
            graph.addNode(loadedNode);
            for (Node neighbor : loadedNode.reachableLocations()) {
                graph.addEdge(loadedNode, neighbor);
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        String jsonFilePath = "Graph.json";

        Graph graph = loadGraphFromJson(jsonFilePath);

        if (graph != null) {
            // Now you can work with the loaded graph
            System.out.println("Graph loaded successfully!");
        } else {
            System.out.println("Error loading the graph.");
        }
    }
}
