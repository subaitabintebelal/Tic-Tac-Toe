import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacToe{
    int boardWidth = 700;
    int boardHeight = 750;
    JFrame f = new JFrame("Tic-Tac-Toe");
    JLabel tLabel = new JLabel();
    JPanel tPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JButton [][] board = new JButton[3][3];
    String player1 = "X";
    String player2 = "O";
    String current = player1;
    boolean gameover;
    int turns;

    TicTacToe(){
        f.setVisible(true);
        f.setSize(boardWidth, boardHeight);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        tLabel.setBackground(Color.PINK);
        tLabel.setForeground(Color.WHITE);
        tLabel.setFont(new Font("Arial",Font.BOLD, 50));
        tLabel.setHorizontalAlignment(JLabel.CENTER);
        tLabel.setText("Tic-Tac-Toe");
        tLabel.setOpaque(true);

        tPanel.setLayout(new BorderLayout());
        tPanel.add(tLabel);
        f.add(tPanel, BorderLayout.NORTH);
        bPanel.setLayout(new GridLayout(3,3));
        bPanel.setBackground(Color.PINK);
        f.add(bPanel);

        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                JButton tile = new JButton();
                board [row][column] = tile;
                bPanel.add(tile);
                tile.setBackground(Color.CYAN);
                tile.setForeground(Color.BLUE);
                tile.setFont(new Font("Arial",Font.BOLD, 120));
                tile.setFocusable(false);
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent fun){
                        if (gameover) return;
                        JButton tile = (JButton)fun.getSource();
                        if(tile.getText()==""){
                            tile.setText(current);
                            turns++;
                            checkWinner();                           
                            if(!gameover){
                            if(current == player1){
                                current = player2;
                            }
                            else{
                                current = player1;
                            }
                            tLabel.setText(current + "'s turn.");
                        }
                        }
                    }
                });

            }
        }
    }
    void checkWinner(){
        for (int row = 0; row < 3; row ++){
            if(board[row][0].getText() == "") continue;
            if(board[row][0].getText() == board[row][1].getText() && board[row][1].getText() == board[row][2].getText()){
                for (int i = 0; i < 3; i++){
                    setWinner(board[row][i]);
                }
                
                gameover = true;
                return;
            }
        }
        for (int column = 0; column < 3; column ++){
            if(board[0][column].getText() == "") continue;
            if(board[0][column].getText() == board[1][column].getText() && board[1][column].getText() == board[2][column].getText()){
                for (int i = 0; i < 3; i++){
                    setWinner(board[i][column]);
                }
                
                gameover = true;
                return;
            }
        }
        if(board[0][0].getText() != "" && board[0][0].getText() == board[1][1].getText() && board[1][1].getText() == board[2][2].getText() ){
            for (int i = 0; i < 3; i++){
                    setWinner(board[i][i]);
                }
                gameover = true;
                return;
            
        }

            if(board[0][2].getText() != "" && board[0][2].getText() == board[1][1].getText() && board[1][1].getText() == board[2][0].getText() ){
            for (int i = 0; i < 3; i++){
                    setWinner(board[i][2-i]);
                }
                gameover = true;
                return;
            
        }

        if(turns ==9){
            for(int i = 0; i<3;i++){
                for(int j =0; j<3; j++){
                    setTie(board[i][j]);
                }
            }
            gameover = true;
        }
        }
    
    void setWinner(JButton tile){
        tile.setForeground(Color.cyan);
        tile.setBackground(Color.blue);
        tLabel.setText(current + " is the winner!!!");
    }

    void setTie(JButton tile){
        tile.setForeground(Color.lightGray);
        tile.setBackground(Color.BLUE);
        tLabel.setText("It's a Tie!!!");
    }
}