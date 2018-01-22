//Issei Mori
//1612406
//parent class for each chess piece
//ChessPiece.java

public abstract class ChessPiece{
	int col;
	int row;
	int color; //1 for white, 2 for black(capitalized)

	public abstract boolean isAttacking(LinkedList list);
	public abstract char getName();

	public ChessPiece(int newCol, int newRow, int newColor){
		col = newCol;
		row = newRow;
		color = newColor;
	}
}