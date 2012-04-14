package com.assignment1;


public class Graph {
	private City[] nodes;
	private Edge[] edges;
	private int counter;
	public Graph(){
		nodes = new City[29];
		edges = new Edge[28];
	}
	
	public void addCity(City c, int i){
		nodes[i]=c;
	}
	
	public void addEdge(Edge e){
		edges[counter++]=e;
	}
	
	public int edgeCount(){
		return counter;
	}
	public Edge[] getEdges(){
		return edges;
	}
	
	public City[] getCities(){
		return nodes;
	}
}
