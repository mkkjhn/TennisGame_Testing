import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_scorePlayer1_15_Player2_love() {
		// Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		
		String score = game.getScore();		
		assertEquals("Score incorrect", "15 - love", score);		
	}
	
	@Test
	public void testTennisGame_scorePlayer1_30_Player2_15() {
		// Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		
		String score = game.getScore();		
		assertEquals("Score incorrect", "30 - 15", score);		
	}
	
	@Test
	public void testTennisGame_scorePlayer1_40_Player2_30() {
		// Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();		
		assertEquals("Score incorrect", "40 - 30", score);		
	}
	
	@Test
	public void testTennisGame_scorePlayer1_30_Player2_40() {
		// Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();		
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();		
		assertEquals("Score incorrect", "30 - 40", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test
	public void testTennisGame_Player1_has_advantage() {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored(); // 1-0
		game.player2Scored(); // 1-1
		game.player1Scored(); // 2-1
		game.player2Scored(); // 2-2
		game.player1Scored(); // 3-2
		game.player2Scored(); // 3-3 deuce		
		game.player1Scored(); // 4-3 advantage		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Advantage score incorrect", "player1 has advantage", score);		
	}
	
	@Test
	public void testTennisGame_Player2_has_advantage() {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored(); // 0-1
		game.player1Scored(); // 1-1
		game.player2Scored(); // 1-2
		game.player1Scored(); // 2-2
		game.player2Scored(); // 2-3
		game.player1Scored(); // 3-3 deuce		
		game.player2Scored(); // 3-4 advantage		

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Advantage score incorrect", "player2 has advantage", score);		
	}	
	
	@Test
	public void testTennisGame_Player2_advantage_then_Player1_have_advantage() {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored(); // 0-1
		game.player1Scored(); // 1-1
		game.player2Scored(); // 1-2
		game.player1Scored(); // 2-2
		game.player2Scored(); // 2-3
		game.player1Scored(); // 3-3 deuce		
		game.player2Scored(); // 3-4 advantage p2
		game.player1Scored(); // 4-4 deuce
		game.player1Scored(); // 5-4 advantage p1

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Advantage score incorrect", "player1 has advantage", score);		
	}
	
	@Test
	public void testTennisGame_Player1_advantage_then_Player2_have_advantage() {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored(); // 1-0
		game.player2Scored(); // 1-1
		game.player1Scored(); // 2-1
		game.player2Scored(); // 2-2
		game.player1Scored(); // 3-2
		game.player2Scored(); // 3-3 deuce		
		game.player1Scored(); // 4-3 advantage p1
		game.player2Scored(); // 4-4 deuce
		game.player2Scored(); // 4-5 advantage p2

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Advantage score incorrect", "player2 has advantage", score);		
	}
	
	@Test
	public void testTennisGame_Player1_wins() {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score incorrect", "player1 wins", score);		
	}
	
	@Test
	public void testTennisGame_Player1_wins_after_strech() {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored(); // 1-0
		game.player2Scored(); // 1-1
		game.player1Scored(); // 2-1
		game.player2Scored(); // 2-2
		game.player1Scored(); // 3-2
		game.player2Scored(); // 3-3 deuce		
		game.player1Scored(); // 4-3 advantage p1
		game.player2Scored(); // 4-4 deuce
		game.player2Scored(); // 4-5 advantage p2
		game.player1Scored(); // 5-5 deuce
		game.player1Scored(); // 6-5 advantage p1
		game.player1Scored(); // 7-5 player 1 wins
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score incorrect", "player1 wins", score);		
	}
	
	@Test
	public void testTennisGame_Player2_wins() {
		//Arrange
		TennisGame game = new TennisGame();		
	
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score incorrect", "player2 wins", score);		
	}
	
	@Test
	public void testTennisGame_Player2_wins_after_strech() {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored(); // 0-1
		game.player1Scored(); // 1-1
		game.player2Scored(); // 1-2
		game.player1Scored(); // 2-2
		game.player2Scored(); // 2-3
		game.player1Scored(); // 3-3 deuce		
		game.player2Scored(); // 3-4 advantage p2
		game.player1Scored(); // 4-4 deuce
		game.player1Scored(); // 5-4 advantage p1
		game.player2Scored(); // 5-5 deuce
		game.player2Scored(); // 5-6 advantage p2
		game.player2Scored(); // 5-7 player 2 wins
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score incorrect", "player2 wins", score);		
	}

	@Test 
	public void testTennisGame_Player1WinsPointAfterGameEnded() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored(); // 15
		game.player1Scored(); // 30
		game.player1Scored(); // 40
		game.player1Scored(); // wins
		
		//Act
		String score = game.getScore() ;
		// This statement should cause an exception
		game.player1Scored();
		assertEquals("Score incorrect", "player1 wins", score);		
		
	}
	
	@Test
	public void testTennisGame_Player2WinsPointAfterGameEnded() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored(); // 15
		game.player2Scored(); // 30
		game.player2Scored(); // 40
		game.player2Scored(); // wins
		
		//Act
		String score = game.getScore() ;
		// This statement should cause an exception
		game.player2Scored();
		assertEquals("Score incorrect", "player2 wins", score);	
	}
	/*		
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored(); // 15
		game.player1Scored(); // 30
		game.player1Scored(); // 40
		game.player1Scored(); // wins
		
		//Act		
		// This statement should cause an exception
		game.player1Scored();
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored(); // 15
		game.player2Scored(); // 30
		game.player2Scored(); // 40
		game.player2Scored(); // wins
		
		//Act		
		// This statement should cause an exception
		game.player2Scored();
	}
	*/
}
