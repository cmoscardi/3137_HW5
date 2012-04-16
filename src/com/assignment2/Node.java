package com.assignment2;

import java.awt.geom.Ellipse2D;

public class Node {
	Ellipse2D circle;
	int x;
	int y;
	int z;
	Node[] adjacents;
	char letter;
	int adjCount;
	int adjNodeCount;
	int[][] adjCoords;
	public Node(){
		adjacents = new Node[5];
		adjCoords= new int[5][3];
		adjCount = 0;
		adjNodeCount=0;
	}
	
	public void addNCoords(int x, int y, int z){
		adjCoords[adjCount][0]=x;
		adjCoords[adjCount][1]=y;
		adjCoords[adjCount][2]=z;
		adjCount++;
	}
	
	//i mean i should be able to use
	//== since all references should point
	//to the same node, but just to be safe
	public boolean equals(Node other){
		return (x==other.x&&y==other.y&&z==other.z);
	}
	public void addNode(Node n){
		adjacents[adjNodeCount++]=n;
	}
	
	
}
