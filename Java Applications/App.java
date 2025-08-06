// Import necessary Java Swing and AWT libraries for GUI components
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class App {

    // Global variables to keep track of scores and round number
    public static int playerScore = 0;
    public static int computerScore = 0;
    public static int round = 1;

    public static void main(String[] args) {
        // List of valid choices
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Rock");
        choices.add("Paper");
        choices.add("Scissors");

        // Wrapper class to hold mutable game state values
        class GameState {
            String textInput = "";         // Player's current input
            String computerChoice = "";    // Computer's current choice
        }
        GameState gameState = new GameState();  // Create instance of game state

        // === Create Main Application Window ===
        JFrame frame = new JFrame("Rock Paper Scissors Game");
        frame.setSize(800, 500);  // Set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close

        // === Create Main Panel with Vertical Layout ===
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Vertical alignment
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // === Image Panel ===
        JPanel imagePanel = new JPanel(); // Panel to hold the game image
        try {
            // Load and scale the image
            ImageIcon icon = new ImageIcon("istockphoto-1127066576-612x612.jpg"); // Replace with your own image path
            Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image)); // Add image to label
            imagePanel.add(imageLabel); // Add label to panel
        } catch (Exception e) {
            // Fallback if image is not found or can't be loaded
            JLabel fallback = new JLabel("Image could not be loaded.");
            imagePanel.add(fallback);
        }

        // === Player Input Panel ===
        JPanel playerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField textField = new JTextField(20); // Input field for player's choice
        JButton playerButton = new JButton("Player's Choice"); // Button to confirm input
        JLabel playerLabel = new JLabel("You haven't chosen yet."); // Displays player's current choice
        playerPanel.add(new JLabel("Player:"));
        playerPanel.add(textField);
        playerPanel.add(playerButton);

        // === Computer Choice Panel ===
        JPanel computerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton computerButton = new JButton("Computer's Choice"); // Button to generate computer choice
        JLabel computerLabel = new JLabel("Computer hasn't chosen yet."); // Displays computer choice
        computerPanel.add(computerButton);

        // === Result Panel ===
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton resultButton = new JButton("Check Result"); // Button to check winner
        JLabel resultLabel = new JLabel("Result will be shown here."); // Displays game result
        resultPanel.add(resultButton);

        // === Score Panel ===
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel scoreLabel = new JLabel("Player: 0 | Computer: 0 | Round: 1"); // Displays score and round
        scorePanel.add(scoreLabel);

        // === Label Panel (to display choices) ===
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1)); // 2 rows, 1 column
        labelPanel.add(playerLabel);
        labelPanel.add(computerLabel);

        // === Add all panels to main panel ===
        mainPanel.add(imagePanel);
        mainPanel.add(playerPanel);
        mainPanel.add(labelPanel);
        mainPanel.add(computerPanel);
        mainPanel.add(resultPanel);
        mainPanel.add(scorePanel);

        // === Event Listener: Player's Button Click ===
        playerButton.addActionListener(e -> {
            gameState.textInput = textField.getText().trim(); // Get and trim input
            if (choices.contains(gameState.textInput)) {
                playerLabel.setText("You chose: " + gameState.textInput); // Show choice
            } else {
                playerLabel.setText("Invalid choice! Choose Rock, Paper, or Scissors.");
            }
        });

        // === Event Listener: Computer's Button Click ===
        computerButton.addActionListener(e -> {
            int randomIndex = generateRandomNumber(choices.size()); // Random index 0-2
            gameState.computerChoice = choices.get(randomIndex); // Select computer choice
            computerLabel.setText("Computer chose: " + gameState.computerChoice); // Display it
        });

        // === Event Listener: Result Button Click ===
        resultButton.addActionListener(e -> {
            // Check that both player and computer made a choice
            if (gameState.textInput.isEmpty() || gameState.computerChoice.isEmpty()) {
                resultLabel.setText("Choose both Player and Computer options first.");
            } else {
                String playerChoice = gameState.textInput;
                String computerChoice = gameState.computerChoice;

                String resultText;

                // Determine game result
                if (playerChoice.equals(computerChoice)) {
                    resultText = "It's a tie!";
                } else if (
                    (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                    (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                    (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))
                ) {
                    playerScore++;
                    resultText = "You win!";
                } else {
                    computerScore++;
                    resultText = "Computer wins!";
                }

                // Update result and score display
                resultLabel.setText(resultText);
                scoreLabel.setText("Player: " + playerScore + " | Computer: " + computerScore + " | Round: " + round);
                round++;
            }
        });

        // === Final GUI Setup ===
        frame.setContentPane(mainPanel); // Add main panel to frame
        frame.setVisible(true); // Display frame
    }

    // === Utility Function: Generate Random Number in Range [0, max) ===
    public static int generateRandomNumber(int max) {
        return (int) (Math.random() * max); // Random number between 0 and max - 1
    }
}
