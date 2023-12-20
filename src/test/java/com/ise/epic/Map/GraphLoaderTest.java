package com.ise.epic.Map;

import org.junit.jupiter.api.Test;
import guru.nidi.graphviz.model.Graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

class GraphLoaderTest {

    @Test
    void loadGraphFromJson() {
        assertDoesNotThrow(() -> GraphLoader.load("test_data/graph1.json"));
        assertThrows(RuntimeException.class, () -> GraphLoader.load("test_data/graph2.json"));
        assertThrows(FileNotFoundException.class, () -> GraphLoader.load("test_data/nonexistant.json"));
        assertThrows(RuntimeException.class, () -> GraphLoader.load("test_data/graph3.json"));
    }

    @Test
    void main() {
    }

    @Test
    void testLoadGraphFromJson() {
    }
}