package com.assignment1;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;

public class TreeTest {
	
	public static void main(String[] args) throws Exception{
		City[] cities = new City[29];
		double[][] distances = new double[29][29];

		
		/**
		 * Collect city names and info
		 */
		File f = new File("cityxy.txt");
		Scanner g = new Scanner(f);
		int x = -1;
		int y = -1;
		String name = "error";
		int counter=0;
		while(g.hasNext()){
			name = g.next();
			x = Integer.parseInt(g.next());
			y = Integer.parseInt(g.next());
			City c = new City(name,x,y);
			cities[counter]=c;
			//System.out.print(name+"|"+x+"|"+y+"\n");
			counter++;
		}
		System.out.println("Counter: "+ counter);
		
		
		/**
		 * Print distances
		 **/
		for(int i=0;i<29;i++){
			for(int j=0;j<29;j++){
				distances[i][j]=0;
			}
		}
		//counter = 0;
		Heap edges = new Heap();
		for(int i=28;i>=0;i--){
		 	for(int j=0;j<i;j++){
		 	//	counter++;
		 		double distance= cities[j].computeDistance(cities[i]);
		 		Edge e = new Edge(cities[i],cities[j],distance);
		 		edges.insert(e);
		 		System.out.println(cities[i].getName()+" | "+ 
		 				cities[j].getName()+" | "+ distance);
		 	}
		}
		kruskal(edges, cities);
		//System.out.println(counter+" edges");
		 
	/**	 
		 for(int i=0;i<29;i++){
			 for(int j=0;j<29;j++){
				// System.out.println(i+"|"+j);
				 System.out.print(distances[i][j]);
				 System.out.print(" ");
			 }
			 System.out.println("");
		 }
	**/
		
		
		
	}
	
	public static void kruskal(Heap h, City[] c){
		for(int i=0;i<3;i++)
			System.out.println("==================================");
		System.out.println("Minimum distances");
		System.out.println("==================================");
		Graph g = new Graph();
		int[] unionTree = new int[29];
		for(int i=0;i<29;i++){
			unionTree[i]=i;
			g.addCity(c[i], i);
		}
		
		while(g.edgeCount()!=28){
			//System.out.println("oh god");
			Edge e = h.pop();
			City c1 = e.getCities()[0];
			City c2 = e.getCities()[1];
			int index1=-1;
			int index2=-1;
			int counter =0;
			
			//figure out the indices of the cities we get
			while(index1==-1||index2==-1){
				//System.out.println("yes?");
				if(c1 == c[counter]){
					index1=counter;
				}
				if(c2 == c[counter]){
					index2 = counter;
				}
				counter++;
			}
			//System.out.println("cool");
			
			//find the root of the two trees
			while (unionTree[index1]!=index1){
					index1=unionTree[index1];
			}
			while(unionTree[index2]!=index2){
					index2=unionTree[index2];
			}
			
			//check for containment and union
			if(index1!=index2){
				g.addEdge(e);
				unionTree[index1]=index2;
				System.out.println(e.getCities()[0].getName()+" | " + e.getCities()[1].getName()+" | "+ e.distance());
			}
			//System.out.println(g.edgeCount());
		}
		
		drawingHell(g);
	}
	
	static final int WIDTH=400;
	static final int HEIGHT=300;
	public static void drawingHell(Graph g){
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		PanelHell cat = new PanelHell(g, WIDTH, HEIGHT);
		frame.add(cat);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,400);
		frame.setVisible(true);
		
	}
	
	
	
}
