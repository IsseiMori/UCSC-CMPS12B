//Issei Mori
//1612406
//class for rook chess piece
//Rook.java

public class Rook extends ChessPiece{

	public Rook(int newCol, int newRow, int newColor){
		super(newCol, newRow, newColor);
	}

	public String toString(){
		if(this.color == 1 ) return "r";
		else if(this.color == 2) return "R";
		else return "error";
	}

	public char getName(){
		if(this.color == 1 ) return 'r';
		else if(this.color == 2) return 'R';
		else return '-';
	}

	public boolean isAttacking(LinkedList list){
		Node tmp = list.head;
		while(tmp.data != null){
			if(tmp.data.color != this.color && tmp.data.color != 3){
				if(tmp.data.col == this.col) return true;
				if(tmp.data.row == this.row) return true;
			}
			tmp = tmp.next;
		}
		return false;
	}

	public boolean isAttackingThis(LinkedList list, int col, int row){
		if(col == this.col) return true;
		if(row == this.row) return true;
		return false;
	}

	public boolean canMoveTo(LinkedList list, int toCol, int toRow){
		if(!isAttackingThis(list,toCol,toRow)) return false;
		int i = col;
		int j = row;
		i += (int)((double)(toCol-col) / ((double)(Math.abs(toCol-col)) - 0.1));
		j += (int)((double)(toRow-row) / ((double)(Math.abs(toRow-row)) - 0.1));
		//System.out.println(i + " " + j);
		while(i != toCol || j != toRow){
			//System.out.println(i + " " + j);
			if(list.findByColRow(i,j).data.getName() != 'e') return false;

			i += (int)((double)(toCol-col) / ((double)(Math.abs(toCol-col)) - 0.1));
			j += (int)((double)(toRow-row) / ((double)(Math.abs(toRow-row)) - 0.1));
		}
		return true;
	}
}