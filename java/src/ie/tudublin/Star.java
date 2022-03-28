package ie.tudublin;

import processing.data.TableRow;

public class Star {
    private boolean hab;
    private String displayName;
    private float distance;
    private float Xg, Yg, Zg;
    private float absMag;

    @Override //this method overrides a method in the superclass java
    public String toString() {
        return "Star [Xg=" + Xg + ", Yg=" + Yg + ", Zg=" + Zg + ", absMag=" + absMag + ", displayName=" + displayName
                + ", distance=" + distance + ", hab=" + hab + "]";
    }

    public Star(TableRow tr){
        this(
            tr.getInt("Hab?") == 1,
            tr.getString("Display Name"), 
            tr.getFloat("Distance"),
            tr.getFloat("Xg"),
            tr.getFloat("Yg"),
            tr.getFloat("Zg"),
            tr.getFloat("AbsMag")
        );
    }

    public Star(boolean hab, String displayName, float distance, float xg, float yg, float zg, float absMag) {
        this.hab = hab; //disambiguating
        this.displayName = displayName;
        this.distance = distance;
        Xg = xg;
        Yg = yg;
        Zg = zg;
        this.absMag = absMag;
    }

    public void render(){
    }

    public boolean isHab() {
        return hab;
    }
    public void setHab(boolean hab) {
        this.hab = hab;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public float getDistance() {
        return distance;
    }
    public void setDistance(float distance) {
        this.distance = distance;
    }
    public float getXg() {
        return Xg;
    }
    public void setXg(float xg) {
        Xg = xg;
    }
    public float getYg() {
        return Yg;
    }
    public void setYg(float yg) {
        Yg = yg;
    }
    public float getZg() {
        return Zg;
    }
    public void setZg(float zg) {
        Zg = zg;
    }
    public float getAbsMag() {
        return absMag;
    }
    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }
}
