//Issei Mori
//1612406
//Output the file that shows if the piece is attacking enemy
//ChessBoard.java

import java.io.*;
import java.util.Scanner;

public class ChessBoard{
	public static void main(String[] args)throws IOException{
		
		if(args.length < 2){
			System.out.println("Usage: java -jar ChessBoard.jar <input file> <output file>");
			System.exit(1);
		}

		try{
			Scanner in = new Scanner(new File(args[0]));
			PrintWriter out = new PrintWriter(new FileWriter(args[1]));

			boolean isValid;
			int querryCol;
			int querryRow;
			int querryNum;

			LinkedList list = new LinkedList();

			while(in.hasNextLine()){
				//Read file
				String line = in.nextLine().trim() + " ";
				String[] tokens = line.split(" ");
				querryCol = Integer.parseInt(tokens[0]);
				tokens[1] = tokens[1].substring(0,1);
				querryRow = Integer.parseInt(tokens[1]);
				querryNum = (querryRow - 1) * 8 + querryCol;
				isValid = true;


				for(int i = 1; i <= 8; i++){
					for(int j = 1; j <= 8; j++){
						list.insert(new Empty(i,j,3));
					}
				}

				int col;
				int row;
				for(int i = 2; i < tokens.length; i+=3){
					col = Integer.parseInt(tokens[i+1]);
					row = Integer.parseInt(tokens[i+2]);

					if(list.findByNum( (row - 1) * 8 + col ).data.color != 3) isValid = false;

					switch(tokens[i]){
						case "q": (list.findByNum( (row - 1) * 8 + col )).data = new Queen(col, row, 1);
							break;
						case "Q": (list.findByNum( (row - 1) * 8 + col )).data = new Queen(col, row, 2);
							break;
						case "r": (list.findByNum( (row - 1) * 8 + col )).data = new Rook(col, row, 1);
							break;
						case "R": (list.findByNum( (row - 1) * 8 + col )).data = new Rook(col, row, 2);
							break;
						case "b": (list.findByNum( (row - 1) * 8 + col )).data = new Bishop(col, row, 1);
							break;
						case "B": (list.findByNum( (row - 1) * 8 + col )).data = new Bishop(col, row, 2);
							break;
						case "n": (list.findByNum( (row - 1) * 8 + col )).data = new Knight(col, row, 1);
							break;
						case "N": (list.findByNum( (row - 1) * 8 + col )).data = new Knight(col, row, 2);
							break;
						case "p": (list.findByNum( (row - 1) * 8 + col )).data = new Pawn(col, row, 1);
							break;
						case "P": (list.findByNum( (row - 1) * 8 + col )).data = new Pawn(col, row, 2);
							break;
						case "k": (list.findByNum( (row - 1) * 8 + col )).data = new King(col, row, 1);
							break;
						case "K": (list.findByNum( (row - 1) * 8 + col )).data = new King(col, row, 2);
							break;
					}
				}

				//list.show();
				for(int i = 8; i > 0; i--){
					for(int j = 1; j <= 8; j++){
						System.out.print( (list.findByNum( (i - 1) * 8 + j ) ).data.getName() + " ");
						//System.out.print( (list.findByNum( (i - 1) * 8 + j ) ).num + " ");
					}
					System.out.println();
				}
				System.out.println();	

				
				if(isValid == false){
					out.println("Invalid");
				}else{
					if((list.findByNum(querryNum)).data.color != 3){
						if((list.findByNum(querryNum)).data.isAttacking(list)){
							out.println((list.findByNum(querryNum)).data + " y");
						}else{
							out.println((list.findByNum(querryNum)).data + " n");
						}

					}else out.println("-");
				}
				

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