//Issei Mori
//1612406
//class for queen chess piece
//Queen.java

public class Queen{
	int col;
	int row;
	boolean movable;
	public Queen(int newCol, int newRow, boolean newMovable){
		col = newCol;
		row = newRow;
		movable = newMovable;
	}

	public String toString(){
		String retVal = "";
		retVal = Integer.toString(col) + " " + Integer.toString(row) + " " + movable;
		return retVal;
	}

	public boolean equals(Object obj){
		Queen cell = (Queen)obj;
		
		if(col == cell.col && row == cell.row && movable == cell.movable) return true;
		return false;
	}
}