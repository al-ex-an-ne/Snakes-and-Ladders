import java.util.Scanner;

/**
 * 
 * This class generates a game of Ladder And Snake 
 * 
 * @author Alexanne Marcil
 */
public class LadderAndSnake {
	private int [][] board = new int[10][10];
	private int nbOfPlayers;
	private String [] playerNames;
	private int [] playerPositions;
	
	/**
	 * Creates an empty Ladder And Snake game.
	 */
	public LadderAndSnake() {
	}
	
	/**
	 * Creates a Ladder And Snake game using parameters.
	 * An array with the same length as the amount of players is created to hold
	 * their positions when playing.
	 * @param nbOfPlayers  number of people playing the game
	 * @param board  2D array containing positions of ladders and snakes 
	 * @param playerNames  array containing the name of all players
	 */
	public LadderAndSnake (int nbOfPlayers, int[][] board, String[] playerNames) {
		this.nbOfPlayers = nbOfPlayers;
		this.nbOfPlayers = nbOfPlayers;
		this.playerNames = playerNames.clone();
		this.board = board.clone();
		this.playerPositions = new int[nbOfPlayers];
	}
	
	/**
	 * Creates a Ladder And Snake game from another game
	 * @param otherLadderAndSnake  Ladder And Snake game to be copied 
	 */
	public LadderAndSnake (LadderAndSnake otherLadderAndSnake) {
		this.board = otherLadderAndSnake.board;
		this.nbOfPlayers = otherLadderAndSnake.nbOfPlayers;
		this.playerNames = (String[])otherLadderAndSnake.playerNames.clone();
		this.playerPositions = (int[])otherLadderAndSnake.playerPositions.clone();
	}
	
	/**
	 * Sets the number of people playing the game
	 * @param nbOfPlayers  number of people playing the game
	 */
	public void setNbOfPlayers (int nbOfPlayers) {
		this.nbOfPlayers = nbOfPlayers;
	}
	
	/**
	 * Sets the board with ladders and snakes
	 * @param board  2D array containing positions of ladders and snakes 
	 */
	public void setBoard (int[][] board) {
		for (int i = 0; i < board.length; i++)
			this.board[i] = board[i].clone();
	}
	
	/**
	 * Sets the names of the current players
	 * @param playerNames  array containing all players' names
	 */
	public void setPlayerNames (String[] playerNames) {
		this.playerNames = (String[])playerNames.clone();
	}
	
	/**
	 * Sets the positions on the board of current players
	 * @param playerPositions  containing all players' positions 
	 */
	public void setPlayerPositions (int[] playerPositions) {
		this.playerPositions = (int[])playerPositions.clone();
	}
	
	/**
	 * Gets the amount of people playing the game
	 * @return current number of players (nbOfPlayers)
	 */
	public int getNbOfPlayers () {
		return nbOfPlayers;
	}
	
	/**
	 * Gets a 2D array containing positions of ladders and snakes 
	 * @return ladders and snakes positions (board)
	 */
	public int[][] getBoard(){
		int[][] copy = new int[board.length][board[1].length];
		for (int i = 0; i < this.board.length; i++)
			copy[i] = this.board[i].clone();
		return copy;
	}
	
	/**
	 * Gets an array containing names for all players
	 * @return all players' names (playerNames)
	 */
	public String[] getPlayerNames() {
		return (String[])this.playerNames.clone();
	}
	
	/**
	 * Gets an array containing positions of all players
	 * @return all players' positions (playerNames)
	 */
	public int[] getPlayerPostitions() {
		return (int[])this.playerPositions.clone();
	}
	
	/**
	 * Creates a display of the board with current player positions
	 * This method uses {@link #horizontalLines}
	 * @return string containing the current complete board
	 */
	public String toString() {
		String board = "";
		board += LadderAndSnake.horizontalLines();
		for (int i = 0; i < this.board.length; i++) {
			// for the row containing square 100
			if (i == 0) {
				board += "  |100|";
				for (int j = 0; j < this.board.length-1 ; j++) {
					if (this.playerPositions == null)
						board += "   |";
					else if (this.playerPositions[0]/10==9 && this.playerPositions[0]%10 == 9-j) 
						board += " 1 |";
					else if (this.playerPositions[1]/10==9 && this.playerPositions[1]%10 == 9-j)
						board += " 2 |";
					else
						board += "   |";
				}
				board += "<-\n";
			}
			// for the starting row
			else if (i == 9) {
				board += LadderAndSnake.horizontalLines();
				board += " 0|";
				for (int j = 0; j < this.board.length; j++)
					if (this.playerPositions == null)
						board += "   |";
					else if (this.playerPositions[0]/10==0 && this.playerPositions[0]%10 == j+1 || this.playerPositions[0] == 10 && j == 9) 
						board += " 1 |";
					else if (this.playerPositions[1]/10==0 && this.playerPositions[1]%10 == j+1 || this.playerPositions[1] == 10 && j == 9)
						board += " 2 |";
					else
						board += "   |";
				board += "\n";
			}
			// for rows going left
			else if (i%2 == 0) {
				board += LadderAndSnake.horizontalLines();
				board += "  |";
				for (int j = 0; j < this.board.length; j++)
					if (this.playerPositions == null)
						board += "   |";
					else if (this.playerPositions[0]/10==9-i && this.playerPositions[0]%10 == 10-j || this.playerPositions[0]/10==10-i && this.playerPositions[0]%10==0  && j == 0) 
						board += " 1 |";
					else if (this.playerPositions[1]/10==9-i && this.playerPositions[1]%10 == 10-j || this.playerPositions[1]/10==10-i && this.playerPositions[1]%10==0 && j == 0)
						board += " 2 |";
					else
						board += "   |";
				board += "<-\n";
			}
			// for rows going right
			else if (i%2 == 1) {
				board += LadderAndSnake.horizontalLines();
				board += "->|";
				for (int j = 0; j < this.board.length; j++)
					if (this.playerPositions == null)
						board += "   |";
					else if (this.playerPositions[0]/10==9-i && this.playerPositions[0]%10 == j+1 || this.playerPositions[0]/10==10-i && this.playerPositions[0]%10==0  && j == 9) 
						board += " 1 |";
					else if (this.playerPositions[1]/10==9-i && this.playerPositions[1]%10 == j+1 || this.playerPositions[1]/10==10-i && this.playerPositions[1]%10==0 && j == 9)
						board += " 2 |";
					else
						board += "   |";
				board += "\n";
			}
		}
		board += LadderAndSnake.horizontalLines();
		return board;
	}
	
	/**
	 * Allows the user to play a full game of Ladder And Snake with exactly 2 players
	 * This method uses {@link #diceFlip}, {@link #completeTurn}, and {@link #toString}
	 */
	public void play() {
		int[] playerDice = new int[nbOfPlayers];
		int counter = 1;
		
		System.out.println("\nGame will be played by only 2 players.");
		System.out.println("Now deciding which player will start playing;");
		this.diceFlip(playerDice, 0, counter);
		this.diceFlip(playerDice, 1, counter);
		// in case the players tie when deciding order of play
		while (playerDice[0] == playerDice[1]) {
			System.out.println("A tie was achieved between " + this.playerNames[0] + " and " + this.playerNames[1]
								+ ". Attempting to break the tie.");
			this.diceFlip(playerDice, 0, counter);
			this.diceFlip(playerDice, 1, counter);
			counter++;
		}
		System.out.println("Reached final decision on order of playing: "
							+((playerDice[0] > playerDice[1])? this.playerNames[0] + " then " + this.playerNames[1]:this.playerNames[1]
							+ " then " + this.playerNames[0])+ ". It took " + counter + (counter==1? " attempt": " attempts") + " before a decision could be made.\n");
		counter = 0;
		
		int player1FirstRoll = playerDice[0];
		int player2FirstRoll = playerDice[1];
		int turns = 0;
		// players take turn rolling the dice until one of them is in square 100
		while(this.playerPositions[0] != 100 && this.playerPositions[1] != 100){
			if (turns != 0)
				System.out.println("Game not over; flipping again");
			turns++;
			this.completeTurn(playerDice, player1FirstRoll, player2FirstRoll, counter);
			System.out.println(this.toString());
		}
		// determines which player has won
		for (int i = 0; i < playerPositions.length; i++)
			if (playerPositions[i] == 100)
				System.out.println(playerNames[i] + " has won the game!");
	}

	/**
	 * Flips the dice and displays the outcome for a certain player
	 * This method uses {@link #flipDice}
	 * @param array  containing players' last dice roll
	 * @param i  index pointing to a certain player 
	 * @param counter  indicates if the order of play has been determined
	 */
	public void diceFlip(int[] array, int i, int counter) {
		Scanner keyIn = new Scanner(System.in);
		System.out.print(playerNames[i] + ": Press ENTER to flip dice.");
		// when deciding order of play
		if (counter > 0) {
			if (keyIn.hasNextLine()) {
				array[i] = flipDice();
				System.out.println(this.playerNames[i] + " got a dice value of " + array[i]);
			}
		}
		// when playing the game
		else
			if (keyIn.hasNextLine()) {
				array[i] = flipDice();
				System.out.print(this.playerNames[i] + " got a dice value of " + array[i]);
			}
	}
	
	/**
	 * Plays a turn for a certain player, displaying the player's new position
	 * This method uses {@link #diceFlip}
	 * @param array  containing players' last dice roll 
	 * @param i  index pointing to certain player
	 * @param counter  indicates if the order of play has been determined 
	 */
	public void halfTurn(int[] array, int i, int counter) {
		diceFlip(array, i, counter);
		this.playerPositions[i] += array[i];
		// if player position is not multiple of 10 (i.e. if position was 10, index would be 1) and under 100
		if(this.playerPositions[i]%10 != 0 && this.playerPositions[i] < 100) {
			// check if there is a snake or a ladder at player`s position
			if (this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1] > 0 )
				System.out.println("; gone to square " + playerPositions[i] + " then up to square " 
									+ (this.playerPositions[i]+this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1]));
			else if (this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1] < 0)
				System.out.println("; gone to square " + this.playerPositions[i] + " then down to square " 
						+ (this.playerPositions[i]+this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1]));
			else
				System.out.println("; now in square " + this.playerPositions[i]);
			
			this.playerPositions[i] += this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1];
		}
		else if (this.playerPositions[i]%10 == 0 && this.playerPositions[i] != 100) {
			
			if (this.board[this.playerPositions[i]/10 - 1][9] > 0)
				System.out.println("; gone to square " + this.playerPositions[i] + " then up to square " 
									+ (this.playerPositions[i]+this.board[this.playerPositions[i]/10-1][9]));
			else if (this.board[this.playerPositions[i]/10-1][9] < 0)
				System.out.println("; gone to square " + this.playerPositions[i] + " then down to square " 
						+ (this.playerPositions[i]+this.board[this.playerPositions[i]/10-1][9]));
			else
				System.out.println("; now in square " + this.playerPositions[i]);
			
			this.playerPositions[i] += this.board[this.playerPositions[i]/10-1][9];
		}
		else if (this.playerPositions[i] > 100) {
			this.playerPositions[i] = 100 - (this.playerPositions[i] - 100); 
			// check if there is a snake or a ladder at player`s position
			if (this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1] > 0)
				System.out.println("; gone to square " + playerPositions[i] + " then up to square " 
									+ (this.playerPositions[i]+this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1]));
			else if (this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1] < 0)
				System.out.println("; gone to square " + this.playerPositions[i] + " then down to square " 
						+ (this.playerPositions[i]+this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1]));
			else
				System.out.println("; now in square " + this.playerPositions[i]);
			
			this.playerPositions[i] += this.board[this.playerPositions[i]/10][this.playerPositions[i]%10-1];
		}
		else if (this.playerPositions[i] == 100) 
			System.out.println("; now in square 100");
		
		// checks if the player landed in an occupied square
		if (this.playerPositions[0] == this.playerPositions[1]) {
			this.playerPositions[i] = 0;
			if (i==0)
				System.out.println("Sorry, " + this.playerNames[1] + " is already in that cell; " + this.playerNames[i]
									+ " is back to square 0");
			else if (i==1)
				System.out.println("Sorry, " + this.playerNames[0] + " is already in that cell; " + this.playerNames[i]
									+ " is back to square 0");
		}

	}
	
	/**
	 * Plays a turn for each player and checks if one of them has reached square 100
	 * This method uses {@link #halfTurn}
	 * @param array  containing players' last dice roll
	 * @param player1FirstRoll  first player's dice roll determining order
	 * @param player2FirstRoll  second player's dice roll determining order
	 * @param counter  indicates if the order of play has been determined 
	 */
	public void completeTurn(int[] array, int player1FirstRoll, int player2FirstRoll, int counter) {
		if (player1FirstRoll > player2FirstRoll ) {
			for (int i = 0; i < array.length; i++) {
				this.halfTurn(array, i, counter);
				if (playerPositions[i] == 100) {
					return;
				}
			}
		}
		else {
			for (int i = array.length-1; i > -1; i--) {
				this.halfTurn(array, i, counter);
				if (playerPositions[i] == 100) {
					return;
				}
			}
		}
	}
	
	/**
	 * Gets a random value between 1 and 6, like with a dice
	 * @return a number between 1 and 6
	 */
	public static int flipDice() {
		return (int)(Math.random() * 6 + 1);
	}
	
	/**
	 * Creates an horizontal line the width of the game board
	 * @return an horizontal line to delimit each row 
	 */
	public static String horizontalLines() {
		String line = "  ";
		for (int i = 0; i < 10; i++)
			line += "+" + "---";
		line += "+\n";
		return line;
	}
	
}
