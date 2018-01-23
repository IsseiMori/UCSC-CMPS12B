//Issei Mori
//1612406
//class for king chess piece
//King.java

public class King extends ChessPiece{

	public King(int newCol, int newRow, int newColor){
		super(newCol, newRow, newColor);
	}

	public String toString(){
		if(this.color == 1 ) return "k";
		else if(this.color == 2) return "K";
		else return "error";
	}

	public char getName(){
		if(this.color == 1 ) return 'k';
		else if(this.color == 2) return 'K';
		else return '-';
	}

	public boolean isAttacking(LinkedList list){
		Node tmp = list.head;
		while(tmp.data != null){
			if(tmp.data.color != this.color && tmp.data.color != 3){
				if(Math.abs(tmp.data.col - this.col) == 1 && Math.abs(tmp.data.row - this.row) == 1) return true;
				if(Math.abs(tmp.data.col - this.col) == 1 && Math.abs(tmp.data.row - this.row) == 0) return true;
				if(Math.abs(tmp.data.col - this.col) == 0 && Math.abs(tmp.data.row - this.row) == 1) return true;
			}
			tmp = tmp.next;
		}
		return false;
	}

	public boolean isAttackingThis(LinkedList list, int col, int row){
		if(Math.abs(col - this.col) == 1 && Math.abs(row - this.row) == 1) return true;
		if(Math.abs(col - this.col) == 1 && Math.abs(row - this.row) == 0) return true;
		if(Math.abs(col - this.col) == 0 && Math.abs(row - this.row) == 1) return true;
		return false;
	}

	public boolean canMoveTo(LinkedList list, int toCol, int toRow){
		if(isAttackingThis(list,toCol,toRow)) return true;
		return false;
	}

	public boolean isChecked(LinkedList list){
		for(int i = 1; i <= 64; i++){
			if(list.findByNum(i).data.color != this.color && list.findByNum(i).data.canMoveTo(list, this.col, this.row)){
				//System.out.print("checked by " + i + list.findByNum(i).data);
				return true;
			}
		}
		return false;
	}
}