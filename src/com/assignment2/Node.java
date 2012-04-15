package com.assignment2;

public class Node {
	int x;
	int y;
	int z;
	Node[] adjacents;
	char letter;
	int adjCount;
	int[][] adjCoords;
	public Node(){
		adjacents = new Node[4];
		int[][] adjCoords= new int[4][3];
		adjCount = 0;
	}
	
	public void addNCoords(int x, int y, int z){
		adjCoords[adjCount][0]=x;
		adjCoords[adjCount][1]=y;
		adjCoords[adjCount][2]=z;
		adjCount++;
	}
	
	
}
