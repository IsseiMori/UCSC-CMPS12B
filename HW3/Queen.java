//Issei Mori
//1612406
//class for queen chess piece
//Queen.java

public class Queen extends ChessPiece{

	public Queen(int newCol, int newRow, int newColor){
		super(newCol, newRow, newColor);
	}

	public String toString(){
		if(this.color == 1 ) return "q";
		else if(this.color == 2) return "Q";
		else return "error";
	}

	public char getName(){
		if(this.color == 1 ) return 'q';
		else if(this.color == 2) return 'Q';
		else return '-';
	}

	public boolean isAttacking(LinkedList list){
		Node tmp = list.head;
		while(tmp.data != null){
			if(tmp.data.color != this.color && tmp.data.color != 3){
				if(tmp.data.col == this.col) return true;
				if(tmp.data.row == this.row) return true;
				if(Math.abs(tmp.data.col - this.col) == Math.abs(tmp.data.row - this.row)) return true;
			}
			tmp = tmp.next;
		}
		return false;
	}

	public boolean isAttackingThis(LinkedList list, int col, int row){
		if(col == this.col) return true;
		if(row == this.row) return true;
		if(Math.abs(col - this.col) == Math.abs(row - this.row)) return true;
		return false;
	}

	public boolean canMoveTo(LinkedList list, int toCol, int toRow){
		if(!isAttackingThis(list,toCol,toRow)) return false;
		int i = this.col;
		int j = this.row;
		i += (int)((double)(toCol-col) / ((double)(Math.abs(toCol-col)) - 0.1));
		j += (int)((double)(toRow-row) / ((double)(Math.abs(toRow-row)) - 0.1));
		while(i != toCol || j != toRow){
			//System.out.println(i + " " + j + " " + toCol + " " + toRow);
			if(list.findByColRow(i,j).data.getName() != 'e') return false;
			i += (int)((double)(toCol-col) / ((double)(Math.abs(toCol-col)) - 0.1));
			j += (int)((double)(toRow-row) / ((double)(Math.abs(toRow-row)) - 0.1));
		}
		return true;
	}
}