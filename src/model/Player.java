package model;


public class Player {
    String id;
    int startX;
    int endX;
    int startY;
    int endY;

    public Player(String id, int startX, int endX, int startY, int endY) {
        this.id = id;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    public String getId(){
        return id;
    }

}
