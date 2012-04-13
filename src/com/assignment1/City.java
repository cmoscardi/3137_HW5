package com.assignment1;

public class City {
	private int x;
	private int y;
	private String name;
	
	public City(String name, int x, int y){
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String getName(){
		return name;
	}
	
	public double computeDistance(City c2){
		double xsq = (x-c2.x)*(x-c2.x);
		double ysq = (y-c2.y)*(y-c2.y);
		return Math.sqrt((xsq+ysq));
	}
}
