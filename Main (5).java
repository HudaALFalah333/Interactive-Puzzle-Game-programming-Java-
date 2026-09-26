package object_oriented_programming; // Defines the package name

import java.util.Scanner; // Import the Scanner class
import java.util.ArrayList; // Import the ArrayList class

public class Main { // Declare a public class named Main
    public static void main(String[] args) { // Declare the main method
        Scanner input = new Scanner(System.in); // Create a Scanner object for user input

        System.out.println("Welcome To The Game Puzzle.\n");
        System.out.println("\t .Do you want to Start the game?");
        System.out.println("\t .Yes or No?");
        
        String userInput = input.nextLine().toLowerCase(); // Gets user input
        
        // Create an instance of ArrayListPazzly to hold word lists
        ArrayListPazzly wordLists = new ArrayListPazzly(new ArrayList<>(), new ArrayList<>(),
        		new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        
        // Adds words to the word lists
        wordLists.wordArrayFoods(wordLists.getArrayListFoods()); // Get Foods word
        wordLists.wordArrayAnime(wordLists.getArrayListAnime()); // Get Anime word
        wordLists.wordArrayCoding(wordLists.getArrayListCoding()); // Get Coding word
        wordLists.wordArrayGame(wordLists.getArrayListGames()); // Get Games word
        wordLists.important(); // Calls the important method
        
        while (userInput.equals("yes")) { // Loop to continue the game
            System.out.println("What do you want to choose to play the game?");
            System.out.println("1. Foods. (Easy)");
            System.out.println("2. Anime. (Hard)");
            System.out.println("3. Coding. (Middle)");
            System.out.println("4. Games. (Very Hard)");
            System.out.println("Choose 1, 2, 3, or 4 .......\n Or write the game name");

            String userChoice = input.nextLine().toLowerCase(); // Get the users choice
            String word = input.nextLine(); // Get the users input
            
            GameLogic gameLogic = new GameLogic(wordLists, input); // Create a GameLogic object
            ChooseStyleTheGame game = new ChooseStyleTheGame(wordLists.getArrayListCoding(), wordLists.getArrayListFoods(),wordLists.getArrayListAnime(),
            wordLists.getArrayListGames(), wordLists.getArrayListGames(),word, userChoice, gameLogic); // Create a ChooseStyleTheGame object
             
            game.important(); // Call the important method
            game.chooseUser(); // Call the chooseUser method

            System.out.println("Do you want to play again? (Yes/No)"); // Ask if the user wants to play again
            userInput = input.nextLine().toLowerCase(); // Get user input
        }

        System.out.println("Thank you for choosing. Goodbye."); // Print a goodbye message
    }
}
