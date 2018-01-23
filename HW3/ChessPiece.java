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
	public abstract boolean isAttackingThis(LinkedList list, int col, int row);
	public abstract boolean canMoveTo(LinkedList list, int toCol, int toRow);

	public boolean isChecked(LinkedList list){
		return false;
	}

	public ChessPiece(int newCol, int newRow, int newColor){
		col = newCol;
		row = newRow;
		color = newColor;
	}

	public int getCol(){
		return col;
	}

	public void setCol(int newCol){
		col = newCol;
	}

	public int getRow(){
		return row;
	}

	public void setRow(int newRow){
		row = newRow;
	}

	public int getColor(){
		return color;
	}

	public void setColor(int newColor){
		color = newColor;
	}
}