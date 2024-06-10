package SnakeAndLadder;

public class Player {
    private final String name;
    private int position;

    public Player(String name){
        this.name = name;
        this.position = 0;
    }

    public void move(int newPosition){
        this.position = newPosition;
    }
    public int getPosition(){
        return position;
    }
    public String getName(){
        return name;
    }
}
