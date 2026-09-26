package object_oriented_programming; // Define the package name

import java.util.ArrayList; // Import the ArrayList class
import java.util.Random; // Import the Random class

public class WordRandom extends ArrayListPazzly { // Declare a class named WordRandom that extends ArrayListPazzly
	// Attributes
	private String worldArrays; // Declare a private String attribute

	// Constructor
	public WordRandom(ArrayList<String> arrayListCoding, ArrayList<String> arrayListFoods,
			ArrayList<String> arrayListAnime, ArrayList<String> arrayListGame, ArrayList<String> arrayListGames,
			String worldArrays) {
		super(arrayListCoding, arrayListFoods, arrayListAnime, arrayListGame, arrayListGames); // Calls the superclass constructor
		this.worldArrays = worldArrays; // Initialize the worldArrays attribute
	}

	// Getter & Setter methods for worldArrays
	public String getWorldArrays() {
		return worldArrays; // Return the worldArrays attribute
	}

	public void setWorldArrays(String worldArrays) {
		this.worldArrays = worldArrays; // Set the worldArrays attribute
	}

	// Method to randomize the letters in a word
	String randomToWords(String worldArrays) {
		Random random = new Random(); // Creates a Random object
		char[] letterWord = worldArrays.toCharArray(); // Converts the string to a char array
		int word = letterWord.length; // Gets the length of the char array
		for (int i = 0; i < word; i++) { // Loops through the char array
			int randomLetter; // Declares a variable for the random index
			char resultRandom; // Declares a variable for the character to be swapped
			randomLetter = random.nextInt(word); // Gets a random index
			resultRandom = letterWord[i]; // Stores the current character
			letterWord[i] = letterWord[randomLetter]; // Swaps the characters
			letterWord[randomLetter] = resultRandom; // Places the stored character at the random index
		}
		// Converts the char array back to a string
		String newWord = new String(letterWord); 
		return newWord; // Returns the new randomized word
	}

	// Method to shuffle the elements in an ArrayList
	void randomToWords(ArrayList<String> list) {
		int numberSizeArray = list.size(); // Gets the size of the ArrayList
		for (int i = 0; i < numberSizeArray - 1; i++) { // Outer loop
			for (int h = 0; h < numberSizeArray - 1 - i; h++) { // Inner loop
				String listPast = list.get(h); // Gets the current element
				String listNext = list.get(h + 1); // Gets the next element
				list.set(h, listNext); // Swaps the elements
				list.set(h + 1, listPast); // Places the current element in the next position
			}
		}
	}
}
