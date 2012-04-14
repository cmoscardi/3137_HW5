package com.assignment2;

import java.io.File;
import java.util.Scanner;

public class MatrixTest {
	public static void main(String[] args) throws Exception{
		File matrix = new File("graph.txt");
		Scanner read = new Scanner(matrix);
		while(read.hasNextLine()){
			String x = read.nextLine();
			String[] y = x.split(" ");
			
			//awmagawd letter
			if(y.length==1){
				Node n = new Node();
				n.letter = y[0].charAt(0);
				//next line is def coordinates
				x = read.nextLine();
				y = x.split(" ");
				n.x = Integer.parseInt(y[0]);
				n.y = Integer.parseInt(y[0]);
				n.z = Integer.parseInt(y[0]);
			}
			//awmagawd 3 numbers
			else{
				
			}
		}
	}
}
