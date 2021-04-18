package com.graph.learn;

import java.util.ArrayList;

public class Node {
	// 结点值
	public int value;
	// 入度
	public int in;
	// 出度
	public int out;
	// 邻接点
	public ArrayList<Node> nexts;
	// 邻接边
	public ArrayList<Edge> edges;

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
