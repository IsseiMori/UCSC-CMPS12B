//Issei Mori
//1612406
//class for bishop chess piece
//Bishop.java

public class Bishop extends ChessPiece{

	public Bishop(int newCol, int newRow, int newColor){
		super(newCol, newRow, newColor);
	}

	public String toString(){
		if(this.color == 1 ) return "b";
		else if(this.color == 2) return "B";
		else return "error";
	}

	public char getName(){
		if(this.color == 1 ) return 'b';
		else if(this.color == 2) return 'B';
		else return '-';
	}

	public boolean isAttacking(LinkedList list){
		Node tmp = list.head;
		while(tmp.data != null){
			if(tmp.data.color != this.color && tmp.data.color != 3){
				if(Math.abs(tmp.data.col - this.col) == Math.abs(tmp.data.row - this.row)) return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
}