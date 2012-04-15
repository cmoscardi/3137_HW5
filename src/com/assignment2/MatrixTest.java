package com.assignment2;

import java.io.File;
import java.util.Scanner;

public class MatrixTest {
	public static void main(String[] args) throws Exception{
		Node[] nodes = new Node[20];
		File matrix = new File("graph.txt");
		Scanner read = new Scanner(matrix);
		while(read.hasNextLine()){
			String x = read.nextLine();
			String[] y = x.split(" ");
			Node n=null;;
			int counter =0;
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
				nodes[counter++]=n;
			}
			//awmagawd 3 numbers
			else{
				n.addNCoords(Integer.parseInt(y[0]),Integer.parseInt(y[1]),Integer.parseInt(y[2]));
			}
		}
	}
}
