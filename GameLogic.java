package object_oriented_programming; // Define the package name

import java.util.ArrayList; // Import the ArrayList class
import java.util.Scanner; // Import the Scanner class

public class GameLogic extends WordRandom { // Declare a class named GameLogic that extends WordRandom
	// Attributes
    public Scanner input; // Declare a public Scanner attribute

    // Constructor
    public GameLogic(ArrayListPazzly wordLists, Scanner input) {
        super(wordLists.getArrayListCoding(), wordLists.getArrayListFoods(), wordLists.getArrayListAnime(),
              wordLists.getArrayListGames(), wordLists.getArrayListGames(), ""); // Calls the superclass constructor
        this.input = input; // Initialize the Scanner attribute
    }
    
    // Method to play the game
    public void playGame(ArrayList<String> puzzleArrayList) {
        for (String puzzleWord : puzzleArrayList) { // Iterate through each word in the puzzleArrayList
            String scrambledWord = randomToWords(puzzleWord); // Generate a scrambled version of the word
            System.out.println("What is the correct word?"); // print
            System.out.println("\nThe Word: " + scrambledWord + "\nThe Answer is: "); // Print the scrambled word
            String answerThePerson = input.nextLine().toLowerCase(); // Get the users input
            int trySolveAgain = 3; // Set the number of attempts

            while (!answerThePerson.equalsIgnoreCase(puzzleWord) && trySolveAgain > 0) { // Check if the answer is correct
                System.out.println("Wrong!!!!!\nTry Again if you can. Survival attempts: " + trySolveAgain); // Print a message for wrong answers and the number attempts
                answerThePerson = input.nextLine(); // Get the users input again
                trySolveAgain--; // Decrement the number of attempts
                if (trySolveAgain == 0 && !answerThePerson.equalsIgnoreCase(puzzleWord)) { // Check if the attempts have expired
                    System.out.println("GAME OVER\nThe number of attempts has expired");
                    System.out.println("\nWrong!! The correct answer is: " + puzzleWord); // Print the correct answer
                    return; // Exit the loop
                }
            }

            if (answerThePerson.equalsIgnoreCase(puzzleWord)) { // Check if the answer is correct
                System.out.println("Correct!!!"); // Print a message for correct answers
            }
        }
    }
}
