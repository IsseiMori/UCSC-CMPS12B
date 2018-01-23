//Issei Mori
//1612406
//class for pawn chess piece
//Pawn.java

public class Pawn extends ChessPiece{

	public Pawn(int newCol, int newRow, int newColor){
		super(newCol, newRow, newColor);
	}

	public String toString(){
		if(this.color == 1 ) return "p";
		else return "P";
	}

	public char getName(){
		if(this.color == 1 ) return 'p';
		else if(this.color == 2) return 'P';
		else return '-';
	}

	public boolean isAttacking(LinkedList list){
		Node tmp = list.head;
		while(tmp.data != null){
			//different color
			if(tmp.data.color != this.color && tmp.data.color != 3){
				//white
				if(this.color == 1){
					if(tmp.data.row == this.row+1)
						if(tmp.data.col == this.col-1 || tmp.data.col == this.col+1) return true;
				}
				//black
				if(this.color == 2){
					if(tmp.data.row == this.row-1)
						if(tmp.data.col == this.col-1 || tmp.data.col == this.col+1) return true;
				}
				
			}
			tmp = tmp.next;
		}
		return false;
	}

	public boolean isAttackingThis(LinkedList list, int col, int row){
		//white
		if(this.color == 1){
			if(row == this.row+1)
				if(col == this.col-1 || col == this.col+1) return true;
		}
		//black
		if(this.color == 2){
			if(row == this.row-1)
				if(col == this.col-1 || col == this.col+1) return true;
		}
		return false;
	}

	public boolean canMoveTo(LinkedList list, int toCol, int toRow){
		if(isAttackingThis(list,toCol,toRow)) return true;
		if(this.color == 1){
			if(this.col == toCol)
				if(toRow == this.row+1 || toRow == this.row+2)
					if(list.findByColRow(this.col+1,this.row+1).data.getName() == 'e') return true;
		}
		if(this.color == 2){
			if(this.col == toCol)
				if(toRow == this.row-1 || toRow == this.row-2)
					if(list.findByColRow(this.col-1,this.row-1).data.getName() == 'e') return true;
		}
		return false;
	}
}