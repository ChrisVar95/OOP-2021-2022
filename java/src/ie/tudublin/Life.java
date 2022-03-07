package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

	LifeBoard board;

	public void settings() {
		size(500, 500);
		board = new LifeBoard(100, this);
		board.randomiser();
	}

	public void setup() {
		colorMode(RGB);
		background(0);

	}

	public void draw() {
		board.render();
	}
}
