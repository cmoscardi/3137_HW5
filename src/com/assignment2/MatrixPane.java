package com.assignment2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class MatrixPane extends JComponent{
	Node[] matrix;
	int width;
	int height;
	Ellipse2D[] cats;
	public MatrixPane(Node[] m, int width, int height){
		matrix = m;
		this.width = width;
		this.height = height;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		g.drawString("Flute", 20, 20);
		cats = new Ellipse2D[18];
		int i=0;
		for(Node n:matrix){
			String letter = Character.toString(n.letter);
	
			if(n.z==0){
				Ellipse2D cat = new Ellipse2D.Double(40+n.x*(height/6),60+n.y*(height/6) , 20, 20);
				g2.draw(cat);
				g2.setColor(Color.RED);
				g2.drawString(letter,(int) cat.getCenterX()-3 , (int) cat.getCenterY() +3);
				cats[i]=cat;
				n.circle=cat;
			}
			else{
				Ellipse2D cat = new Ellipse2D.Double(80+n.x*(height/6),30+n.y*(height/6) , 20, 20);
				g2.draw(cat);
				g2.setColor(Color.RED);
				g2.drawString(letter,(int) cat.getCenterX()-3 , (int) cat.getCenterY()+3);
				cats[i]=cat;
				n.circle=cat;
			}
			i++;
			g2.setColor(Color.BLACK);
		}
		//muahaha this is so inefficient
		for(i=17;i>=0;i--){
			for(int j=0;j<i;j++){
				for(int k=0;k<matrix[i].adjNodeCount;k++){
					if(matrix[i].adjacents[k].equals(matrix[j]))
						g2.drawLine((int) cats[i].getCenterX(), (int) cats[i].getCenterY(),(int) cats[j].getCenterX(),(int) cats[j].getCenterY());
				}
			}
		}
		
	}
	
}
