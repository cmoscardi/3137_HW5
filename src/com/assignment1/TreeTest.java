package com.assignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeTest {
	
	public static void main(String[] args) throws Exception{
		ArrayList<City> cities = new ArrayList<City>();

		
		/**
		 * Collect city names and info
		 */
		File f = new File("cityxy.txt");
		Scanner g = new Scanner(f);
		int x = -1;
		int y = -1;
		String name = "error";
		while(g.hasNext()){
			name = g.next();
			x = Integer.parseInt(g.next());
			y = Integer.parseInt(g.next());
			City c = new City(name,x,y);
			cities.add(c);
			System.out.print(name+"|"+x+"|"+y+"\n");
		}
		
		
		
		
	}
	
}
