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
	}
	float top, center, wid;
	int mode = 7;
	
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
			case 5: {// 2 reactive boxes
				top = 50;
				center = 250;
				wid = 200;
				if (mouseX <= center){
					rect(top, top, wid, wid*2); //x, y, w, h
				}else{
					rect(center, top, wid, wid*2);
				}fill(130,255,255);
				break;
			}
					
			
			case 6: {//4 reactive boxes
				top = 50;
				center = 250;
				wid = 200;
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
				top = 50;
				center = height / 2.0f;
				wid = 200;
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
		}

	}
}
