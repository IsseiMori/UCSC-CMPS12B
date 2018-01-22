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
}