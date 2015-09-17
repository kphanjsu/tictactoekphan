package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	@Test
	public void testInitialBoardIsEmpty() {
		TicTacToe game = new TicTacToe();
		for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        assertEquals('-',game.getMark(i, j));
                    }
                }    
		assertTrue(false);
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		assertEquals('X', game.getMark(0,2));
		
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		asswertEquals('O', game.getMark(0,0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		assertTrue(false);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark(boolean gameOver) {
		TicTacToe game = new TicTacToe();
		gameOver = false;
		
		assertTrue(false);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToe game = new TicTacToe();
		for (int i = 0; i < 3; i++){
			if ((board[i][0].getMark() == mark) && (board[i][1].getMark() == mark) && (board[i][2].getMark() == mark){
                assertEquals('X', game.isWon('X');               
		}
		assertTrue(false);
		//t.put('x', 0, 0);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToe game = new TicTacToe();
		for (int i = 0; i < 3; i++){
			for (int j = 0 ; j < 3; j++){
				if (board([i][j] = ' '){
					assertTrue(false);
				}
			}
		}
		
	}	
}
