package object_oriented_programming; // Define the package name

import java.util.ArrayList; // Import the ArrayList class

public class ChooseStyleTheGame extends WordRandom { // Declare a class named ChooseStyleTheGame that extends WordRandom (inhertans)
	private String styleTheGame; // Declare a private String attribute
	private GameLogic gameLogic; // Declare a private GameLogic attribute

	// Constructor
	public ChooseStyleTheGame(ArrayList<String> arrayListCoding, ArrayList<String> arrayListFoods,
			ArrayList<String> arrayListAnime, ArrayList<String> arrayListGame, ArrayList<String> arrayListGames,
			String worldArrays, String styleTheGame, GameLogic gameLogic) {
		super(arrayListCoding, arrayListFoods, arrayListAnime, arrayListGame, arrayListGames, worldArrays); // Calls the superclass constructor
																																																				
		this.styleTheGame = styleTheGame; // Initialize the styleTheGame attribute
		this.gameLogic = gameLogic; // Initialize the gameLogic attribute
	}

	// Getter & Setter methods for styleTheGame
	public String getStyleTheGame() {
		return styleTheGame; // Return the styleTheGame attribute
	}

	public void setStyleTheGame(String styleTheGame) {
		this.styleTheGame = styleTheGame; // Set the styleTheGame attribute
	}

	// Getter & Setter methods for gameLogic
	public GameLogic getGameLogic() {
		return gameLogic; // Return the gameLogic attribute
	}

	public void setGameLogic(GameLogic gameLogic) {
		this.gameLogic = gameLogic; // Set the gameLogic attribute
	}

	// Method to choose the game style based on user input
	public void chooseUser() {
		ArrayList<String> puzzleArrayList; // Declares a variable to hold the chosen puzzle list

		switch (styleTheGame.toLowerCase()) { // Switche on the uses game choice
		case "1":
		case "foods":
		case "food":
			puzzleArrayList = getArrayListFoods(); // Assign the foods ArrayList
			break;
		case "2":
		case "anime":
			puzzleArrayList = getArrayListAnime(); // Assign the anime ArrayList
			break;
		case "3":
		case "coding":
			puzzleArrayList = getArrayListCoding(); // Assign the coding ArrayList
			break;
		case "4":
		case "games":
			puzzleArrayList = getArrayListGames(); // Assign the games ArrayList
			break;
		default:
			System.out.println("Try again"); // Print a message if the choice is invalid
			return;
		}

		randomToWords(puzzleArrayList); // Shuffle the puzzleArrayList
		getGameLogic().playGame(puzzleArrayList); // Call the playGame method from GameLogic class
	}
	// Override method to display an important message
	@Override
	void important() {
		System.out.println(" IMPORTANT !!!"); // Prints an important message
		System.out.println(
				"When there is more than one capital letter, \n it means that the word consists of more than one part."); // Print additional  information
	}
}
