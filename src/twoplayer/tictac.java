package twoplayer;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.*;
import static java.awt.Color.*;
import static java.awt.Color.red;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class tictac extends JFrame implements ActionListener {
  
    Color g = new Color(247, 9, 150);
  private JLabel messageLabel;
    private static final int BOARD_SIZE = 3;
    private static final String X = "X";
    private static final String O = "O";
    private static final String EMPTY = "";
       private javax.swing.JLabel jLabel1;
    private JButton[][] boardButtons;
    private String currentPlayer="X";
  
     private javax.swing.JButton jButton1;

    private final javax.swing.JButton jButton4;
    private final javax.swing.JButton jButton5;
   
    private javax.swing.JPanel jPanel1;
    private  javax.swing.JPanel jPanel3;

    
  
    
    public tictac() {
       setSize(400,300);
      setLocationRelativeTo(null);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardButtons = new JButton[BOARD_SIZE][BOARD_SIZE];
        jLabel1 = new javax.swing.JLabel();
          jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
      
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new java.awt.GridLayout(3, 3));
    jButton4.setBackground(g);
          jButton4.addActionListener(this::jButton4ActionPerformed);
        jButton4.setFont(new Font("Arial", Font.BOLD, 20));
          jButton4.setText("Back");


        jButton5.setText("Reset");
        jButton5.setBackground(g);

        jButton5.setFont(new Font("Arial", Font.BOLD, 20));

    
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
    
      jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }

            private void jButton5ActionPerformed(ActionEvent evt) {
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
           jLabel1.setText("dawdwadawdasdsa");
     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 40, Short.MAX_VALUE))
                        .addComponent(jLabel1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>          

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

        
        
        
        
      @Override
  public void actionPerformed(ActionEvent e) {
           JButton button = (JButton) e.getSource();
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
        JFrame f= new JFrame();
        // Update the board with the current player's move
        if (isValidMove(row, col)) {
            boardButtons[row][col].setText(currentPlayer);
            boardButtons[row][col].setEnabled(true);
            if (checkWinner() != EMPTY) {
               JOptionPane.showMessageDialog( f,currentPlayer+" wins!");
             
               // disableBoard();
            } else if (isBoardFull()) {
               JOptionPane.showMessageDialog( f," Draw");
              // disableBoard();
            } else {
                switchPlayer();
                //messageLabel.setText("It's " + currentPlayer + "'s turn.");
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
    
    
    private void switchPlayer() {
    if (currentPlayer == X) {
        currentPlayer = O;
    } else {
        currentPlayer = X;
    }
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
  
    
    
    list m=new list();

    private void jButton4ActionPerformed(ActionEvent e) {
       dispose();
       m.setVisible(true);
    
    
    }
    public static void main(String[] args) {
   tictac game = new tictac();
}


}
