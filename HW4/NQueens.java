//Issei Mori
//1612406
//Output the position of queens that don't attack each other from input file
//NQueens.java

import java.io.*;
import java.util.*;

public class NQueens{
	public static void main(String[] args)throws IOException{

	    // check number of command line arguments is at least 2
	    if(args.length < 2){
	        System.out.println("Usage: java –jar NQueens.jar <input file> <output file>");
	      	System.exit(1);
    	}

		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));

		int iniCol,iniRow;
		//false when needs to go out the loop
		boolean solution = true;

		while(in.hasNextLine()){
			String line = in.nextLine().trim() + " ";
			String[] tokens = line.split("\\s+");
			int size = Integer.parseInt(tokens[0]);
			Stack<Queen> queensSt = new Stack<Queen>();

			for(int i = 1; i < tokens.length; i+=2){
				iniCol = Integer.parseInt(tokens[i]);
				iniRow = Integer.parseInt(tokens[i+1]);
				System.out.println("queen " + iniCol + " " + iniRow);
				queensSt.push(new Queen(iniCol,iniRow, false));
			}

			int col = 1, row = 1;
			int iniSize = queensSt.size();

			showBoard(queensSt, size);

			while(queensSt.size()<size && queensSt.size() >= iniSize){
				Queen new_queen = new Queen(col, row, true);
				//System.out.println(col + " " + row);
				//go to next row if there is non movable piece in the same row
				if(isQueenInTheRow(queensSt, new_queen)){
					row++;
					col=1;
				}
				else{
					queensSt.push(new_queen);
					//showBoard(queensSt, size);
					//The board is legal
					if(isLegal(queensSt)){
						row++;
						col=1;
					}
					//The board is not legal
					else{
						queensSt.pop();
						//queen is at the last col
						if(col == size){
							//only initial queens left, no solution
							if(!queensSt.peek().movable) queensSt.pop();
							else if(queensSt.peek().col == size){
								queensSt.pop();
								if(!queensSt.peek().movable) queensSt.pop();
								else{
									row = queensSt.peek().row;
									col = queensSt.peek().col+1;
									queensSt.pop();
								}
							}else{
								row = queensSt.peek().row;
								col = queensSt.peek().col+1;
								queensSt.pop();
							}
						}
						//queen is not at the last col
						else{
							col++;
						}
					}
				}
			}

			//Solution is found
			if(queensSt.size() >= size){
				Queen[] array = stackToArray(queensSt);
				for(int i = 1; i <= size; i++){
					for(int j = 0; j < size; j++){
						if(array[j].col == i) out.print(array[j].col + " " + array[j].row + " ");
					}
				}
				out.println();
			}
			else out.println("No solution");
			showBoard(queensSt, size);

		}

		in.close();
		out.close();
	}

	public static boolean isQueenInTheRow(Stack<Queen> queensSt, Queen queen){
		Queen[] array = stackToArray(queensSt);
		for(int i = 0; i < array.length; i++){
			if(array[i].row == queen.row) return true;
		}
		return false;
	}

	public static boolean isLegal(Stack<Queen> queensSt){
		Queen[] array = stackToArray(queensSt);
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length; j++){
				if(i!=j){
					if(array[i].col == array[j].col) return false;
					if(array[i].row == array[j].row) return false;
					if(Math.abs(array[i].col - array[j].col) == Math.abs(array[i].row - array[j].row)) return false;
				}
			}
		}
		return true;
	}

	public static Queen[] stackToArray(Stack<Queen> queensSt){
		int size = queensSt.size();
		Queen[] array = new Queen[size];
		for(int i = 0; i < size; i++){
			array[i] = queensSt.pop();
		}
		for(int i = size-1; i >= 0; i--){
			queensSt.push(array[i]);
		}
		return array;
	}

	public static void printStack(Stack<Queen> queenSt){
		while(!queenSt.empty()){
			System.out.println(queenSt.pop());
		}
		System.out.println();
	}

	public static void showBoard(Stack<Queen> queenSt, int size){
		boolean board[][] = new boolean[size+1][size+1];
		Queen array[] = stackToArray(queenSt);
		for(int col = 1; col <= size; col++){
			for(int row = 1; row <= size; row++){
				board[col][row] = false;
			}
		}

		for(int i = 0; i < array.length; i++){
			board[array[i].col][array[i].row] = true;
		}

		for(int row = size; row >= 1; row--){
			for(int col = 1; col <= size; col++){
				if(board[col][row]) System.out.print("* ");
				else System.out.print("- ");
			}
			System.out.println();
		}
		System.out.println();
	}
}