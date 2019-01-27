package myWorld;

import java.util.Scanner;

public class TicTacToe {
	
	//properties
	private char playerToken, AIToken;
	private char[] board;
	private char winner;
	private int[] score;
	private char starter;
	
	//constructors
	
	public TicTacToe( char playerToken, char AIToken) {
		this.playerToken = playerToken;
		this.AIToken = AIToken;
		board = new char[9];
		for ( int i = 0; i < 9; i++ ) {
			board[i] = '-';
		}
		score = new int[2];
		score[0] = score[1] = 0;
	}
	
	//methods
	
	public void printBoard() {
		for ( int i = 0; i < 9; i++ ) {
			System.out.print("|"+board[i]);
			if ( i % 3 == 2 ) {
				System.out.println();
				System.out.println("-------");
			}
		}
		System.out.println();
	}
	
	public boolean isGameOver() {
		return isThereWinner() || isFull();
	}
	
	public void move( AI jack, Scanner scan) {
		if ( starter == AIToken ) {
			board[jack.pick(board)] = AIToken;
			starter = playerToken;
			
			System.out.println("AI plays: \n");
		}
		else {
			int mv;
			System.out.print("Make your move: ");
			mv = scan.nextInt();
			System.out.println();
			while( !isValid(mv)) {
				System.out.print("Your move was invalid, please try again: ");
				mv = scan.nextInt();
				System.out.println();
			}
			board[mv-1] = playerToken;
			starter = AIToken;
		}
	}
	
	public boolean isValid( int mv) {
		if ( mv < 1 || mv > 9 ) {
			return false;
		}
		if ( board[mv-1] != '-' ) {
			return false;
		}
		return true;
	}
	
	public boolean isFull() {
		for ( int i = 0; i < 9; i++ ) {
			if ( board[i] == '-' )
				return false;
		}
		return true;
	}
	
	public boolean isThereWinner() {
		if ( middles() || diagonals() ) {
			winner = board[4];
			return true;
		}
		if ( upLeft() ) {
			winner = board[0];
			return true;
		}
		if ( downRight() ) {
			winner = board[8];
			return true;
		}
		return false;
	}
	
	public boolean middles() {
		if ( board[4] == '-' )
			return false;
		return ( board[1] == board[4] && board[4] == board[7] ) || ( board[3] == board[4] && board[4] == board[5] );
	}
	
	public boolean diagonals() {
		if ( board[4] == '-' )
			return false;
		return ( board[0] == board[4] && board[4] == board[8] ) || ( board[2] == board[4] && board[4] == board[6] );
	}
	
	public boolean upLeft() {
		if ( board[0] == '-' )
			return false;
		return ( board[0] == board[1] && board[1] == board[2] ) || ( board[0] == board[3] && board[3] == board[6] );
	}
	
	public boolean downRight() {
		if ( board[8] == '-' )
			return false;
		return ( board[6] == board[7] && board[7] == board[8] ) || ( board[2] == board[5] && board[5] == board[8] );
	}
	
	public int[] getScore() {
		return score;
	}
	
	public char[] getBoard() {
		return board;
	}
	
	public void win() {
		if ( winner == playerToken ) {
			System.out.println("You won this round!");
			score[0]++;
		}
		else if ( winner == AIToken ){
			System.out.println("You lost :(");
			score[1]++;
		}
		else {
			
		}
		winner = ' ';
	}
	
	public void randStarter() {
		if ( Math.random() < 0.5f ) {
			starter = playerToken;
			System.out.println("You Start First!");
		}
		else {
			starter = AIToken;
			System.out.println("AI Starts First!");
		}
	}
	
	public void clear() {
		for ( int i = 0; i < 9; i++ ) {
			board[i] = '-';
		}
	}
}






















