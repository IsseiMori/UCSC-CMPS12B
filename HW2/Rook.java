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
}