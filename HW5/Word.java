//Issei Mori
//1612406
//class for queen chess piece
//Queen.java

import java.util.*;

class Word implements Comparator<Word>, Comparable<Word>{
	String word;
	Integer freq;

	Word(){
	}

	public Word(String newWord, Integer newFreq){
		word = newWord;
		freq = newFreq;
	}

	public String toString(){
		String retVal = "";
		retVal = word + " " +Integer.toString(freq);
		return retVal;
	}

	public int compareTo(Word w){
		if( (this.freq).compareTo(w.freq) == 0){
			return (this.word).compareTo(w.word);
		}
		return w.freq - this.freq;
	}

	public int compare(Word w1, Word w2){
		if( (w1.freq ).compareTo(w2.freq) == 0){
			return (w1.word).compareTo(w2.word);
		}
		return w2.freq - w1.freq;
	}
}