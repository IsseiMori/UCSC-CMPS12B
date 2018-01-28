//Issei Mori
//1612406
//Output the position of queens that don't attack each other from input file
//Bard.java

import java.io.*;
import java.util.*;

public class Bard{
	public static void main(String[] args)throws IOException{
		Hashtable<String,Integer> hash = new Hashtable<String,Integer>();
		int maxWordLength = 0;

		if(args.length < 2){
			System.out.println("Usage: java -jar Bard.jar <input file> <output file>");
			System.exit(1);
		}

		Scanner text = new Scanner(new File("shakespeare.txt"));
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new File(args[1]));

		while(text.hasNextLine()){
			String line = text.nextLine();
			String replaced = line.toLowerCase().replaceAll("[,.:;?!\\[\\]]", " ");
			String[] tokens = (replaced.trim() + " ").split("\\s+");

			for(String token: tokens){
				//System.out.println(token + " " + token.length());
				//put to hashtable or update
				if(hash.get(token) != null) hash.put(token, hash.get(token)+1);
				else  hash.put(token,1);

				//update maxWordLength
				if(maxWordLength < token.length()) maxWordLength = token.length();
			}
		}
		//System.out.println(hash);
		//System.out.println(maxWordLength);

		//Initialize ArrayList of ArrayList
		ArrayList<ArrayList<Word>> list = new ArrayList<ArrayList<Word>>();
		for(int i = 0; i <= maxWordLength; i++){
			list.add(new ArrayList<Word>());
		}

		//hashtable to ArrayList
		for(String key : hash.keySet()){
			list.get(key.length()).add(new Word(key, hash.get(key)));
		}

		//System.out.println(list);

		//Sort by frequency
		for(ArrayList<Word> array : list)
			Collections.sort(array, new Word());

		while(in.hasNextLine()){
			String line = in.nextLine().trim() + " ";
			String[] tokens = line.split("\\s+");

			int wordLength = Integer.parseInt(tokens[0]);
			int rank = Integer.parseInt(tokens[1]);

			if(wordLength > 0 && wordLength <= maxWordLength && rank < list.get(wordLength).size()){
				out.println(list.get(wordLength).get(rank).word);
			}
			else out.println("-");
		}

		text.close();
		in.close();
		out.close();
	}
}