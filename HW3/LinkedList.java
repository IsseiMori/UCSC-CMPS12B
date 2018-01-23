//Issei Mori
//1612406
//Linked List class
//LinkedList.java

public class LinkedList{
 	Node head;

	public LinkedList(){
		head = new Node(null);
		head.next = null;
		head.num = 0;
	}

	public void insert(ChessPiece newData){
		Node latest = new Node(newData);
		latest.next = head;
		latest.num = head.num+1;
		head = latest;
	}

	public void deleteAll(){
		head.next = null;
		head.data = null;
		head.num = 0;
	}

	
	public void show(){
		Node tmp = head;
		while(tmp.data != null){
			System.out.println(tmp.num + " " + tmp.data);
			tmp = tmp.next;
		}
	}

	public void showBackwards(Node curr){
		if(curr != null){
			showBackwards(curr.next);
			System.out.println(curr.data);
		}
	}

	public void showBoard(){
		System.out.println();
		for(int i = 8; i > 0; i--){
			System.out.print(i + " ");
			for(int j = 1; j <= 8; j++){
				//if(findByColRow(j,i).data.getName() == 'e' ) System.out.print(findByColRow(j,i).data.getCol() + "- ");
				//else System.out.print( findByColRow(j,i).data + "" + findByColRow(j,i).data.getCol() + " " );
				if(findByColRow(j,i).data.getName() == 'e' ) System.out.print("- ");
				else System.out.print( findByColRow(j,i).data + " " );
			}
			System.out.println();
		}
		System.out.println("  1 2 3 4 5 6 7 8");
	}

	public void reverse(){
		Node prev = null;
		Node curr = head;

		while(curr != null){
			Node foo = curr.next;
			curr.next = prev;
			prev = curr;
			curr = foo;
		}
		head = prev;
	}

	public Node findByNum(int n){
		Node tmp = head;
		while(tmp.data != null){
			if(tmp.num == n) return tmp;
			tmp = tmp.next;
		}
		return null;
	}

	public Node findByCol(int col){
		Node tmp = head;
		while(tmp.data != null){
			if(tmp.data.col == col) return tmp;
			tmp = tmp.next;
		}
		return null;
	}

	public Node findByRow(int row){
		Node tmp = head;
		while(tmp.data != null){
			if(tmp.data.row == row) return tmp;
			tmp = tmp.next;
		}
		return null;
	}

	public Node findByColRow(int col, int row){
		Node tmp = head;
		return findByNum((row - 1) * 8 + col);
	}

	public Node findKing(int color){
		Node tmp = head;
		while(tmp.data != null){
			if(color == 1 && tmp.data.getName() == 'k') return tmp;
			if(color == 2 && tmp.data.getName() == 'K') return tmp;
			tmp = tmp.next;
		}
		return null;
	}

	public Node delete(int num){
		Node prev = null;
		Node curr = head;

		while(curr.num != num){
			prev = curr;
			curr = curr.next;
		}
		if(curr == null) return null;
		else if(prev == null){
			head = curr.next;

		}else{
			prev.next = curr.next;
		}
		return curr;
	}

	public boolean isLooping(){
		Node slow = head;
		Node fast = head.next;
		while(fast != null){
			if(fast.next == slow) return true;
			if(fast.next.next == slow) return true;
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}

}