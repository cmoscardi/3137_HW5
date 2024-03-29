package com.assignment1;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelHell extends JPanel{
	private Graph graph;
	private int height;
	private int width;
	public PanelHell(Graph g, int width, int height){
		setSize(width,height);
		this.height = height;
		this.width = width;
		this.graph = g;
	}
	
	public void paint(Graphics g){
		for(City c : graph.getCities()){
			g.drawOval((c.getX()/5), height-(c.getY()/5), 3, 3);
			Font font = new Font("Times New Roman",0,8);
			g.setFont(font);
			//System.out.println(c.getName());
			g.drawString(c.getName(), c.getX()/5, height-(c.getY()/5));
		}
		for(Edge e: graph.getEdges()){
			City c1 = e.getCities()[0];
			City c2 = e.getCities()[1];
			int x1 = c1.getX()/5;
			int y1 = height - c1.getY()/5;
			int x2 = c2.getX()/5;
			int y2 = height - c2.getY()/5;
			g.drawLine(x1, y1, x2, y2);
		}
		
	}
	
	

}
