package event_driven; // Declare the package name

import javax.swing.*; // Import necessary Swing classes
import java.awt.*; // Import necessary AWT classes
import java.awt.event.*; // Import necessary event handling classes
import java.util.ArrayList; // Import the ArrayList class
import java.util.Random; // Import the Random class

public class Main { // Declare a public class named Main

	// Declare class level variables
	private static JFrame frame;
	private static CardLayout cardLayout;
	private static JPanel mainPanel;
	private static JComboBox<String> categoryComboBox;
	private static JTextArea questionTextArea;
	private static JTextField answerTextField;
	private static JLabel attemptsLabel;
	private static ArrayList<String> puzzleList = new ArrayList<>();
	private static int trySolveAgain = 3;
	private static String currentWord, scrambledWord;

	public static void main(String[] args) { // Declare the main method
		frame = new JFrame("Puzzle Game"); // Create a JFrame with title Puzzle Game
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the default close operation
		frame.setSize(500, 400); // Set the size of the frame

		cardLayout = new CardLayout(); // Create a CardLayout
		mainPanel = new JPanel(cardLayout); // Create a JPanel with CardLayout

		startPanel(); // Call the startPanel method
		playGamePanel(); // Call the playGamePanel method
		questionPanel(); // Call the questionPanel method

		frame.add(mainPanel); // Add the mainPanel to the frame
		frame.setVisible(true); // Set the frame visible
	}

	// Method to create the start panel
	private static void startPanel() {
		JPanel welcomePanel = new JPanel(); // Create a JPanel for the welcome screen
		welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS)); // Set the layout of the panel
		welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Set the border of the panel
		
		// Creates a JLabel for the welcome message
		JLabel welcomeLabel = new JLabel("Welcome To The Game Puzzle.", SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Set the font of the label
		welcomePanel.add(welcomeLabel); // Add the label to the panel
		
		// Create a JLabel for the start message
		JLabel startLabel = new JLabel("Do you want to Start the game?", SwingConstants.CENTER); 
		startLabel.setFont(new Font("Serif", Font.PLAIN, 18)); // Set the font of the label
		welcomePanel.add(startLabel); // Add the label to the panel

		JPanel buttonPanel = new JPanel(); // Create a JPanel for the buttons
		buttonPanel.setLayout(new FlowLayout()); // Set the layout of the panel

		JButton yesButton = new JButton("Yes"); // Create a button with label "Yes"
		yesButton.setFont(new Font("Serif", Font.PLAIN, 18)); // Set the font of the button
		JButton noButton = new JButton("No"); // Create a button with label "No"
		noButton.setFont(new Font("Serif", Font.PLAIN, 18)); // Set the font of the button

		buttonPanel.add(yesButton); // Add the yes button to the panel
		buttonPanel.add(noButton); // Add the no button to the panel
		welcomePanel.add(buttonPanel); // Add the button panel to the welcome panel

		// Action listener for the yes button
		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "gamePanel"); // Show the game panel
			}
		});

		// Action listener for the no button
		noButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Close the frame
			}
		});

		// Mouse listener for the yes button
		yesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				yesButton.setBackground(Color.GREEN); // Change background color on mouse enter
			}

			@Override
			public void mouseExited(MouseEvent e) {
				yesButton.setBackground(UIManager.getColor("Button.background")); // Restore background color on mouse exit
			}
		});

		// Mouse listener for the no button
		noButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				noButton.setBackground(Color.RED); // Change background color on mouse enter
			}

			@Override
			public void mouseExited(MouseEvent e) {
				noButton.setBackground(UIManager.getColor("Button.background")); // Restore background color on mouse exit																			
			}
		});

		mainPanel.add(welcomePanel, "welcomePanel"); // Add the welcome panel to the main panel
	}

	// Method to create the play game panel
	private static void playGamePanel() {
		JPanel gamePanel = new JPanel(); // Create a JPanel for the game options
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS)); // Set the layout of the panel
		gamePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Set the border of the panel

		JLabel chooseLabel = new JLabel("Choose a category to play:", SwingConstants.CENTER); // Create a JLabel for
																								// category selection
		chooseLabel.setFont(new Font("Serif", Font.PLAIN, 18)); // Set the font of the label
		gamePanel.add(chooseLabel); // Add the label to the panel

		String[] categories = { "Foods (Easy)", "Anime (Hard)", "Coding (Middle)", "Games (Very Hard)" }; // Array of category options
		categoryComboBox = new JComboBox<>(categories); // Creates a JComboBox with category options
		categoryComboBox.setFont(new Font("Serif", Font.PLAIN, 18)); // Sets the font of the combo box
		gamePanel.add(categoryComboBox); // Adds the combo box to the panel

		JButton startGameButton = new JButton("Start Game"); // Creates a button to start the game
		startGameButton.setFont(new Font("Serif", Font.PLAIN, 18)); // Sets the font of the button
		startGameButton.addActionListener(new ActionListener() { // Adds action listener to the button
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame(); // Calls the startGame method
			}
		});
		gamePanel.add(startGameButton); // Add the button to the panel

		mainPanel.add(gamePanel, "gamePanel"); // Add the game panel to the main panel
	}

	// Method to create the question panel
	private static void questionPanel() {
		JPanel questionPanel = new JPanel(); // Create a JPanel for displaying questions
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS)); // Set the layout of the panel
		questionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Set the border of the panel
		questionTextArea = new JTextArea(); // Create a JTextArea for displaying questions
		questionTextArea.setLineWrap(true); // Enables line wrapping
		questionTextArea.setWrapStyleWord(true); // Enables word wrapping
		questionTextArea.setEditable(false);// Disable editing of the questionTextArea to make it read only
		questionTextArea.setFont(new Font("Serif", Font.PLAIN, 18)); // Set the font of the text area
		questionTextArea.setBackground(new Color(240, 240, 240)); // Set the background color
		questionPanel.add(new JScrollPane(questionTextArea)); // Add the text area to the panel with a scroll pane

		answerTextField = new JTextField(); // Create a JTextField for entering answers
		answerTextField.setFont(new Font("Serif", Font.PLAIN, 18)); // Set the font of the text field
		questionPanel.add(answerTextField); // Add the text field to the panel

		JButton submitButton = new JButton("Submit Answer"); // Create a button to submit answers
		submitButton.setFont(new Font("Serif", Font.PLAIN, 18)); // Set the font of the button
		submitButton.addActionListener(new ActionListener() { // Add action listener to the button
			@Override
			public void actionPerformed(ActionEvent e) {
				checkAnswer(); // Call the checkAnswer method
			}
		});
		questionPanel.add(submitButton); // Add the button to the panel

		attemptsLabel = new JLabel("Attempts left: 3", SwingConstants.CENTER); // Create a label for attempts left
		attemptsLabel.setFont(new Font("Serif", Font.PLAIN, 18)); // Set the font of the label
		questionPanel.add(attemptsLabel); // Add the label to the panel

		answerTextField.addKeyListener(new KeyAdapter() { // Add key listener to the text field
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkAnswer(); // Call the checkAnswer method when Enter is pressed
				}
			}
		});

		submitButton.addMouseMotionListener(new MouseMotionAdapter() { // Add mouse motion listener to the button
			@Override
			public void mouseMoved(MouseEvent e) {
				submitButton.setToolTipText("Click to submit your answer"); // Set a tool tip text
			}
		});

		mainPanel.add(questionPanel, "questionPanel"); // Add the question panel to the main panel
	}

    // Method to start the game
	private static void startGame() {
		String selectedCategory = (String) categoryComboBox.getSelectedItem(); // Get the selected category
		puzzleList.clear(); // Clear the puzzle list

		if (selectedCategory != null) {
			switch (selectedCategory) { // Switch statement based on the selected category
			case "Foods (Easy)":
				puzzleArrayFoods(puzzleList); // Fill the puzzle list with food related words
				break;
			case "Anime (Hard)":
				puzzleArrayAnime(puzzleList); // Fill the puzzle list with anime related words
				break;
			case "Coding (Middle)":
				puzzleArrayCoding(puzzleList); // Fill the puzzle list with coding related words
				break;
			case "Games (Very Hard)":
				puzzleArrayGames(puzzleList); // Fill the puzzle list with game related words
				break;
			}

			algorithm_bubble_sort(puzzleList); //call algorithm_bubble_sort, to sort the puzzle list
			trySolveAgainQuestion(); // Start the first question
		}
	}

    // Method to handle trying to solve the question again
	private static void trySolveAgainQuestion() {
		if (puzzleList.isEmpty()) { // Check if all puzzles are completed
			JOptionPane.showMessageDialog(frame, "You've completed all puzzles! Well done!"); // Shows a message
			cardLayout.show(mainPanel, "gamePanel"); // Show the game panel again
			return;
		}

		currentWord = puzzleList.remove(0); // Remove the first word from the puzzle list
		scrambledWord = randomToWords(currentWord); // Scramble the word

		questionTextArea.setText(
				"What is the correct word?\n\nIMPORTANT!!!!\nWhen there is more than one capital letter, it means that the word consists of more than one part.\n\nThe Word: "
						+ scrambledWord); // Set the question text
		answerTextField.setText(""); // Clear the answer text field
		trySolveAgain = 3; // Reset the number of attempts
		attemptsLabel.setText("Attempts left: " + trySolveAgain); // Update the attempts label
		cardLayout.show(mainPanel, "questionPanel"); // Show the question panel
	}

    // Method to check the answer
	private static void checkAnswer() {
		String answer = answerTextField.getText().trim(); // Get the entered answer and removes leading/trailing spaces
		if (answer.equalsIgnoreCase(currentWord)) { // Checks if the answer is correct
			JOptionPane.showMessageDialog(frame, "Correct!!!"); // Shows a message
			trySolveAgainQuestion(); // Start the next question
		} else {
			trySolveAgain--; // Decrement the number of attempts
			if (trySolveAgain > 0) { // Checks if attempts are remaining
				attemptsLabel.setText("Attempts left: " + trySolveAgain); // Updates the attempts label
				JOptionPane.showMessageDialog(frame,
						"Wrong!!!!!\nTry Again if you can. Survival attempts: " + trySolveAgain); // Show a message
			} else {
				JOptionPane.showMessageDialog(frame, "GAME OVER\nThe correct answer is: " + currentWord); // Shows a message
																											
				cardLayout.show(mainPanel, "gamePanel"); // Show the game panel
			}
		}
	}

    // Method to populate the puzzle list with food related words
	static void puzzleArrayFoods(ArrayList<String> arrayListFoods) {
       // Add food related words to the list
		arrayListFoods.add("Pizza");
		arrayListFoods.add("Pasta");
		arrayListFoods.add("Mansaf");
		arrayListFoods.add("Curry");
		arrayListFoods.add("Noodles");
	}

    // Method to populate the puzzle list with anime related words
	static void puzzleArrayAnime(ArrayList<String> arrayListAnime) {
        // Add anime related words to the list
		arrayListAnime.add("One Piece");
		arrayListAnime.add("Tokyo Ghoul");
		arrayListAnime.add("Attack On Titan");
		arrayListAnime.add("Bleach");
		arrayListAnime.add("Kuroshitsuji");
	}

    // Method to populate the puzzle list with coding related words
	static void puzzleArrayCoding(ArrayList<String> arrayListCoding) {
         // Add coding related words to the list
		arrayListCoding.add("Debugging");
		arrayListCoding.add("Algorithm");
		arrayListCoding.add("Array");
		arrayListCoding.add("For-Each");
		arrayListCoding.add("Java");
		arrayListCoding.add("Overloading");
		arrayListCoding.add("Override");
		arrayListCoding.add("Modifiers");
	}

    // Method to populate the puzzle list with game related words
	static void puzzleArrayGames(ArrayList<String> arrayListGames) {
        // Adds game-related words to the list
		arrayListGames.add("Call Of Duty");
		arrayListGames.add("Tekken");
		arrayListGames.add("Resident Evil");
		arrayListGames.add("Assassins");
		arrayListGames.add("Uncharted");
	}

     // Method to scramble a word
	static String randomToWords(String worldArrays) {
		Random random = new Random(); // Create a Random object
		char[] letterWord = worldArrays.toCharArray(); // Converts the word to a char array
		int word = letterWord.length; // Get the length of the word
		for (int i = 0; i < word; i++) { // Iterate through the char array
			int randomLetter; // Declare a variable for the random letter index
			char resultRandom; // Declare a variable for the randomly chosen character
			randomLetter = random.nextInt(word); // Get a random
			randomLetter = random.nextInt(word); // Get a random index within the length of the word
			resultRandom = letterWord[i]; // Store the current character
			letterWord[i] = letterWord[randomLetter]; // Swap the current character with the character at the random index
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
