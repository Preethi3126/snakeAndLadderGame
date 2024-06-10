package SnakeAndLadder;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final List<Player> players;
    private final Board board;
    private final Dice dice;

    public Game(int boardSize, List<Player> players){
        this.board = new Board(boardSize);
        this.players = players;
        this.dice = new Dice();
        setupBoard();

    }
    public void setupBoard(){
        board.addSnakeOrLadder(12, 2);
        board.addSnakeOrLadder(25, 10);
        board.addSnakeOrLadder(40, 3);
        board.addSnakeOrLadder(56, 20);
        board.addSnakeOrLadder(78, 45);
        board.addSnakeOrLadder(90, 30);
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while(!gameWon){
            for (Player player : players){
                System.out.println(player.getName()+"'s turn. ");
                scanner.nextLine();

                int diceValue = dice.roll();
                System.out.println(player.getName()+" rolled a "+diceValue);

                int newPosition = player.getPosition() + diceValue;
                if(newPosition > board.getSize()){
                    newPosition = board.getSize();
                }
                newPosition = board.getNewPosition(newPosition);
                player.move(newPosition);
                System.out.println(player.getName()+ " is now at position "+player.getPosition());

                if(player.getPosition() == board.getSize()){
                    System.out.println("Congratulations "+player.getName()+" wins the game! ");
                    gameWon = true;
                    break;
                }
            }
        }
        scanner.close();
    }
}
