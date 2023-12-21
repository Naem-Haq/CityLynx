//package com.ise.epic.Map;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AStarAlgorithmTest {
//
//    @Test
//    void astar() {
//        // Create nodes for testing with x and y coordinates
//        Node nodeA = new Node("A", 0, 0);
//        Node nodeB = new Node("B", 1, 0);
//        Node nodeC = new Node("C", 2, 0);
//        Node nodeD = new Node("D", 3, 0);
//
//        // Define distances between nodes
//        nodeA.addConnection(nodeB, 1.0);
//        nodeB.addConnection(nodeC, 2.0);
//        nodeC.addConnection(nodeD, 1.5);
//
//        // Apply the A* algorithm
//        double resultDistance = AStarAlgorithm.astar(nodeA, nodeD);
//
//        // Assert that the result is as expected
//        assertEquals(4.5, resultDistance, 0.01);
//    }
//}
