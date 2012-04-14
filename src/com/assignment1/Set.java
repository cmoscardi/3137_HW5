package com.assignment1;

import java.util.ArrayList;


public class Set {
	private ArrayList<City> elements;
	public Set(City c){
		elements = new ArrayList<City>();
		elements.add(c);
	}
	
	public boolean contains(City c){
		return elements.contains(c);
	}
	
	public Set union(Set s1, Set s2){
		for(int i=0;i<s2.elements.size();i++){
			s1.elements.add(s2.elements.get(i));
		}
		return s1;
	}
}
