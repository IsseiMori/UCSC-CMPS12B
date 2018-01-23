//Issei Mori
//1612406
//class for knight chess piece
//Knight.java

public class Knight extends ChessPiece{

	public Knight(int newCol, int newRow, int newColor){
		super(newCol, newRow, newColor);
	}

	public String toString(){
		if(this.color == 1 ) return "n";
		else if(this.color == 2) return "N";
		else return "error";
	}

	public char getName(){
		if(this.color == 1 ) return 'n';
		else if(this.color == 2) return 'N';
		else return '-';
	}

	public boolean isAttacking(LinkedList list){
		Node tmp = list.head;
		while(tmp.data != null){
			if(tmp.data.color != this.color && tmp.data.color != 3){
				if(Math.abs(tmp.data.col - this.col) == 1 && Math.abs(tmp.data.row - this.row) == 2) return true;
				if(Math.abs(tmp.data.col - this.col) == 2 && Math.abs(tmp.data.row - this.row) == 1) return true;
			}
			tmp = tmp.next;
		}
		return false;
	}

	public boolean isAttackingThis(LinkedList list, int col, int row){
		if(Math.abs(col - this.col) == 1 && Math.abs(row - this.row) == 2) return true;
		if(Math.abs(col - this.col) == 2 && Math.abs(row - this.row) == 1) return true;
		return false;
	}

	public boolean canMoveTo(LinkedList list, int toCol, int toRow){
		if(isAttackingThis(list,toCol,toRow)) return true;
		return false;
	}
}