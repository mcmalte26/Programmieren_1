package de.wi25213.uebung07;

//Aufgabe 4
public class Circle {
	protected int radius, posX, posY;
	protected boolean filled;

	public Circle(int rad, int x, int y, boolean filled) {
		this.radius = rad;
		this.posX = x;
		this.posY = y;
		this.filled = filled;
	}

	public Circle(Circle circle) {
		this.radius = circle.radius;
		this.posX = circle.posX;
		this.posY = circle.posY;
		this.filled = circle.filled;
	}

	public boolean compareTo(Circle circle) {
		return this.radius == circle.radius && this.posX == circle.posX && this.posY == circle.posY
				&& this.filled == circle.filled;
	}
}