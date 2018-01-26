//Issei Mori
//1612406
//Output the position of queens that don't attack each other from input file
//NQueens.java

import java.io.*;
import java.util.*;

public class StackTest{
	public static void main(String[] args){

		Queen c1 = new Queen(3,1,true);
		Queen c2 = new Queen(1,2,true);
		Stack<Queen> stCell = new Stack<Queen>();
		stCell.push(c1);
		stCell.push(c2);

		System.out.println(stCell.get(0).col);

		Queen[] array = stackToArray(stCell);

		System.out.print(array[1]);

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
}

