package SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer, Integer> snakesAndLadders;

    public Board(int size){
        this.size = size;
        this.snakesAndLadders = new HashMap<>();
    }

    public void addSnakeOrLadder(int start, int end){
        snakesAndLadders.put(start, end);
    }
    public int getNewPosition(int position){
        return snakesAndLadders.getOrDefault(position, position);
    }
    public int getSize(){
        return size;
    }
}
