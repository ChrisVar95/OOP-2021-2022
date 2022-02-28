package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {


    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };

    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    float[] a1 = new float[100];
    float[] a2;

    int minIndex = 0;
    int maxIndex  = 0;

    int mode = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}
        

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        for(int i = 0 ; i < rainfall.length ; i ++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        for(float r:rainfall)
        {
            println(r);
        }
        
        int j = 0;
        for(float r:rainfall)
        {
            println(r + "\t" + months[j]);
            j ++;
        }

        for(int i = rainfall.length - 1; i >= 0 ; i -- )
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        for(int i = 1 ; i < rainfall.length ; i ++)
        {
            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            else if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            } 
        }

        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);

    }

    public void draw()
    {
        switch (mode) {
			case 0:
            {
                background(0);
                colorMode(HSB);
                float w = width / (float)rainfall.length;
                noStroke();
                for(int i = 0 ; i < rainfall.length ; i ++)
                {
                    float x = map(i, 0, rainfall.length, 0, width);
                    int c = (int)map(i, 0, rainfall.length, 0, 255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
                    rect(x, height, w, h);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(months[i], x + (w / 2), height - 50);
                }
                break;
            }
            case 1:
            {
                background(0);
                float border = width * 0.1f;
                // Draw the axis
                stroke(255);
                line(border, border, border, height - border);
                line(border, height - border, width - border, height - border);
                for(int i = 0 ; i <= 120; i += 10)
                {
                    float y = map(i, 0, 120, height - border, border);
                    line(border - 5, y, border, y);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(i, border / 2, y);
                }
                float w = (width - (border * 2.0f)) / (float)rainfall.length;
                
                for(int i = 0 ; i < rainfall.length; i ++)
                {
                    float x = map(i, 0, rainfall.length, border, width-border);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    stroke(255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, 120, 0, -height + (border * 2.0f)); 
                    rect(x, height-border, w, h);
                    fill(255);
                    text(months[i], x + (w / 2), height - (border / 2));
    
                }
                break;
            }
            case 2:
                background(0);
                float r = mouseX;
                float cx = width / 2;
                float cy = height / 2;
                stroke(255);
                noFill();
                //circle(cx, cy, r * 2.0f);
                float tot = 0;
                for(float f:rainfall)
                {
                    tot += f;
                }
                float start = 0;
                for(int i = 0 ; i < rainfall.length ; i ++)
                {
                    float val = map(rainfall[i], 0, tot, 0, TWO_PI);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    noStroke();
                    fill(c, 255, 255);
                    arc(cx, cy, r * 2, r * 2, start, start + val, PIE);
                    
                    float theta = start + (val * 0.5f);
                    float x = cx + cos(theta) * (r * 1.2f);
                    float y = cy + sin(theta) * (r * 1.2f);
                    fill(255);
                    text(months[i], x, y);
                    start = start + val;
                    
                }

                break;
            }        
    }    
}
        /*package ie.tudublin;
        
        import processing.core.PApplet;
        
        public class Arrays extends PApplet {
        
            float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
        
            float[] a1 = new float[100];
            float[] a2; // this is a reference to an array but there is no memory allocated to it
        
            String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
        
            int min = 0, max = 0;
            float total = 0;
        
            public void settings() {
                size(500, 500);
            }//
        
            public void setup() {
                colorMode(HSB);
                for (int i = 1; i < rainfall.length; i++) {
                    println(rainfall[i] + "\t" + months[i]);
                }
                for (float r : rainfall)// advanced for loop
                {
                    println(r);
                }
                for (int j = rainfall.length - 1; j >= 0; j--) {
                    println(rainfall[j] + "\t" + months[j]);
                }
                for (int k = 0; k < rainfall.length; k++) {
                    if (rainfall[min] > rainfall[k]) {
                        min = k;
                    } else if (rainfall[max] < rainfall[k]) {
                        max = k;
                    }
                    total += rainfall[k];
                }
                println("smallest amount = " + rainfall[min] + "\t" + months[min]);
                println("largest amount = " + rainfall[max] + "\t" + months[max]);
                println("total rainfall = " + total);
                println("average rainfall = " + total / rainfall.length);
        
            }// end setup()
        
            public void draw() {
                /*
                background(0);
                float wid = width / 20.0f;
                float padding = width * 0.1f;
                float bottomy = height - padding;
                float w = (width/(float) (rainfall.length-1))-(padding/2.2f);
                noStroke();
                
                for (int i = 0; i < rainfall.length; i++) {
                    float x = map(i, 0, rainfall.length, padding * 2, width - padding);
                    float h = map(rainfall[i], 0, rainfall[max] + padding / 2, 0, -height);
                    rect(x, bottomy, wid, -rainfall[i] * 3.6f);
                    fill(map(i, 0, rainfall.length, 0, 255), 255, 255);
                    textAlign(CENTER, CENTER);
                    text(months[i], x + (wid / 2), height - (padding / 2));
                }
                for (int i = 0; i <= rainfall.length; i++) {
                    stroke(200);
                    line(padding * 2, padding, padding * 2, height - padding); // x axis
                    line(padding * 2, height - padding, width - padding, height - padding); // y axis
                    float y = map(i, 0, rainfall.length, padding, height - padding);
                    line(padding * 2, y, (padding * 2) - 10, y);
                    float r = map(i,  rainfall.length,0, 0, 120);
                    text((int)r, padding, y);
                }
        
                
                for(int i = 1; i < rainfall.length; i++)
                {
                float y1 = (rainfall[i-1]-padding)*3.6f;
                float y2 = (rainfall[i]-padding)*3.6f;
                float x = map(i, 0, rainfall.length-1, padding * 3, width - padding*2);
                line(x-w , height-y1-(padding*4.6f), x, height-y2-(padding*4.6f));
                }
        */
        /*
                //________________________________________
                background(0);
                float border = width * 0.1f;
                // Draw the axis
                stroke(255);
                line(border, border, border, height- border);
                line(border,height-border, width-border, height-border);
                for(int i = 0; i <= 120; i += 10)
                {
                    float y = map(i, 0, 120, height - border, border);
                    line(border - 5, y, border, y);
                    textAlign(CENTER,CENTER);
                    text(i, border / 2, y);
                }
                float w = (width - (border * 2))/ (float)rainfall.length;
                for(int i = 0; i < rainfall.length; i++)
                {
                    float x = map(i, 0, rainfall.length, border, width - border);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    stroke(255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, 120, 0, height - (border * 2.0f));
                    rect(x, height-border, w, -h);
                    fill(255);
                    text(months[i], x + (w/2), height - border / 2);
                }
                */
                //*Pi Chart
                background(0);
                float r = width *0.3f;
                float cx = width / 2, cy = height / 2;
                stroke(255);
                noFill();
                //circle(cx, cy, r * 2.0f);
                float tot = 0;
                for(float f:rainfall)
                {
                    tot += f;
                }
                float start = 0;
                for(int i = 0; i < rainfall.length; i++)
                {
                    float val = map(rainfall[i], 0, tot, 0, TWO_PI);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    noStroke();
                    fill(c, 255, 255);
                    arc(cx, cy, r* 2, r*2, start, start + val, PIE);
                    
                    float theta = start + (val * 0.5f);
                    float x = cx + cos(theta) * (r * 1.2f);
                    float y = cy + sin(theta) * (r * 1.2f);
                    fill(255);
                    text(months[i],x,y);
                    start = start + val;
                }
        
            }// end draw()
        
        }// end Arrays()
