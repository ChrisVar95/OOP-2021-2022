package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		top = 50;
		center = 250;
		width = 200;
	}
	float top, center, width;
	int mode = 0;
	
	public void keyPressed(){
		if (mousePressed == true) {
			if (mode < 9) {
				mode++;
			}else {
				mode = 0;
			}
		}
	}
	
	public void draw()
	{	
		background(255, 0, 0);
		//rectMode(CENTER);
		
		
		switch (mode) {
			case 0: if (mouseX <= center){
						rect(top, top, width, width*2);
					}else{
						rect(center, top, width, width*2);
					}fill(130,255,255);
					break;
			
			case 1: if (mouseX <= center){
						rect(top, top, width, width*2);
					}else{
						rect(center, top, width, width*2);
					}fill(100,255,255);
					break;
		}
		

	}
}
