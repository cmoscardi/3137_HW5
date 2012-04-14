package com.assignment1;


public class Edge {
	private double distance;
	private City e1;
	private City e2;
	public Edge(City e1, City e2, double distance){
		this.e1 = e1;
		this.e2 = e2;
		this.distance = distance;
	}
	public double distance(){
		return distance;
	}
	public City[] getCities(){
		City[] val = {e1,e2};
		return val;
	}

}
