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
		wid = 200;
	}
	float top, center, wid;
	int mode = 0;
	
	public void mousePressed(){
		mode = (mode +1) % 9;
	}

	float MagicMap(float i,float a,float b,float c,float d){
		float output;
		i -= a;
		b -= a;
		d -= c;

		output = ((i/b)*d) +c;
		return output;
		/* 
		map(a, b, c, d, e){
			r1 = c - b
			r2 = e - d
			return = (((a - b) / r1) * r2) + d
		}
		*/
	}
	

	public void draw()
	{	
		background(255, 0, 0);
		//rectMode(CENTER);
		
		
		switch (mode) {
			case 0: if (mouseX <= center){
						rect(top, top, wid, wid*2);
					}else{
						rect(center, top, wid, wid*2);
					}fill(130,255,255);
					break;
			
			case 1: //
					int bars = 10;
					float w = width / (float) bars;
					for (int i = 0; i < bars; i++){
						noStroke();
						fill(map(i, 0, 10, 0, 255), 255, 255);
						rect(map(i, 0, 10, 0, 500), 0, w, height);
					}
					break;
			case 2:
					//map(a,b,c,d,e);
					//a=inputvalue
					//b-c - start and end of the first range
					//d, e 0 - start and and of the end range
					map(-2, 10, 90, 200, 233);
					break;
		}
		

	}
}
