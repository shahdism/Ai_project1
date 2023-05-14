package twoplayer;


import java.awt.*;
import static java.awt.Color.*;
import static java.awt.Color.red;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicTacToeGUI extends JFrame implements ActionListener {
            Color g = new Color(177, 24, 201);

    private static final int BOARD_SIZE = 3;
    private static final String X = "X";
    private static final String O = "O";
    private static final String EMPTY = "";
    
    private JButton[][] boardButtons;
    private String currentPlayer;
    private JLabel messageLabel;
    
    public TicTacToeGUI() {
        boardButtons = new JButton[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = X;
        Color g = new Color(200,100,255);
        Color c = new Color(255,255,255);

        // Create and initialize the board buttons
        JPanel boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                boardButtons[row][col] = new JButton(EMPTY);
                boardButtons[row][col].setFont(new Font("Arial", Font.BOLD, 48));
                boardButtons[row][col].setPreferredSize(new Dimension(80, 80));
                boardButtons[row][col].addActionListener(this);
                boardButtons[row][col].setBackground(g);
                  boardButtons[row][col].setBorderPainted(false);
                boardButtons[row][col].setBorder(new LineBorder(Color.BLACK));
;
;

                boardPanel.add(boardButtons[row][col]);
                 boardPanel.setBackground(c);
            }
        }
      
        
        // Create and initialize the message label
        messageLabel = new JLabel("It's " + currentPlayer + "'s turn.", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 24));
          //messageLabel.setSize(90, 90);
        // Add the board and message label to the content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(boardPanel, BorderLayout.CENTER);
        getContentPane().add(messageLabel, BorderLayout.SOUTH);
         
        
        // Set the window properties
        setTitle("Tic Tac Toe");
       // setColor(red);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
       // setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        int row = -1, col = -1;
        
        // Find the button's position on the board
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (button == boardButtons[i][j]) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        
        // Update the board with the current player's move
        if (isValidMove(row, col)) {
            boardButtons[row][col].setText(currentPlayer);
            boardButtons[row][col].setEnabled(false);
            if (checkWinner() != EMPTY) {
                messageLabel.setText(currentPlayer + " wins!");
                disableBoard();
            } else if (isBoardFull()) {
                messageLabel.setText("Draw!");
                disableBoard();
            } else {
                switchPlayer();
                messageLabel.setText("It's " + currentPlayer + "'s turn.");
            }
        }
    }
   
    
    private boolean isValidMove(int row, int col) {
        return boardButtons[row][col].getText().equals(EMPTY);
    }
    
    private boolean isBoardFull() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (boardButtons[row][col].getText().equals(EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private String checkWinner() {
        // Check rows
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (!boardButtons[row][    0].getText().equals(EMPTY) &&
                boardButtons[row][0].getText().equals(boardButtons[row][1].getText()) &&
                boardButtons[row][1].getText().equals(boardButtons[row][2].getText())) {
            return boardButtons[row][0].getText();
        }
    }
    
    // Check columns
    for (int col = 0; col < BOARD_SIZE; col++) {
        if (!boardButtons[0][col].getText().equals(EMPTY) &&
                boardButtons[0][col].getText().equals(boardButtons[1][col].getText()) &&
                boardButtons[1][col].getText().equals(boardButtons[2][col].getText())) {
            return boardButtons[0][col].getText();
        }
    }
    
    // Check diagonals
    if (!boardButtons[0][0].getText().equals(EMPTY) &&
            boardButtons[0][0].getText().equals(boardButtons[1][1].getText()) &&
            boardButtons[1][1].getText().equals(boardButtons[2][2].getText())) {
        return boardButtons[0][0].getText();
    }
    if (!boardButtons[0][2].getText().equals(EMPTY) &&
            boardButtons[0][2].getText().equals(boardButtons[1][1].getText()) &&
            boardButtons[1][1].getText().equals(boardButtons[2][0].getText())) {
        return boardButtons[0][2].getText();
    }
    
    return EMPTY;
}

private void switchPlayer() {
    if (currentPlayer == X) {
        currentPlayer = O;
    } else {
        currentPlayer = X;
    }
}

private void disableBoard() {
    for (int row = 0; row < BOARD_SIZE; row++) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            boardButtons[row][col].setEnabled(false);
        }
    }
}

public static void main(String[] args) {
    TicTacToeGUI game = new TicTacToeGUI();
    game.setVisible(true);
}

    private void setColor(Color red) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}