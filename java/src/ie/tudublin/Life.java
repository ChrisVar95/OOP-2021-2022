package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
	
	LifeBoard board;
	int screensize = 500;
	int mode = 0;


	public void settings() {
		size(1000, 1000);
		board = new LifeBoard(200, this);
		//board.randomise();
		println(board.countCellsAround(1, 1));
	}

	public void setup() {
		colorMode(RGB);
	}
	
	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}

	public void mouseDragged(){
		//int col = (int) (mouseX / (board.cellSize));
		int col = (int) map(mouseX, 0, width, 0, board.size);
		int row = (int) map(mouseY, 0, height, 0, board.size);
		board.setAlive(row, col, true);
	}
	
	public void draw() {
		board.render();
		board.update();
		switch (mode){
			case 1: { //resets board
				board.randomise();
				mode = 0;
				break;
			}
			case 2:{
				board.cross();
				mode = 0;
				break;
			}
		}
	}
}
