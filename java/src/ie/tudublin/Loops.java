package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
	float top, center, wid;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		top = 50;
		center = height / 2.0f;
		wid = 200;
	}

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
		background(0);
	}
	
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
	
	float magicMap(float a, float b, float c, float d, float e) {
		float output;
		a -= b;
		c -= b;
		e -= d;
		
		output = ((a / c) * e) + d;
		
		return output;
	}

	float magicMap1(float a, float b, float c, float d, float e) {
		float r1 = c - b;
		float r2 = e - d;
		float howFar = a - b;
		
		return d + ((howFar / r1) * r2);
	}

	float offset = 0;

	public void draw() {
		switch (mode) {
			case 0:
			background(0);
			int bars = (int) (mouseX / 20.0f);
			float w = width / (float) bars;
			for (int i = 0; i < bars; i++) {
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}
				break;
			case 1: 
			{
				background(0);
				int squares = (int) (mouseX / 20.0f);
				float h = width / (float) squares;
				for (int i = 0; i < squares; i++) {
					noStroke();
					fill(map(i, 0, squares, 0, 255), 255, 255);
					float x = map(i, 0, squares, 0, width);
					rect(x, x, h, h);
					rect((width - h) - x, x, h, h);
				}
				break;
				// map(a,b,c,d,e);
				// a = inputvalue
				// b - c - start and end of the first range
				// d, e 0 - start and and of the end range
			}//end case 1
			
			case 2:
			{
				background(0);
				int bar = 10;
				float midx = width / 2;
				float midy = height / 2;
				float circles = width / (float) bar;
				for (int i = bar; i > 0; i--) {
					noStroke();
					fill(map(i, 0, bar, 20, 200), 255, 255);
					circle(midx, midy, circles * i);
				}
				break;
			} // end case 2
			case 3:
			{
				background(0);
				int rounds = 10;
				float wid = width / (float) rounds;
				for (int i = 0; i < rounds; i++) {
					noStroke();
					float c = map(i, 0, rounds * 2, 0, 255);
					fill(c, 255, 255);
					circle(map(i, 0, rounds - 1, wid / 2.0f, width - (wid/2.0f)), height / 2, wid);
				}
				break;
			} // end case 3
			case 4:
			{
				background(0);
				int circles = (int) (mouseX / 20.0f);
				offset += (mouseY / 100.0f);
				float d = width / (float) circles;
				for (int j = 0; j < circles; j++) {
					for (int i = 0; i < circles; i++) {
						noStroke();
						float c = map((i + j + offset), 0, circles * 2, 0, 255) % 256;
						fill(c, 255, 255);
						float x = map(i, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						float y = map(j, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						circle(x, y, d);
					}
				}
				break;
			}// end case 4

			case 5: {// 2 reactive boxes
				if (mouseX <= center){
					rect(top, top, wid, wid*2); //x, y, w, h
				}else{
					rect(center, top, wid, wid*2);
				}fill(130,255,255);
				break;
			}
					
			
			case 6: {//4 reactive boxes
				if (mouseX <= center && mouseY <= center){
					rect(top, top, wid, wid);
				}else if (mouseX <= center && mouseY >= center){
					rect(top, center, wid, wid);
				}else if (mouseX >= center && mouseY <= center){
					rect(center, top, wid, wid);
				}else{
					rect(center, center, wid, wid);
				}fill(130,255,255);
				break;
			}
			
			case 7: {// 1 reactive box change color
				float boxX = center - (wid/2.0f);
				float boxY = center - top;
				rect(boxX, boxY, wid, top); //x, y, w, h
				if (mouseX >= boxX && mouseX <= boxX + wid && mouseY >= boxY && mouseY <= boxY + top){
					fill(0,255,255);
				}else{
					fill(130,255,255);
				}
				break;
			}
		}//end switch
	}// end draw()
}
