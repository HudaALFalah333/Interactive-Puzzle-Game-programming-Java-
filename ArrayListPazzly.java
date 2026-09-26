package object_oriented_programming; // Define the package name

import java.util.ArrayList; // Import the ArrayList class from the java.util package

public class ArrayListPazzly { // Declare a public class named ArrayListPazzly
	// Attributes
	private ArrayList<String> arrayListCoding = new ArrayList<String>(); // Create a private ArrayList for coding
	private ArrayList<String> arrayListFoods = new ArrayList<String>(); // Create a private ArrayList for foods
	private ArrayList<String> arrayListAnime = new ArrayList<String>(); // Create a private ArrayList for anime
	private ArrayList<String> arrayListGames = new ArrayList<String>(); // Create a private ArrayList for games

	// Constructors
	public ArrayListPazzly(ArrayList<String> arrayListCoding, ArrayList<String> arrayListFoods,
			ArrayList<String> arrayListAnime, ArrayList<String> arrayListGame, ArrayList<String> arrayListGames) {
		// Initialize the attribute with the provided ArrayLists
		this.arrayListCoding = arrayListCoding;
		this.arrayListFoods = arrayListFoods;
		this.arrayListAnime = arrayListAnime;
		this.arrayListGames = arrayListGames;
	}

	// Getter & Setter methods for each ArrayList
	public ArrayList<String> getArrayListCoding() {
		return arrayListCoding; // Return the coding ArrayList
	}

	public void setArrayListCoding(ArrayList<String> arrayListCoding) {
		this.arrayListCoding = arrayListCoding; // Set the coding ArrayList
	}

	public ArrayList<String> getArrayListFoods() {
		return arrayListFoods; // Return the foods ArrayList
	}

	public void setArrayListFoods(ArrayList<String> arrayListFoods) {
		this.arrayListFoods = arrayListFoods; // Set the foods ArrayList
	}

	public ArrayList<String> getArrayListAnime() {
		return arrayListAnime; // Return the anime ArrayList
	}

	public void setArrayListAnime(ArrayList<String> arrayListAnime) {
		this.arrayListAnime = arrayListAnime; // Set the anime ArrayList
	}

	public ArrayList<String> getArrayListGames() {
		return arrayListGames; // Return the games ArrayList
	}

	public void setArrayListGames(ArrayList<String> arrayListGames) {
		this.arrayListGames = arrayListGames; // Set the games ArrayList
	}

	// Method to add words to the foods ArrayList
	void wordArrayFoods(ArrayList<String> arrayListFoods) {
		arrayListFoods.add("Pizza");
		arrayListFoods.add("Pasta");
		arrayListFoods.add("Mansaf");
		arrayListFoods.add("Curry");
		arrayListFoods.add("Noodles");
	}

	// Method to add words to the anime ArrayList
	void wordArrayAnime(ArrayList<String> arrayListAnime) {
		arrayListAnime.add("One Piece");
		arrayListAnime.add("Tokyo Ghoul");
		arrayListAnime.add("Attack On Titan");
		arrayListAnime.add("Bleach");
		arrayListAnime.add("Kuroshitsuji");
	}

	// Method to add words to the coding ArrayList
	void wordArrayCoding(ArrayList<String> arrayListCoding) {
		arrayListCoding.add("Debuging");
		arrayListCoding.add("Algortham");
		arrayListCoding.add("Array");
		arrayListCoding.add("For-Each");
		arrayListCoding.add("Java");
		arrayListCoding.add("Overloding");
		arrayListCoding.add("Override");
		arrayListCoding.add("Modifiers");
	}

	// Method to add words to the games ArrayList
	void wordArrayGame(ArrayList<String> arrayListGames) {
		arrayListGames.add("Call Of Duty");
		arrayListGames.add("Tekhen");
		arrayListGames.add("Resident Evil");
		arrayListGames.add("Assassins");
		arrayListGames.add("Uncharted");
	}

	// Override method to display an important message
	void important() {
		System.out.println(" IMPORTANT !!! ");
	}
}
