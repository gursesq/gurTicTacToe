package myWorld;

import java.util.ArrayList;

public class AI {
	public int pick( char[] board) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for ( int i = 0; i < 9; i++ ) {
			if ( board[i] == '-' ) {
				list.add(i);
			}
		}
		
		return list.get( (int) (Math.random() * list.size()) );
	}
}
