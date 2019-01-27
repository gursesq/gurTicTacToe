package myWorld;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in);
		
		//properties
		TicTacToe game;
		AI jack;
		char playerToken, AIToken;
		boolean contin;
		
		//code
		
		System.out.println("Welcome to my first Tictactoe game!");
		System.out.println("In order to Start, you need to pick tokens for yourself and the AI. \n");
		
		System.out.println("Enter a single character as your token: ");
		playerToken = scan.next().charAt(0);
		System.out.println("Enter a single character as AI's token: ");
		AIToken = scan.next().charAt(0);
		
		game = new TicTacToe( playerToken, AIToken);
		jack = new AI();
		
		System.out.println("pick a number as shown below to make your move: \n");
		System.out.println("|1|2|3\n------\n|4|5|6\n------\n|7|8|9 \n");
		System.out.println("press a key to continue when you are ready to begin! \n");
		scan.next();
		
		contin = true;
		while ( contin ) {
			game.randStarter();
			while ( !game.isGameOver() ) {
								
				game.move( jack, scan);
				game.printBoard();
			}
			game.win();
			
			System.out.println("Your score is: " + game.getScore()[0] + " -- AI's score is: " + game.getScore()[1]);
			
			System.out.println("Do you wish to play another round? (y/n)");
			if ( scan.next().charAt(0) != 'y' ) {
				contin = false;
			}
			
			game.clear();
		}
		
		System.out.println("Thanks for playing! Our AI Jack might be al ittle dumb, but he is working on it. Stay tuned for updates.");
		
		scan.close();
	}
	

}
