//Issei 
//1612406
//Output the position of queens that don't attack each other from input file
//NQueens.java

import java.io.*;
import java.util.Scanner;

public class NQueens{
	public static void main(String[] args)throws IOException{

	    // check number of command line arguments is at least 2
	    if(args.length < 2){
	        System.out.println("Usage: java –jar NQueens.jar <input file> <output file>");
	      	System.exit(1);
    	}

		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));

		while(in.hasNextLine()){
			String line = in.nextLine().trim() + " ";
			String[] tokens = line.split("\\s+");
			int size = Integer.parseInt(tokens[0]);
			int ini_col = Integer.parseInt(tokens[1]) - 1;
			int ini_row = Integer.parseInt(tokens[2]) - 1;

			int[][] board = new int[size][size];
			for(int i = 0; i < size; i++) for(int j = 0; j < size; j++) board[i][j] = 0; //fill with 0
			board[ini_row][ini_col] = 1;

			//showBoard(board);
			
			int ans = queenRecursion(board, size, 0, 0);

			showBoard(board);
			if(ans == 1){
				for(int col = 1; col <= size; col++){
					for(int row = 1; row <= size; row++){
						if(board[row-1][col-1] >= 1) out.print(col + " " + row + " ");
						//System.out.print(board[row-1][col-1]);
					}
				}
				out.println("");
			}else if(ans == 0){
				out.println("No solution");
			}else{
				out.println("Error");
			}


		}

		in.close();
		out.close();
	}

	// return 1 when any answer is found
	public static int queenRecursion(int[][] board, int n, int row, int col){
		int ans = 0;
		//Last row
		if(row == n-1){
			if(isAlreadyQueen(board, n, row) ){
				ans++;
				showBoard(board);
			}else if(isLegal(board, n, row, col) ){
				ans++;
				board[row][col] = 1; //put queen
				showBoard(board);
				// board[row][col] = 0; //reset //Turn on to find all solutions
			}else if(col == n-1){
				//showBoard(board);
				//bad end
			}else{
				board[row][col] = 0; //reset
				ans += queenRecursion(board, n, row, col + 1); //next col
			}
		}else{
			//showBoard(board);
			if(isAlreadyQueen(board, n, row)){
				ans += queenRecursion(board, n, row+1, 0); //next row
			}else if(col == n-1){ //last col
				if(isLegal(board, n, row, col) ){
					board[row][col] = 1; //put queen
					ans += queenRecursion(board, n, row+1, 0); //next row
					if(ans == 0){ //Delete if to find all solutions
						board[row][col] = 0; //reset
					}
				}
			}else{ //not last col
				if(isLegal(board, n, row, col) ){
					board[row][col] = 1; //put queen
					ans += queenRecursion(board, n, row+1, 0); //next row
					if(ans == 0){ //Delete if to find all solutions
						board[row][col] = 0; //reset
						ans += queenRecursion(board, n, row, col + 1); //next col
					}
				}else{
					ans += queenRecursion(board, n, row, col + 1); //next col
				}
			}
		}

		return ans;
	}

	public static boolean isAlreadyQueen(int[][] board, int n, int row){
		for(int i = 0; i < n; i++){
			if(board[row][i] == 1) return true;
		}
		return false;
	}

	public static boolean isLegal(int[][] board, int n, int row, int col){
		//queen is already here
		if(board[row][col] == 1) return false;
		//vertical
		for(int i = 0; i < n; i++){
			if(board[i][col] >= 1 && i != row) return false;
		}
		//horizontal
		for(int i = 0; i < n; i++){
			if(board[row][i] >= 1 && i != col) return false;
		}
		//right up
		for(int i = row + 1, j = col + 1; isIn(n,i,j); i++, j++){
			if(board[i][j] >= 1) return false;
		}
		//right down
		for(int i = row - 1, j = col + 1; isIn(n,i,j); i--, j++){
			if(board[i][j] >= 1) return false;
		}
		//left down
		for(int i = row - 1, j = col - 1; isIn(n,i,j); i--, j--){
			if(board[i][j] >= 1) return false;
		}
		//left up
		for(int i = row + 1, j = col - 1; isIn(n,i,j); i++, j--){
			if(board[i][j] >= 1) return false;
		}
		return true;
	}

	public static boolean isIn(int n, int row, int col){
		if(0 <= row && row < n) if(0 <= col && col < n) return true;
		return false;
	}

	public static void showBoard(int[][] board){
		for(int i = board.length - 1; i >= 0; i--){
			for(int j = 0; j < board.length; j++){
				if(board[i][j] >= 1) System.out.print("* ");
				else System.out.print("- ");
			}
			System.out.println();
		}
		System.out.println();
	}
}