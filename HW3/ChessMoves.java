//Issei Mori
//1612406
//Output the file that shows the move is legal or ilegal
//ChessMoves.java

import java.io.*;
import java.util.Scanner;

public class ChessMoves{
	public static void main(String[] args)throws IOException{
		
		if(args.length < 2){
			System.out.println("Usage: java -jar ChessBoard.jar <input file> <output file>");
			System.exit(1);
		}

		try{
			Scanner in = new Scanner(new File(args[0]));
			PrintWriter out = new PrintWriter(new FileWriter(args[1]));

			boolean isLegal;
			int querryCol;
			int querryRow;
			int querryNum;
			String piece;
			int col,row,num,toCol,toRow;
			int p,i,j;
			int turn; //1 for white 2 for black
			int boardNum = 0;

			LinkedList list = new LinkedList();

			while(in.hasNextLine()){
				boardNum++;
				System.out.println();
				System.out.println();
				System.out.println("Board " + boardNum);

				//reset chess board
				//fill everything with empty chess pieces
				for(i = 1; i <= 8; i++){
					for(j = 1; j <= 8; j++){
						list.insert(new Empty(j,i,3));
					}
				}

				//Read file
				String line = in.nextLine().trim() + " ";
				String[] tokens = line.split("\\s+");

				int whiteChecked = 0;
				int blackChecked = 0;
				isLegal = true;
				int moveCount = 1;

				//Place pieces from the file on the board
				p = 0;
				do{
					piece = tokens[p];
					col = Integer.parseInt(tokens[p+1]);
					row = Integer.parseInt(tokens[p+2].substring(0,1));
					num = (row - 1) * 8 + col;

					if(list.findByNum( num ).data.getName() != 'e'){
						isLegal = false;
						System.out.println("2 pieces at the same place");
					}

					switch(tokens[p]){
						case "q": (list.findByNum( num )).data = new Queen(col, row, 1);
							break;
						case "Q": (list.findByNum( num )).data = new Queen(col, row, 2);
							break;
						case "r": (list.findByNum( num )).data = new Rook(col, row, 1);
							break;
						case "R": (list.findByNum( num )).data = new Rook(col, row, 2);
							break;
						case "b": (list.findByNum( num )).data = new Bishop(col, row, 1);
							break;
						case "B": (list.findByNum( num )).data = new Bishop(col, row, 2);
							break;
						case "n": (list.findByNum( num )).data = new Knight(col, row, 1);
							break;
						case "N": (list.findByNum( num )).data = new Knight(col, row, 2);
							break;
						case "p": (list.findByNum( num )).data = new Pawn(col, row, 1);
							break;
						case "P": (list.findByNum( num )).data = new Pawn(col, row, 2);
							break;
						case "k": (list.findByNum( num )).data = new King(col, row, 1);
							break;
						case "K": (list.findByNum( num )).data = new King(col, row, 2);
							break;
					}

					p+=3;
				}while(tokens[p-1].length() == 1);

				list.showBoard();


				//Move pieces
				turn = 1;
				if(!isLegal) out.println(Integer.parseInt(tokens[p]) + " " + Integer.parseInt(tokens[p+1]) + " " + Integer.parseInt(tokens[p+2]) + " " + Integer.parseInt(tokens[p+3]) + " illegal");
				for(i = 0; i < tokens.length - p && isLegal == true; i+=4 ){
					col = Integer.parseInt(tokens[p+i]);
					row = Integer.parseInt(tokens[p+i+1]);
					toCol = Integer.parseInt(tokens[p+i+2]);
					toRow = Integer.parseInt(tokens[p+i+3]);

					ChessPiece start = list.findByColRow(col, row).data;
					ChessPiece goal  = list.findByColRow(toCol, toRow).data;

					//System.out.println(col + " " + row + " " + toCol + " " + toRow);
					//System.out.println(start.canMoveTo(list, toCol,toRow));

					//Ilegal if the piece's color is not the color of player of this turn
					if(start.color != turn){
						isLegal = false;
						System.out.println("trying to move opponent");
					}
					//Ilegal if the piece's color at destination is the same as the piece the player is moving 
					else if(start.color == goal.color){
						isLegal = false;
						System.out.print("your piece is at the destination");
					}
					//Ilegal if the destination is not on the piece's move or other pices on the path
					else if(!start.canMoveTo(list, toCol,toRow)){
						isLegal = false;
						System.out.print("the piece does not to the destination");
					}
					else if(turn == 1 && list.findKing(2).data.isChecked(list)){
						isLegal = false;
						System.out.print("black is checked from the beginning");
					}
					else if(isLegal){
						ChessPiece tmp = start;
						list.findByColRow(col,row).data = new Empty(col,row,3);
						list.findByColRow(toCol,toRow).data = tmp;
						list.findByColRow(toCol,toRow).data.setCol(toCol);
						list.findByColRow(toCol,toRow).data.setRow(toRow);

						if(list.findKing(1).data.isChecked(list)){
							whiteChecked++;
							if(whiteChecked > 1 || turn == 1){
								isLegal = false;
								System.out.println("white lost");
							}
						}else whiteChecked = 0;

						if(list.findKing(2).data.isChecked(list)){
							blackChecked++;
							if(blackChecked > 1 || turn == 2){
								isLegal = false;
								System.out.println("black lost");
							}
						}else blackChecked = 0;
					}
					list.showBoard();
					//System.out.println(isLegal);

					if(!isLegal) out.println(col + " " + row + " " + toCol + " " + toRow + " illegal");

					moveCount++;
					turn = turn%2+1;
				}

				if(isLegal) out.println("legal");
				list.showBoard();
				System.out.println(isLegal);

				list.deleteAll();
			}

			in.close();
			out.close();
		}catch(Exception e) {
            System.out.println("Error");
			System.exit(1);
        }

	}
}