package com.graph.learn;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	// 点集
	public HashMap<Integer, Node> nodes;
	// 边集
	public HashSet<Edge> edges;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
