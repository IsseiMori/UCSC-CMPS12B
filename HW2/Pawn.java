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
			if(tmp.data.color != this.color && tmp.data.color != 3){
				//same col
				if(tmp.data.col == this.col){
					//white
					if(this.color == 1){
						if(tmp.data.row == this.row+1 || tmp.data.row == this.row+2) return true;
					}
					//black
					if(this.color == 2){
						if(tmp.data.row == this.row-1 || tmp.data.row == this.row-2) return true;
					}
				}
				
			}
			tmp = tmp.next;
		}
		return false;
	}
}