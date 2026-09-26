
package procedural; // Declares the package name as procedural

import java.util.ArrayList; // Import the ArrayList class from java.util package
import java.util.Scanner; // Import the Scanner class from java.util package
import java.util.Random; // Import the Random class from java.util package

public class Main { // Declares the Main class

	public static void main(String[] args) { // Main method the entry point of the program
		System.out.println("Welcome To The Game Puzzle .\n "); // Print welcome message
		System.out.println("\t .Do you want to Start the game ?"); // Asks user if they want to start the game
		System.out.println("\t .Yes or No ?"); // Asks for user input

		Scanner input = new Scanner(System.in); // Creates a Scanner object to read user input
		String userInput = input.nextLine(); // Reads the next line of input from the user

		while (userInput.toLowerCase().equals("yes")) { // Loops while the user input is yes
			System.out.println("What do you want to choose to play the game?");
			System.out.println("1. Foods. (Easy)");
			System.out.println("2. Anime.(Hard)");
			System.out.println("3. Coding.(Middle)");
			System.out.println("4. Games.(Very Hard)");
			System.out.println("Choose 1, 2, 3 or 4 .......\n Or write the game name");

			String userChoice = input.nextLine().toLowerCase(); // Reads the user's choice and converts it to lowercase

			ArrayList<String> arrayListFoods = new ArrayList<String>(); // Create an ArrayList for Foods
			ArrayList<String> arrayListAnime = new ArrayList<String>(); // Create an ArrayList for Anime
			ArrayList<String> arrayListCoding = new ArrayList<String>(); // Create an ArrayList for Coding
			ArrayList<String> arrayListGames = new ArrayList<String>(); // Create an ArrayList for Games
			chooseStyleTheGame(userChoice, arrayListFoods, arrayListAnime, arrayListCoding, arrayListGames);
			// Call chooseStyleTheGame method with user choice and ArrayList

			System.out.println("Do you want to play again? (Yes/No)"); // Asks the user if they want to play again
			userInput = input.nextLine().toLowerCase(); // Read the next line of input and convert it to lowercase
		}
		System.out.println("Thank you for choosing. Goodbye."); // Print goodbye message
	}

	static void chooseStyleTheGame(String styleTheGame, ArrayList<String> arrayListFoods,
			ArrayList<String> arrayListAnime, ArrayList<String> arrayListCoding, ArrayList<String> arrayListGames) {
		ArrayList<String> puzzleArrayList; // Declare a variable to hold the chosen puzzle list
		Scanner input = new Scanner(System.in); // Create a Scanner object to read user input

		switch (styleTheGame.toLowerCase()) { // Switche on the users game choice
		// Foods
		case "1":
		case "foods":
		case "food":
			puzzleArrayList = arrayListFoods; // Assigns arrayListFoods to puzzleArrayList
			puzzleArrayFoods(arrayListFoods); // Call puzzleArrayFoods to populate the list
			break;
		// Anime
		case "2":
		case "anime":
			puzzleArrayList = arrayListAnime; // Assigns arrayListAnime to puzzleArrayList
			puzzleArrayAnime(arrayListAnime); // Call puzzleArrayAnime to populate the list
			break;
		// Coding
		case "3":
		case "coding":
			puzzleArrayList = arrayListCoding; // Assigns arrayListCoding to puzzleArrayList
			puzzleArrayCoding(arrayListCoding); // Call puzzleArrayCoding to populate the list
			break;
		// Games
		case "4":
		case "games":
			puzzleArrayList = arrayListGames; // Assigns arrayListGames to puzzleArrayList
			puzzleArrayGames(arrayListGames); // Call puzzleArrayGames to populate the list
			break;
		default:
			System.out.println("Try again"); // Prints message if the input is invalid
			return; // Exits the method
		}

		algorithm_bubble_sort(puzzleArrayList); // Call the bubble sort algorithm to sort the puzzle list

		for (int i = 0; i < puzzleArrayList.size(); i++) { // Iterates through the puzzle list
			String puzzleWord = puzzleArrayList.get(i); // Gets the current puzzle word
			String scrambledWord = randomToWords(puzzleWord); // Scrambles the puzzle word
			System.out.println("What is the correct word?"); // Asks the user for the correct word
			System.out.println("\nIMPORTANT!!!!");
			System.out.println(	"When there is more than one capital letter, it means that the word consists of more than one part.");
			System.out.println("\nThe Word: " + scrambledWord + "\nThe Answer is : ");
			String answerThePerson = input.nextLine().toLowerCase(); // Read the users answer and converts it to lowercase
			int trySolveAgain = 3; // Set the number of attempts to 3
			while (!answerThePerson.equalsIgnoreCase(puzzleWord) && trySolveAgain > 0) {
				// Loop while the answer is incorrect and attemptsare left
				System.out.println("Wrong!!!!!\nTry Again if you can . Survival attempts: " + trySolveAgain); 
				// Print a wrong answer message and the attempte																				
				answerThePerson = input.nextLine(); // Reads the next line of input
				trySolveAgain--; // decrements the number of attempts
				if (trySolveAgain == 0) { // If no attempts are left
					System.out.println("GAME OVER\nThe number of attempts has expired"); // Print game over message
					if (!answerThePerson.equalsIgnoreCase(puzzleWord)) { // If the final answer is still wrong
						System.out.println("\nWrong!!, The correct answer is: " + puzzleWord); // Prints the correct answer
						return; // Exits the method
					}
				}
			}

			if (answerThePerson.equalsIgnoreCase(puzzleWord)) { // If the answer is correct
				System.out.println("Correct!!!"); // Print correct answer message
			}
		}
	}

	static void puzzleArrayFoods(ArrayList<String> arrayListFoods) {
		// Foods
		arrayListFoods.add("Pizza"); // Add Pizza to arrayListFoods
		arrayListFoods.add("Pasta"); // Add Pasta to arrayListFoods
		arrayListFoods.add("Mansaf"); // Add Mansaf to arrayListFoods
		arrayListFoods.add("Curry"); // Add Curry to arrayListFoods
		arrayListFoods.add("Noodles"); // Add Noodles  to arrayListFoods
	}

	static void puzzleArrayAnime(ArrayList<String> arrayListAnime) {
		// Anime
		arrayListAnime.add("One Piece"); // Add One Piece to arrayListAnime
		arrayListAnime.add("Tokyo Ghoul"); // Add Tokyo Ghoul to arrayListAnime
		arrayListAnime.add("Attack On Titan"); // Add Attack On Titan to arrayListAnime
		arrayListAnime.add("Bleach"); // Add Bleach to arrayListAnime
		arrayListAnime.add("Kuroshitsuji"); // Add Kuroshitsuji to arrayListAnime
	}

	static void puzzleArrayCoding(ArrayList<String> arrayListCoding) {
		// Coding
		arrayListCoding.add("Debuging"); // Adds "Debuging" to arrayListCoding
		arrayListCoding.add("Algortham"); // Adds "Algortham" to arrayListCoding
		arrayListCoding.add("Array"); // Adds "Array" to arrayListCoding
		arrayListCoding.add("For-Each"); // Adds "For-Each" to arrayListCoding
		arrayListCoding.add("Java"); // Adds "Java" to arrayListCoding
		arrayListCoding.add("Overloding"); // Adds "Overloding" to arrayListCoding
		arrayListCoding.add("Override"); // Adds "Override" to arrayListCoding
		arrayListCoding.add("Modifiers"); // Adds "Modifiers" to arrayListCoding
	}

	static void puzzleArrayGames(ArrayList<String> arrayListGames) {
		// Games
		arrayListGames.add("Call Of Duty"); // Add Call Of Duty to arrayListGames
		arrayListGames.add("Tekken"); // Add Tekken to arrayListGames
		arrayListGames.add("Resident Evil"); // Add Resident Evil to arrayListGames
		arrayListGames.add("Assassins"); // Add Assassins to arrayListGames
		arrayListGames.add("Uncharted"); // Add Uncharted to arrayListGames
	}

	static String randomToWords(String worldArrays) {
		Random random = new Random(); // Creates a Random object
		char[] letterWord = worldArrays.toCharArray(); // Converts the word to a char array
		int word = letterWord.length; // Gets the length of the word
		for (int i = 0; i < word; i++) { // Iterates through the char array
			int randomLetter; // Declares a variable for the random letter index
			char resultRandom; // Declares a variable for the randomly chosen character
			randomLetter = random.nextInt(word); // Gets a random
			randomLetter = random.nextInt(word); // Gets a random index within the length of the word
			resultRandom = letterWord[i]; // Stores the current character
			letterWord[i] = letterWord[randomLetter]; // Swaps the current character with the character at the random
														// index
			letterWord[randomLetter] = resultRandom; // Places the stored character at the random index
		}
		// Converts from char[] to String
		String newWord = new String(letterWord); // Creates a new String from the scrambled char array
		return newWord; // Returns the scrambled word
	}

	/*This algorithm is made on the principle of descending 
	order of array size*/
	static void algorithm_bubble_sort(ArrayList<String> list) {
		// Get the size of the list
		int numberSizeArray = list.size();
		// Outer loop for number of passes
		for (int i = 0; i < numberSizeArray - 1; i++) {
			// Inner loop for each comparison in a pass
			for (int h = 0; h < numberSizeArray - 1 - i; h++) {
				// Get the current element
				String listPast = list.get(h);
				// Get the next element
				String listNext = list.get(h + 1);
				// Swap the elements
				list.set(h, listNext);
				list.set(h + 1, listPast);
			}
		}
	}
}
