package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 17, bar;
	float top, center, wid;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		top = 50;
		center = height / 2.0f;
		wid = 200;
		background(0);
		bar = 10;
	}

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}
	
	public void mousePressed(){
		mode = (mode +1) % 18;
	}
	
	float magicMap(float a, float b, float c, float d, float e) {
		float output;
		a -= b;
		c -= b;
		e -= d;
		
		output = ((a / c) * e) + d;
		
		return output;
		/* 
		map(a, b, c, d, e){
			r1 = c - b
			r2 = e - d
			return = (((a - b) / r1) * r2) + d
		}
		*/
	}

	float magicMap1(float a, float b, float c, float d, float e) {
		float r1 = c - b;
		float r2 = e - d;
		float howFar = a - b;
		
		return d + ((howFar / r1) * r2);
	}

	float offset = 0;

	public void draw() {
		background(0);
		switch (mode) {
			case 0:{ // rainbow bars
				int changingBars = (int) (mouseX / 20.0f);
				float w = width / (float) changingBars;
				for (int i = 0; i < changingBars; i++) {
					noStroke();
					fill(map(i, 0, changingBars, 0, 255), 255, 255);
					rect(map(i, 0, changingBars, 0, 500), 0, w, height);
				}
				break;
			}
			case 1: 
			{ // x Box rainbow
				int changingBars = (int) (mouseX / 20.0f);
				float w = width / (float) changingBars;
				for (int i = 0; i < changingBars; i++) {
					noStroke();
					fill(map(i, 0, changingBars, 0, 255), 255, 255);
					float x = map(i, 0, changingBars, 0, width);
					rect(x, x, w, w);
					rect((width - w) - x, x, w, w);
				}
				break;
				// map(a,b,c,d,e);
				// a = inputvalue
				// b - c - start and end of the first range
				// d, e 0 - start and and of the end range
			}//end case 1
			
			case 2:
			{ // stacking circles
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
			{ //rainbow circles (single line)
				float wid = width / (float) bar;
				for (int i = 0; i < bar; i++) {
					noStroke();
					float c = map(i, 0, bar * 2, 0, 255);
					fill(c, 255, 255);
					circle(map(i, 0, bar - 1, wid / 2.0f, width - (wid/2.0f)), height / 2, wid);
				}
				break;
			} // end case 3
			case 4:
			{ // rainbow polkas
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
			/*
			case 3:
				background(0);
				colorMode(RGB);
				float border = width * 0.1f;
				for(int i = -5; i <= 5; i ++)
				{
					float x = map(i, -5, 5, border, width - border);
					stroke(0, 255, 0);
					line(x, border, x, height - border);
					line(border, x, width - border, x);
					fill(255);
					text(i, x, border * 0.5f);
					text(i, border * 0.5f, x);
				}
			case 4:
				background(0);
				stroke(255, 255, 255);	
				float cx = width / 2;
				float cy = height / 2;	
				float radius = 200;		
				int points = (int)map(mouseX, 1, width, 5, 20);
				int sides = points * 2;
				float px = cx;
				float py = cy - radius; 
				for(int i = 0 ; i <= sides ; i ++)
				{
					float r = (i % 2 == 0) ? radius : radius / 2; 
					// float r = radius;
					float theta = map(i, 0, sides, 0, TWO_PI);
					float x = cx + sin(theta) * r;
					float y = cy - cos(theta) * r;
					
					//circle(x, y, 20);
					line(px, py, x, y);
					px = x;
					py = y;
				}
*/
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
			case 8: {//matrix box
				float jumpx = width / 12.0f;
				float jumpy = height/ 12.0f;
				stroke(200, 255, 255);
				for(int i = 1, j = -5; i <= bar+1; i++, j++){
					text(j, jumpx * i, jumpy/2.0f);
					text(j, jumpx/2.0f, jumpy * i);
					line(jumpx, jumpy*i, width - jumpx, jumpy*i);
					line(jumpx*i, jumpy, jumpx*i, height - jumpy);
				}
				break;
			}
			case 9: {//matrix box v2
				float border = width *0.1f;
				for(int i = -5; i <= bar/2; i++){
					float x = map(i, -5, 5, border, width - border);
					stroke(100, 255, 255);
					line(x, border, x, height-border);
					line(border, x, width - border, x);
					text(i,x,border*0.5f);
					text(i,border*0.5f,x);
					}
				break;
			}
			case 10: {//checker box
				//elementary cellular automata
				float jumpx = width / (float) (bar*2);
				float jumpy = height/ (float) (bar*2);
				for(int i = 0; i <= (bar*2+1); i++){
					for(int j = 0; j <= (bar*2); j++){
						noStroke();
						float x = jumpx * (float)i;
						float y = jumpy * (float)j;
						rect(x,y,jumpx,jumpy);
						fill(200,255,255);
						if ((i%2) == (j%2)){
							fill(20,255,255);
						}
					}
				}
				break;
			}
			case 11: {//polygons
				int sides = (mouseX / 50);
				float theta = TWO_PI / (float) sides;
				float radius = 200;
				stroke(255);
				for(int i = 1; i <= sides; i++){
					float x1 = sin(theta * (i - 1)) * radius;
					float y1 = cos(theta * (i - 1)) * radius;
					float x2 = sin(theta * i) * radius;
					float y2 = cos(theta * i) * radius;
					line(center + x1, center + y1, center + x2, center + y2);
				}
				break;
			}
			case 12: {//mushroom circle
				stroke(255);
				int sides = (int) map(mouseX, 50, width, 0, 20);
				float cx = width/2.0f;
				float cy = height/2.0f;
				float radius = 200;
				for(int i = 0; i < sides; i++)
				{
					float theta = map(i, 0, sides, 0, TWO_PI);
					float x = cx + sin(theta) * radius;
					float y = cy + cos(theta) * radius;
					circle(x, y, 20);
				}
				break;
			}
			case 13: {//polygons v2
				stroke(255);
				int sides = (int) map(mouseX, 50, width, 0, 20);
				float cx = width/2.0f;
				float cy = height/2.0f;
				float radius = 200;
				for(int i = 1; i <= sides; i++)
				{
					float theta1 = map(i-1, 0, sides, 0, TWO_PI);
					float x1 = cx + sin(theta1) * radius;
					float y1 = cy + cos(theta1) * radius;

					float theta2 = map(i, 0, sides, 0, TWO_PI);
					float x2 = cx + sin(theta2) * radius;
					float y2 = cy + cos(theta2) * radius;
					line(x1,y1,x2,y2);
				}
				break;
			}
			case 14://stroke lines upside down
			{
				stroke(255);
				int sides = 5;
				float cx = width/2.0f;
				float cy = height/2.0f;
				float radius = 200;
				for(int i = 1; i <= sides; i++)
				{
					float theta1 = map(i-1, 0, sides, 0, TWO_PI);
					float x1 = cx + sin(theta1) * radius;
					float y1 = cy + cos(theta1) * radius;
					line(x1,y1,cx,cy);
				}
				break;
			}
			case 15://stroke lines
			{
				stroke(255);
				int sides = 5;
				float cx = width/2.0f;
				float cy = height/2.0f;
				float radius = 200;
				for(int i = 1; i <= sides; i++)
				{
					float theta1 = map(i, 0, sides, TWO_PI, 0);
					float x1 = cx - sin(theta1) * radius;
					float y1 = cy - cos(theta1) * radius;
					line(x1,y1,cx,cy);
				}
				break;
			}
			case 16: //star??
			{
				
				stroke(255);
				float edges = 10;
				float angle = TWO_PI / edges;
				int radius1 = 200;
				int radius2 = 100;
				float cx = width/2.0f;
				float cy = height/2.0f;
				float halfAngle = angle/2.0f;
				float mx = cx + cos(TWO_PI-(angle/2))*radius1;
				float my = cy + sin(TWO_PI-(angle/2))*radius1;
				float sx = 0, sy = 0;

				for (float a = 0; a < TWO_PI; a += angle) {
					sx = cx + cos(a) * radius2;
					sy = cy + sin(a) * radius2;
					line(sx,sy,mx,my);
					mx = cx + cos(a+halfAngle) * radius1;
					my = cy + sin(a+halfAngle) * radius1;
					line(sx,sy,mx,my);
				}
				break;
			}
			case 17: //james bond looking thing (spiral around circle)
			{
				stroke(255);
				float edges = (int) map(mouseX, 50, width, 0, 50);
				int radius1 = 200;
				int radius2 = 100;
				float cx = width/2.0f;
				float cy = height/2.0f;
				for (float a = 1; a <= edges; a ++) {
					float theta1 = map(a-1, 0, edges, 0, TWO_PI);
					float x1 = cx + sin(theta1) * radius1;
					float y1 = cy + cos(theta1) * radius1;

					float theta2 = map(a, 0, edges, 0, TWO_PI);
					float x2 = cx + sin(theta2) * radius2;
					float y2 = cy + cos(theta2) * radius2;
					line(x1,y1,x2,y2);
				}
				break;
			}
			case 18: //james bond looking thing (spiral around circle)
			{
				stroke(255);
				float edges = (int) map(mouseX, 50, width, 0, 50);
				int radius1 = 200;
				int radius2 = 100;
				float cx = width/2.0f;
				float cy = height/2.0f;
				for (float a = 1; a <= edges; a ++) {
					float theta1 = map(a-1, 0, edges, 0, TWO_PI);
					float x1 = cx + sin(theta1) * radius1;
					float y1 = cy + cos(theta1) * radius1;

					float theta2 = map(a, 0, edges, 0, TWO_PI);
					float x2 = cx + sin(theta2) * radius2;
					float y2 = cy + cos(theta2) * radius2;
					line(x1,y1,x2,y2);
				}
				break;
			}
		}//end switch
	}// end draw()
}
