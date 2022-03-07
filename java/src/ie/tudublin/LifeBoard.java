package ie.tudublin;

import java.net.http.HttpResponse.PushPromiseHandler;

import javax.sound.sampled.FloatControl;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    int size;
    float cellSize;

    PApplet pa;

    public LifeBoard(int size, PApplet pa){
        board = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellSize = pa.width / (float) size;
    }

    public void randomiser(){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                board[row][col] = pa.random(1.0f) > 0.5f;
            }
        }
    }

    public void render(){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                float x = pa.map(col, 0, size, 0, pa.width);
                float y = pa.map(row, 0, size, 0, pa.height);
                x = cellSize * col;
                y = cellSize * row;

                if(board[row][col]){
                    pa.fill(0,255,0);
                }else{
                    pa.noFill();
                }
                pa.rect(x,y,cellSize,cellSize);
                
            }
        }
    }
}
