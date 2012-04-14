package com.assignment1;


public class Heap {
	private Edge[] edges;
	public int currentSize;
	public Heap(){
		//right?
		edges = new Edge[29*14+1];
	}
	
	public void insert(Edge e){
		int hole = ++currentSize;
		
		//percolate up
		edges[0]= e;
		while(e.distance()<edges[hole/2].distance()){
			edges[hole]=edges[hole/2];
			hole/=2;
		}
		edges[hole]=e;
	}
	
	public Edge pop(){
		if(currentSize==0){
			return null;
		}
		Edge min = edges[1];
		
		//percolate down
		edges[1]=edges[currentSize--];
		int child;
		Edge tmp = edges[1];
		int hole = 1;
		while(hole*2<=currentSize){
			child = hole*2;
			if(child!=currentSize &&
					edges[child+1].distance()<edges[child].distance()){
				child++;
			}
			if(edges[child].distance()<tmp.distance()){
				edges[hole]=edges[child];
			}
			else break;
			
			hole=child;
		}
		edges[hole]=tmp;
		
		return min;
	}
}
