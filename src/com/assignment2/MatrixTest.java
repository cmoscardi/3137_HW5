package com.assignment2;

import java.io.File;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MatrixTest {
	public static HashTable table;
	public static JFrame window;
	public static void main(String[] args) throws Exception{
		Node[] nodes = new Node[18];
		File matrix = new File("graph.txt");
		Scanner read = new Scanner(matrix);
		int counter =0;
		Node n=null;
		while(read.hasNextLine()){
			String x = read.nextLine();
			String[] y = x.split(" ");
			//for(String z: y){
				//System.out.println(z);
			//}
			//awmagawd letter
			if(y.length==1){
				n = new Node();
				n.letter = y[0].charAt(0);
				//next line is def coordinates
				x = read.nextLine();
				y = x.split(" ");
				n.x = Integer.parseInt(y[0]);
				n.y = Integer.parseInt(y[1]);
				n.z = Integer.parseInt(y[2]);
				nodes[counter]=n;
				counter++;
			}
			//awmagawd 3 numbers
			else{
				//System.out.println("here");
				n.addNCoords(Integer.parseInt(y[0]),Integer.parseInt(y[1]),Integer.parseInt(y[2]));
			}
		}
		
		//System.out.println(counter);
		convert(nodes);
		/**
		 * Now each node has an adjacency list
		 */
		
		//declared as static above
		table = new HashTable(50287);
		makeTable(table);
		
		
		window = new JFrame();
		window.setSize(400, 400);
		JComponent p = new MatrixPane(nodes,800,600);
		window.add(p);
		//runSearch(nodes,window);
	}
	
	public static void convert(Node[] nodes){
		//compare each inner node j to the adjacency
		//list of node y
		for(int i=(nodes.length-1);i>=0;i--){
		//	if(nodes[i]==null){
		//		System.out.println("wat");
		//	}
			for(int j=0;j<i;j++){
				for(int k=0;k<nodes[i].adjCount;k++){
					int[] coords = nodes[i].adjCoords[k];
					boolean a = coords[0]==nodes[j].x;
					boolean b = coords[1]==nodes[j].y;
					boolean c = coords[2]==nodes[j].z;
					if(a&&b&&c){
						nodes[i].addNode(nodes[j]);
						nodes[j].addNode(nodes[i]);
					}
				}
			}
			//System.out.println(nodes[i].adjNodeCount);
		}
	}
	
	public static void runSearch(Node[] nodes,JFrame window){
		Scanner input = new Scanner(System.in);
		System.out.println("Length of word?");
		window.setVisible(true);
		int number = Integer.parseInt(input.nextLine());
		
		//each node can be a starting letter
		for(Node n: nodes){
			recurse(n,"",number-1);
		}
	}
	
	public static void recurse(Node node, String s,int depth){
		String t = s+Character.toString(node.letter);
		try{
			Thread.sleep(500);
		}
		catch(Exception e){
			
		}
		if(depth==0){
			if(table.lookup(t)){
				System.out.println(t);
			}
		}
		else{
			for(int i=0;i<node.adjNodeCount;i++){
				Node n = node.adjacents[i];
				recurse(n,t,depth-1);
			}
		}
	}
	
	public static void makeTable(HashTable table) throws Exception{
		File words = new File("words.txt");
		Scanner input = new Scanner(words);
		//int counter = 0;
		while(input.hasNextLine()){
			table.addWord(input.nextLine());
			//input.nextLine();
			//counter++;		
			//System.out.println(counter);
		}

	}
}
