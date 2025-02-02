package ie.tudublin;

import processing.core.PApplet;

public class TimingExample extends PApplet{
    int mode = 0;
    Drawable d = new CircleDrawable(this);

    public void setup(){

    }
    public void settings(){
        size(500, 500);
    }
    public void draw(){
        int m = millis(); //returns an int with the time passed
        if(m > 4000){
            if(d instanceof RectDrawable){
                d = new CircleDrawable(this);
            }
            mode = 1;
        }else if(m > 2000){
            d = new RectDrawable(this);
            mode = 0;
        }//has to be in a reverse order
        
        background(0);
        d.render();
        /*
        if(frameCount == 120){ //counts the frames that have passed assumes 60FPS
            mode = 1;
        }
        if(frameCount == 240){
            mode = 0;
        }
        */
        //where the type is of the superclass but the instance of the supeclass can be of any
        /*switch (mode){
            case 0:{
                circle(width/2, height/2, 100);
                break;
            }

            case 1:{
                rectMode(CENTER);
                rect(width/2, height/2, 100, 100);
                break;
            }
            default:{
                break;
            }
        }*/


    }

}
