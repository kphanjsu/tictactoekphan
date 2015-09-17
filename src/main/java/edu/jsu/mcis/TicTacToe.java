package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicTacToe extends JFrame{
   private char whoseTurn = 'X';
   private boolean gameOver = false;
 
   
   private Board[][] board = new Board[3][3];
 
  
   JLabel jlblStatus = new JLabel("X turn");
    
    
    public TicTacToe(){
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
               panel.add(board[i][j] = new Board());
            }
        }
        add(panel, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);
    }   
    
    public boolean boardIsFull(){
        boolean full = true;
    
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j].getMark() == ' '){
                   full = false;
                }           
           }          
        }
       return full;
    }   
    
    public boolean isWon(char mark)
   {
       
        for (int i = 0; i < 3; i++)
           if ((board[i][0].getMark() == mark) && (board[i][1].getMark() == mark) && (board[i][2].getMark() == mark)){                 
                return true;
           }
  
        for (int j = 0; j < 3; j++)
           if ((board[0][j].getMark() == mark) && (board[1][j].getMark() == mark) && (board[2][j].getMark() == mark)){         
                return true;
        }
       
        if ((board[0][0].getMark() == mark) && (board[1][1].getMark() == mark) && (board[2][2].getMark() == mark)){
            return true;
        }
 
        if ((board[0][2].getMark() == mark) && (board[1][1].getMark() == mark) && (board[2][0].getMark() == mark)){
            return true;
        }
 
       return false;
   }
 
    
    public class Board extends JPanel
    {
       
       private char mark = ' ';
 
      
       public Board()
       {
           setBorder(new LineBorder(Color.black, 1));
           addMouseListener(new MyMouseListener());
       }
 
       
       public char getMark()
       {
           return mark;
       }
 
       
       public void setMark(char c)
       {
           mark = c;
           repaint();
       }
 
       @Override
       protected void paintComponent(Graphics g)
       {
           super.paintComponent(g);
 
            if (mark == 'X')
            {
                g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
                g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
            }
 
            else if (mark == 'O')
            {
                g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
            }
       }
 
       private class MyMouseListener extends MouseAdapter
       {
           @Override
           public void mouseClicked(MouseEvent e)
           {
                if (gameOver)
                    return;
                             
                if (mark == ' ' && whoseTurn != ' ')
                    setMark(whoseTurn);
 
                if (isWon(whoseTurn))
                {
                    jlblStatus.setText("Congratulations! " + whoseTurn + " wins!");
                    whoseTurn = ' ';
                    gameOver = true;
                }
                else if (boardIsFull())
                {
                    jlblStatus.setText("It's a tie!");
                    whoseTurn = ' ';
                    gameOver = true;
                }
                else
                {
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    jlblStatus.setText(whoseTurn + "'s turn.");
                }
            }
        } 
    } 
 
    
    public static void main(String[] args) {
        JFrame game = new TicTacToe();
        game.setTitle("Welcome to the Tic Tac Toe game!");
        game.setSize(600, 600);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
