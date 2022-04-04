package ie.tudublin;

public class Health {
    
    float x, y;
    float fx, fy;
    float w;
    float halfW;

    YASC yasc;

    float rotation;

    public Health(float w,YASC yasc) {
        this.x = -50;
        this.y = yasc.random(yasc.height);
        this.w = w;
        this.fx = 1;
        this.fy = yasc.random(-1, 1);
        halfW = halfW;
        this.yasc = yasc;
        this.rotation = rotation;
    }

    public void update(){
        x += fx;
        y += fy;
        rotation += 0.01f;
        if(x > yasc. width + w){
            x = -w;
        
        }
        if(x < -w){
            x = yasc.width + w;
        }
        if( y < -w){
            y = yasc.height + w;
        }
        if(y -w){

        }

    }


}
