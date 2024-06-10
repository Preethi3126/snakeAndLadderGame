import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadderGame {
    private static final int BOARD_SIZE = 100;
    private static final Map<Integer, Integer> snakesAndLadders = new HashMap<>();

    static {
        // Define the positions of snakes and ladders
        snakesAndLadders.put(12, 2);
        snakesAndLadders.put(25, 10);
        snakesAndLadders.put(40, 3);
        snakesAndLadders.put(56, 20);
        snakesAndLadders.put(78, 45);
        snakesAndLadders.put(90, 30);
    }

    private static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Generate a random number between 1 and 6
    }

    private static int movePlayer(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;
        // Check for snakes and ladders
        if (snakesAndLadders.containsKey(newPosition)) {
            newPosition = snakesAndLadders.get(newPosition);
        }
        // Ensure the player doesn't go beyond the board size
        return Math.min(newPosition, BOARD_SIZE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerPosition = 0;
        int currentPlayer = 1;

        while (playerPosition < BOARD_SIZE) {
            System.out.println("Player " + currentPlayer + "'s turn. Press enter to roll the dice.");
            scanner.nextLine();

            int diceValue = rollDice();
            System.out.println("You rolled a " + diceValue);

            playerPosition = movePlayer(playerPosition, diceValue);
            System.out.println("You are now at position " + playerPosition);

            if (playerPosition == BOARD_SIZE) {
                System.out.println("Congratulations! Player " + currentPlayer + " wins!");
                break;
            }

            currentPlayer = currentPlayer == 1 ? 2 : 1; // Switch players
        }

        scanner.close();
    }
}
