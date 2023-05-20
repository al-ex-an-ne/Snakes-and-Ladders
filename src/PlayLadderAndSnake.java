import java.util.Scanner;

/**
 * <h2> Play Ladder And Snake! </h2>
 * This driver allows the user to play a game of Ladder And Snake using
 *  the Ladder And Snake class. The game can only be played by 2 players.
 *  It outputs every event and the board after every turn.
 * 
 * @author Alexanne Marcil
 * @see "LadderAndSnake"
 */
public class PlayLadderAndSnake {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		
		// Displays a welcome message
		System.out.println("Welcome to the Ladder And Snake game!\n");
		
		// Prompt the user to input the number of players and initializes it
		System.out.print("How many players will be playing? ");
		int nbOfPlayers;
		if (keyIn.hasNextInt()) {
			 nbOfPlayers = keyIn.nextInt();
			if (nbOfPlayers > 2) {
				System.out.println("Initialization was attempted for " + nbOfPlayers + " players; however, this is only"
									+ " expected for an extended version of the game.\nValue will be set to 2.");
				nbOfPlayers = 2;
			}
			else if (nbOfPlayers < 2) {
				System.out.println("Error: Cannot execute the game with less than 2 players! Will exit.");
				System.exit(0);
			}
		}
		else {
			System.out.println("Initialization is invalid. Value will be set to 2.");
			nbOfPlayers = 2;
		}
		
		// Prompt the user to input player's names
		String[] names = new String[nbOfPlayers];
		System.out.print("What is the first name of Player 1? ");
		names[0] = keyIn.next();
		System.out.print("What is the first name of Player 2? ");
		names[1] = keyIn.next();
		System.out.println("Player 1: " + names[0]);
		System.out.println("Player 2: " + names[1]);
		
		// Declares and initializes the game board
		int[][] board = new int[10][10];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++) {
				if (i == 0 && j == 0)
					board[i][j] = 37;
				if (i == 0 && j == 3)
					board[i][j] = 10;
				if (i == 0 && j == 8)
					board[i][j] = 22;
				if (i == 1 && j == 5)
					board[i][j] = -10;
				if (i == 2 && j == 0)
					board[i][j] = 21;
				if (i == 2 && j == 7)
					board[i][j] = 56;
				if (i == 3 && j == 5)
					board[i][j] = 8;
				if (i == 4 && j == 7)
					board[i][j] = -18;
				if (i == 5 && j == 0)
					board[i][j] = 16;
				if (i == 6 && j == 3)
					board[i][j] = -4;
				if (i == 7 && j == 0)
					board[i][j] = 20;
				if (i == 7 && j == 9)
					board[i][j] = 20;
				if (i == 9 && j == 2)
					board[i][j] = -25;
				if (i == 9 && j == 4)
					board[i][j] = -81;
				if (i == 9 && j == 6)
					board[i][j] = -21;
				if (i == 9 && j == 7)
					board[i][j] = -20;
		}
		
		// Creates a LadderAndSnake object and allows for a full game to be played
		LadderAndSnake game = new LadderAndSnake(nbOfPlayers, board, names);
		game.play();
		
		// Displays thank you message
		System.out.println("Thank you for playing Ladder And Snake!");
		keyIn.close();
	}
}
