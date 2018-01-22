//Issei Mori
//1612406
//Output the file that shows if the piece is attacking enemy
//ChessBoard.java

import java.io.*;
import java.util.Scanner;

public class test{
	public static void main(String[] args){
		
		LinkedList list = new LinkedList();
		list.insert(new Queen(1,1,1));
		list.insert(new Queen(2,1,1));
		list.insert(new Queen(2,1,1));
		list.insert(new Queen(2,1,1));

		list.show();
	}
}