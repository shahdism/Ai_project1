package twoplayer;




import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

public class hard extends JFrame implements ActionListener {
    private static final int BOARD_SIZE = 3;
    private static final String X = "X";
    private static final String O = "O";
    private static final String EMPTY = "";
    Color g = new Color(151, 74, 176);
  //  Color c = new Color(255,255,255 );

    private String currentPlayer;
    private JButton[][] boardButtons;
 private javax.swing.JButton jButton1;

    private final javax.swing.JButton jButton4;
    private final javax.swing.JButton jButton5;
   
    private javax.swing.JPanel jPanel1;
    private  javax.swing.JPanel jPanel3;
    public hard() {
       setSize(700,400);
      setLocationRelativeTo(null);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardButtons = new JButton[BOARD_SIZE][BOARD_SIZE];
    
          jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
      
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new java.awt.GridLayout(3, 3));
    
         currentPlayer = X;
       for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                boardButtons[row][col] = new JButton();
                boardButtons[row][col].setPreferredSize(new Dimension(100, 100));
                boardButtons[row][col].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                 boardButtons[row][col].setBackground(g);

                boardButtons[row][col].addActionListener(this);
                jPanel3.add(boardButtons[row][col]);
            }
        
        }
     
      

        jButton4.setText("Back");
        jButton4.setBackground(g);
          jButton4.addActionListener(this::jButton4ActionPerformed);
        jButton4.setFont(new Font("Arial", Font.BOLD, 20));
        

        jButton5.setText("Reset");
        jButton5.setBackground(g);

        jButton5.setFont(new Font("Arial", Font.BOLD, 20));

jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }

            private void jButton5ActionPerformed(ActionEvent evt) {
             // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
             for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
               boardButtons[row][col].setText("");
               
            }
        }
            }
          
        });
           javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 40, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
     
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (!clickedButton.getText().equals(EMPTY)) {
            return;
        }
        clickedButton.setText(currentPlayer);
        if (checkForWinner().equals(currentPlayer)) {
            endGame(currentPlayer + " wins!");
        } else if (checkForWinner().equals("Tie")) {
            endGame("Tie game");
        } else {
            currentPlayer = (currentPlayer.equals(X)) ? O : X;
          //  statusLabel.setText(currentPlayer + "'s turn");
            if (currentPlayer.equals(O)) {
                Point computerMove = getComputerMove();
                boardButtons[computerMove.x][computerMove.y].setText(O);
                if (checkForWinner().equals(O)) {
                    endGame("Computer wins!");
                } else if (checkForWinner().equals("Tie")) {
                    endGame("Tie game");
                } else {
                    currentPlayer = X;
                   // statusLabel.setText(currentPlayer + "'s turn");
                }
            }
        }
    }
    private String checkForWinner() {
        // Check rows
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (!boardButtons[row][0].getText().equals(EMPTY) &&
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
    
    // Check for tie
    for (int row = 0; row < BOARD_SIZE; row++) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (boardButtons[row][col].getText().equals(EMPTY)) {
                return "";
            }
        }
    }
    return "Tie";
}

private void endGame(String message) {
    JOptionPane.showMessageDialog(this, message);
   
   // new oneplayer().setVisible(true);
}

private Point getComputerMove() {
    int maxScore = Integer.MIN_VALUE;
    Point bestMove = null;
    for (int row = 0; row < BOARD_SIZE; row++) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (boardButtons[row][col].getText().equals(EMPTY)) {
                boardButtons[row][col].setText(O);
                int score = alphaBetaPruning(false, 9, Integer.MIN_VALUE, Integer.MAX_VALUE);
                boardButtons[row][col].setText(EMPTY);
                if (score > maxScore) {
                    maxScore = score;
                    bestMove = new Point(row, col);
                }
            }
        }
    }
    return bestMove;
}

private int alphaBetaPruning(boolean isMaximizing, int depth, int alpha, int beta) {
    String result = checkForWinner();
    int r=0;
    if (!result.equals("")) {
        if (result.equals(X)) {
            r=-1;
            return r;
        } else if (result.equals(O)) {
            return 1;
        } else {
            return 0;
        }
    }
    
    if (isMaximizing) {
        int maxScore = Integer.MIN_VALUE;
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (boardButtons[row][col].getText().equals(EMPTY)) {
                    boardButtons[row][col].setText(O);
                    int score = alphaBetaPruning(false, depth - 1, alpha, beta);
                    boardButtons[row][col].setText(EMPTY);
                    maxScore = Math.max(maxScore, score);
                    alpha = Math.max(alpha, score);
                    if (beta <= alpha) {
                        return maxScore;
                    }
                }
            }
        }
        return maxScore;
    } else {
        int minScore = Integer.MAX_VALUE;
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (boardButtons[row][col].getText().equals(EMPTY)) {
                    boardButtons[row][col].setText(X);
                    int score = alphaBetaPruning(true, depth - 1, alpha, beta);
                    boardButtons[row][col].setText(EMPTY);
                    minScore     = Math.min(minScore, score);
                    beta = Math.min(beta, score);
                    if (beta <= alpha) {
                        return minScore;
                    }
                }
            }
        }
        return minScore;
    }
}
  private void jButton4ActionPerformed(ActionEvent evt) {
        dispose();
               new oneplayermenu().setVisible(true);
            }

public static void main(String[] args) {
    new hard().setVisible(true);
}
}