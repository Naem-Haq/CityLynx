package com.ise.epic.Map;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarAlgorithm {

    public static double astar(Node start, Node goal) {
        PriorityQueue<WeightedNode> openSet = new PriorityQueue<>();
        HashSet<Node> closedSet = new HashSet<>();

        WeightedNode startNode = new WeightedNode(start, 0, 0, null);
        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            WeightedNode current = openSet.poll();

            if (current.getNode().equals(goal)) {
                // Reached the goal
                return current.totalDistance();
            }

            closedSet.add(current.getNode());

            for (Node neighbor : current.getNode().reachableLocations()) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                double newTraversedDistance = current.totalDistance() + current.getNode().distanceFrom(neighbor);
                WeightedNode neighborNode = new WeightedNode(neighbor, 0, newTraversedDistance, current);

                if (!openSet.contains(neighborNode)) {
                    openSet.add(neighborNode);
                }
            }
        }

        // Goal not reached
        return -1;
    }
}

