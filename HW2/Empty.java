//Issei Mori
//1612406
//class for empty chess piece
//Empty.java

public class Empty extends ChessPiece{

	public Empty(int newCol, int newRow, int newColor){
		super(newCol, newRow, newColor);
	}

	public String toString(){
		return "e";
	}

	public char getName(){
		return 'e';
	}

	public boolean isAttacking(LinkedList list){
		return false;
	}
}