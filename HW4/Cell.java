//Issei Mori
//1612406
//class for queen chess piece
//Queen.java

public class Cell{
	int col;
	int row;
	public Cell(int newCol, int newRow){
		col = newCol;
		row = newRow;
	}

	public String toString(){
		String retVal = "";
		retVal = Integer.toString(col) + " " + Integer.toString(row);
		return retVal;
	}

	public boolean equals(Object obj){
		Cell cell = (Cell)obj;
		
		if(col == cell.col && row == cell.row) return true;
		return false;
	}
}